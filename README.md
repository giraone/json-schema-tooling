# Working with JSON Schema and OpenAPI 3.X

Shows "contract first" using OpenAPI 3.0 and JSON Schema in Spring Boot.

## Links

- https://swagger.io/specification/
- https://editor.swagger.io/
- [JSON-Schema to Java](http://www.jsonschema2pojo.org/)
- [OpenAPITools/openapi-generator](https://github.com/OpenAPITools/openapi-generator)

## Validate

```
npm i -g swagger-cli
# Validate
swagger-cli validate src/main/resources/api/open-api.yaml
# Build a bundle (single) file
swagger-cli bundle -r -t yaml -w 140 -o src/main/resources/api/open-api-bundled.yaml src/main/resources/api/open-api.yaml
swagger-cli bundle -r -t json -w 140 -o src/main/resources/api/open-api-bundled.json src/main/resources/api/open-api.yaml
```

## Open Issues

- `snake_case` JSON notation on the wire

