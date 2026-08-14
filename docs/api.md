# API Documentation

Base URL for development:

'http://localhost:8080'

## Health check

Confirms backend application is running and reachable

## Request

```http
GET /api/health
```

The request does not require a body or authentication

## Successful response

**Status: **

```http
200 OK
```

**Content type:**

```http
application/json
```

**Response body:**
```json
{
  "status": "UP",
  "application": "Random Context Memories"
}
```

### Response Fields

| Field | Type | Description |
|---|---|---|
| `status` | String | Current application status |
| `application` | String | Application display name |

### Example Request

'''bash
curl -i http://localhost:8080/api/health
'''