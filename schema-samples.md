# Samples

```json
{
  "$id": "https://giraone.com/person.schema.json",
  "$schema": "http://json-schema.org/draft-07/schema#",
  "title": "A Person in my system.",
  "type": "object",
  "properties": {
    "id": {
      "type": "string",
      "description": "The person's ID."
    },
    "firstName": {
      "type": "string",
      "description": "The person's first name.",
      "required": ["First name is mandatory!"],
      "pattern": "^([0-9a-zA-Z]{1,100})$"
    },
    "lastName": {
      "type": "string",
      "description": "The person's last name.",
      "required": ["First name is mandatory!"],
      "pattern": "^([0-9a-zA-Z]{1,100})$"
    },
    "dateOfBirth": {
      "description": "Person's data of birth.",
      "type": "string",
      "format": "date"
    },
    "age": {
      "description": "Age in years which must be equal to or greater than zero.",
      "type": "integer",
      "minimum": 0
    },
    "gender": {
      "description": "The person's gender.",
      "type": "string",
      "enum": ["U", "M", "F", "D"],
      "required": ["Gender is mandatory!"]
    },
    "deceased": {
      "description": "Flag, if person is deceased.",
      "type": "boolean"
    },
    "creationDateTime": {
      "description": "Timestamp, when the entry was added.",
      "type": "string",
      "format": "date-time"
    },
    "comment": {
      "type": "string",
      "description": "A comment.",
      "maxLength": 1000
    },
    "location": {
      "$ref": "geo-location.json"
    },
    "additionalProperties" : true
  }
}
```