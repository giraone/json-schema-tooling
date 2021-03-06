package com.giraone.jsonschema.rest.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.giraone.jsonschema.api.v1.PersonApi;
import com.giraone.jsonschema.models.v1.PatchEntry;
import com.giraone.jsonschema.models.v1.PersonBase;
import com.giraone.jsonschema.models.v1.PersonFull;
import com.giraone.jsonschema.models.v1.Problem;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.YEARS;

@RestController("PersonResourceV1")
@RequestMapping("/api/v1")
public class PersonResource implements PersonApi {

    private final Logger log = LoggerFactory.getLogger(PersonResource.class);

    private final ObjectMapper objectMapper = new ObjectMapper(); // for PATCH

    private final Map<UUID, PersonFull> repository = new HashMap<>();

    /**
     * Insert a new person to the repository. If no id is given it will be generated.
     * @param person The person to add
     * @return The added person extended by some calculated values.
     */
    @PostMapping("/persons")
    public ResponseEntity<PersonFull> insertNew(@Valid @RequestBody PersonBase person) {

        log.debug("POST {}", person);
        PersonFull newPerson = new PersonFull()
            .id(person.getId() != null ? person.getId() : UUID.randomUUID())
            .firstName(person.getFirstName())
            .lastName(person.getLastName())
            .dateOfBirth(person.getDateOfBirth())
            .gender(person.getGender())
            .deceased(person.getDeceased())
            .comment(person.getComment())
            .location(person.getLocation())
            // Calculated
            .creationDateTime(LocalDateTime.now())
            ;
        updateCalculatedValues(newPerson);

        repository.put(newPerson.getId(), newPerson);
        final URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(newPerson.getId())
            .toUri();
        return ResponseEntity.created(location).body(newPerson);
    }

    @PutMapping(value = "/persons/{id}")
    public ResponseEntity<PersonFull> updateExisting(@PathVariable UUID id, @Valid @RequestBody PersonBase person) {

        log.debug("PUT id={}, person={}", id, person);
        PersonFull existingPerson = repository.get(id);
        if (existingPerson == null) {
            return ResponseEntity.notFound().build();
        }
        existingPerson
            .firstName(person.getFirstName())
            .lastName(person.getLastName())
            .dateOfBirth(person.getDateOfBirth())
            .gender(person.getGender())
            .deceased(person.getDeceased())
            .comment(person.getComment())
            .location(person.getLocation())
        ;
        updateCalculatedValues(existingPerson);
        return ResponseEntity.ok(existingPerson);
    }

    @Override
    public ResponseEntity<PersonFull> updateSelective(UUID id, @Valid List<PatchEntry> patchEntry) {

        JsonPatch jsonPatch = null;
        try {
            jsonPatch = JsonPatch.fromJson(objectMapper.readTree(objectMapper.writeValueAsString(patchEntry)));
        } catch (IOException e) {
            e.printStackTrace();
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new Problem()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .detail("PatchEntry conversion failed.")
            );
        }
        return updateSelective(id, jsonPatch);
    }

    @PatchMapping(path = "/persons/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<PersonFull> updateSelective(@PathVariable UUID id, @Valid @RequestBody JsonPatch patch) {

        log.debug("PATCH id={}, patch={}", id, patch);
        PersonFull existingPerson = repository.get(id);
        if (existingPerson == null) {
            return ResponseEntity.notFound().build();
        }
        JsonNode patched;
        try {
            patched = patch.apply(objectMapper.convertValue(existingPerson, JsonNode.class));
            PersonFull updatedPerson = objectMapper.treeToValue(patched, PersonFull.class);
            updateCalculatedValues(updatedPerson);
            repository.put(id, updatedPerson);
            return ResponseEntity.ok(updatedPerson);
        } catch (JsonPatchException | JsonProcessingException e) {
            log.warn("cannot process {}", patch, e);
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Return all persons.
     * @param limit Optional limit for the number of returned persons.
     * @return A list of persons.
     */
    @GetMapping("/persons")
    public ResponseEntity<List<PersonFull>> getAll(@RequestParam(required = false) Integer limit) {

        log.debug("GET");
        Collection<PersonFull> persons = repository.values();
        List<PersonFull> ret = persons.stream()
            .limit(limit != null ? limit : 10000)
            .collect(Collectors.toList());
        return ResponseEntity.ok(ret);
    }

    /**
     * Returns a person based on a given ID.
     * @param id The UUID of the person to fetch.
     * @return a person, if one was found for the given id.
     */
    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonFull> getOneById(@PathVariable UUID id) {

        log.debug("GET {}", id);
        PersonFull existingPerson = repository.get(id);
        if (existingPerson != null) {
            return ResponseEntity.ok(existingPerson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete a single person based on the ID supplied.
     * @param id The UUID of the person to delete.
     * @return Void
     */
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {

        log.debug("GET {}", id);
        PersonFull existingPerson = repository.get(id);
        if (existingPerson != null) {
            repository.remove(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    private void updateCalculatedValues(PersonFull p) {

        p.age((int) YEARS.between(p.getDateOfBirth(), LocalDate.now()));
    }
}
