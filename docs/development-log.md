# Development Log

Implementation challenges, lessons learned, design changes, and debugging outcomes from the development of RandomContextMemories

Routine tasks are tracked on GitHub Issues and Git commits

## 2026-08-14 - Project Initialization

### Work Completed

- Made GitHub repo
- Decided to use a monorepo structure
- Created directories for backend, frontend, documentation, scripts, and continuous-integration (CI) workflow
- Selected Java and Spring Boot for backend.
- Selected React and TypeScript for frontend.
- Selected PostgreSQL for persistent data.

### Lessons and decisions

A monorepo keeps the frontend, backend, infrastructure configuration, and documentation together. This structure makes the application easier to run and review. 

### Next step

Configure PostgreSQL locally and connect it to Spring Boot.
Generate Spring Boot backend and confirm 1st automated test passes. (DONE)

## 2026-08-14 - Initial backend and health endpoint

Work completed

- Created Maven Spring Boot backend.
- Configured project targeting Java 21 for wide compatibility
- Added Spring Web as first app dependency
- Started embedded Tomcat server on port 8080.
- Confirmed "404 Not Found" response (no route yet defined)
- Implemented GET /api/health
- created immutable HealthResponse record
- added focused Spring MVC test using MockMvc

Personal lessons

The health endpoint provides a tool to confirm backend is reachable by verifying request mapping, successful status code, JSON content type, and response fields without starting a server.