package com.giraone.jsonschema.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.giraone.jsonschema.JsonschemaApplication;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.matchesRegex;
import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = JsonschemaApplication.class)
@AutoConfigureMockMvc
class PersonResourceIT {

    private static final String BASE_URL_FORMAT = "/api/v%d/persons";

    @Autowired
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final TypeReference<HashMap<String,Object>> typeRefMap = new TypeReference<>() {};

    private static UUID id1;
    private static Map<String, Object> currentData1;

    static {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    @Autowired
    private MockMvc mockMvc;

    @ForAllVersions
    @Order(1)
    public void insertNew(int apiVersion) throws Exception {

        Map<String, Object> payload = Map.of(
            "first_name", "John",
            "last_name", "Doe",
            "date_of_birth", "1977-12-31",
            "gender", "M"
        );

        String response = mockMvc.perform(post(buildUrl(apiVersion))
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(payload)))
            //.andDo(print())
            .andExpect(status().isCreated())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(matchesRegex("^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$")))
            .andExpect(jsonPath("$.first_name").value("John"))
            .andExpect(jsonPath("$.last_name").value("Doe"))
            .andExpect(jsonPath("$.date_of_birth").value("1977-12-31"))
            .andExpect(jsonPath("$.gender").value("M"))
            .andExpect(jsonPath("$.age").value(42))
            .andExpect(jsonPath("$.creation_date_time").value(startsWith("2020")))
            .andReturn().getResponse().getContentAsString();

        currentData1 = objectMapper.readValue(response, typeRefMap);
        assertThat(currentData1).isNotNull();
        assertThat(currentData1.get("id")).isNotNull();
        id1 = UUID.fromString((String) currentData1.get("id"));
        assertThat(id1).isNotNull();
    }

    @ForAllVersions
    @Order(2)
    public void getOneById(int apiVersion) throws Exception {

        mockMvc.perform(get(buildUrl(apiVersion) + "/" + id1.toString()))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(id1.toString()))
            .andExpect(jsonPath("$.first_name").value("John"))
            .andExpect(jsonPath("$.last_name").value("Doe"))
            .andExpect(jsonPath("$.date_of_birth").value("1977-12-31"))
            .andExpect(jsonPath("$.gender").value("M"))
            .andExpect(jsonPath("$.age").value(42))
            .andExpect(jsonPath("$.creation_date_time").value(startsWith("2020")))
        ;
    }

    @ForAllVersions
    @Order(3)
    public void getAll(int apiVersion) throws Exception {

        mockMvc.perform(get(buildUrl(apiVersion)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.[0].id").value(id1.toString()))
            .andExpect(jsonPath("$.[0].first_name").value("John"))
            .andExpect(jsonPath("$.[0].last_name").value("Doe"))
            .andExpect(jsonPath("$.[0].date_of_birth").value("1977-12-31"))
            .andExpect(jsonPath("$.[0].gender").value("M"))
            .andExpect(jsonPath("$.[0].age").value(42))
            .andExpect(jsonPath("$.[0].creation_date_time").value(startsWith("2020")))
        ;
    }

    @ForAllVersions
    @Order(4)
    public void updateExisting(int apiVersion) throws Exception {

        Map<String, Object> payload = new HashMap<>(currentData1);
        payload.put("first_name", "Jane");
        payload.put("gender", "M");

        String response = mockMvc.perform(put(buildUrl(apiVersion) + "/" + id1.toString())
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(payload)))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(id1.toString()))
            .andExpect(jsonPath("$.first_name").value("Jane"))
            .andExpect(jsonPath("$.last_name").value("Doe"))
            .andExpect(jsonPath("$.date_of_birth").value("1977-12-31"))
            .andExpect(jsonPath("$.gender").value("M"))
            .andExpect(jsonPath("$.age").value(42))
            .andExpect(jsonPath("$.creation_date_time").value(startsWith("2020")))
            .andReturn().getResponse().getContentAsString();

        currentData1 = objectMapper.readValue(response, typeRefMap);
    }

    @ForAllVersions
    @Order(5)
    public void updateSelective(int apiVersion) throws Exception {

        Map<String, Object> op1 = Map.of("op", "replace", "path", "/date_of_birth", "value", "1972-11-30");
        Map<String, Object> op2 = Map.of("op", "add", "path", "/location", "value",
            Map.of("latitude", 10.0, "longitude", 11.1));
        List<Map<String, Object>> ops = List.of(op1, op2);

        String response = mockMvc.perform(patch(buildUrl(apiVersion) + "/" + id1.toString())
            .contentType("application/json-patch+json")
            .content(objectMapper.writeValueAsString(ops)))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(id1.toString()))
            .andExpect(jsonPath("$.first_name").value("Jane"))
            .andExpect(jsonPath("$.last_name").value("Doe"))
            .andExpect(jsonPath("$.date_of_birth").value("1972-11-30"))
            .andExpect(jsonPath("$.gender").value("M"))
            .andExpect(jsonPath("$.age").value(47))
            .andExpect(jsonPath("$.creation_date_time").value(startsWith("2020")))
            .andExpect(jsonPath("$.location.latitude").value(10.0))
            .andExpect(jsonPath("$.location.longitude").value(11.1))
            .andReturn().getResponse().getContentAsString();

        currentData1 = objectMapper.readValue(response, typeRefMap);
    }

    @ForAllVersions
    @Order(6)
    public void deleteById(int apiVersion) throws Exception {

        mockMvc.perform(delete(buildUrl(apiVersion) + "/" + id1.toString()))
            .andDo(print())
            .andExpect(status().isNoContent());
        currentData1 = null;
    }

    //-------------------------------------------------------------------------------

    private String buildUrl(int apiVersion) {

        return String.format(BASE_URL_FORMAT, apiVersion);
    }
}