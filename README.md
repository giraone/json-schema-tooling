# Working with JSON Schema and OpenAPI 3.X

Shows "contract first" using OpenAPI 3.0 and JSON Schema in Spring Boot.

Within the project I want to find out
- what are the negative side effects of [OpenAPITools/openapi-generator](https://github.com/OpenAPITools/openapi-generator) for *Spring*
- whether using [JSON-Schema to Java](http://www.jsonschema2pojo.org/) is an alternative

### Alternative (1) - Use OpenAPITools for API interfaces and API models

```xml
          <apiPackage>com.giraone.jsonschema.api</apiPackage>
          <modelPackage>com.giraone.jsonschema.apimodels</modelPackage>

          <generateModels>true</generateModels>
          <generateApis>true</generateApis>
```

### Alternative (2) - Use OpenAPITools for API interfaces and jsonschema2pojo for API models

```xml
          <apiPackage>com.giraone.jsonschema.api</apiPackage>
          <modelPackage>com.giraone.jsonschema.models</modelPackage>

          <generateModels>false</generateModels>
          <generateApis>true</generateApis>
```

## Links

- https://swagger.io/specification/
- https://editor.swagger.io/
- [JSON-Schema to Java](http://www.jsonschema2pojo.org/)
- [OpenAPITools/openapi-generator](https://github.com/OpenAPITools/openapi-generator)

## Differences

- Inheritance
  - jsonschema2pojo supports `"extends": $ref ...`
  - OpenAPITools supports `- allOf: ...`
- Builder patterns
  - jsonschema2pojo uses a *withAttributeName()* builder pattern
  - OpenAPITools uses a *attributeName()* builder pattern
- Usage of Java primitives (int, long, ...)
  - jsonschema2pojo supports primitives
- type=string/format=date
  - jsonschema2pojo DOES NOT support this
  - OpenAPITools creates `LocalDate`
- type=string/format=date-time
  - jsonschema2pojo creates `java.util.Date` (TODO: how can this be changed?)
  - OpenAPITools creates `OffsetDateTime`, which can be changed e.g. by `<typeMappings>OffsetDateTime=java.time.LocalDateTime</typeMappings>` (see pom.xml for details)
- Usage of Java 8 date types (LocalDate, ...)
        
## Validate my test schemas

### Approach (1) - using swagger-cli

```
npm i -g swagger-cli
# Validate
swagger-cli validate src/main/resources/api/open-api.yaml
```

### Approach (2) - using https://editor.swagger.io/

```
# Build a bundle (single) file
swagger-cli bundle -r -t yaml -w 140 -o src/main/resources/api/open-api-bundled.yaml src/main/resources/api/open-api.yaml
swagger-cli bundle -r -t json -w 140 -o src/main/resources/api/open-api-bundled.json src/main/resources/api/open-api.yaml
# Load these files to https://editor.swagger.io/
```

## Open Issues

- `snake_case` JSON notation on the wire

