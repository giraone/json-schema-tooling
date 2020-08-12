package com.giraone.jsonschema.rest;

import de.codecentric.hikaku.Hikaku;
import de.codecentric.hikaku.HikakuConfig;
import de.codecentric.hikaku.converters.openapi.OpenApiConverter;
import de.codecentric.hikaku.converters.spring.SpringConverter;
import de.codecentric.hikaku.endpoints.Endpoint;
import de.codecentric.hikaku.reporters.CommandLineReporter;
import de.codecentric.hikaku.reporters.Reporter;
import kotlin.jvm.functions.Function1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Versuch OpenAPI-Spec gegen die Implementierung zu validieren (hs).
 */
@SpringBootTest
public class OpenApiSpecificationTest {

    @Autowired
    private ApplicationContext springContext;

    @Test
    public void specification_matches_implementation() {

        List<Function1<Endpoint, Boolean>> filters = new ArrayList<>();
        filters.add(SpringConverter.IGNORE_ERROR_ENDPOINT);

        List<Reporter> reporters = new ArrayList<>();
        reporters.add(new CommandLineReporter());

        String openApiFile = "src/main/resources/api/open-api.yaml";

        new Hikaku(
            new OpenApiConverter(Paths.get(openApiFile)),
            new SpringConverter(springContext),
            new HikakuConfig(
                reporters,
                filters
            )
        ).match();
    }
}