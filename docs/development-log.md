# Development Log

Implementation challenges, lessons learned, design changes, and debugging outcomes from the development of RandomContextMemories

Routine tasks are tracked on GitHub Issues and Git commits

## 2026-08-17 - Entry persistence

### Completed

- Added Flyway integration to track/manage db schema
- Created migration V1__create_entries_table.sql
- Added first managed entries database table
- Created JPA-managed Entry entity
- Added EntryRepository using Spring Data JPA
- Added Spring Boot JPA test module
- Added repository integration test using real PostgreSQL datasource
- Verified entries can be inserted and retrieved by ID
- Confirmed repo test transactions roll back
- Ran complete Maven test suite successfully

### Lessons

- Flyway migrations offer version-controlled history of db schema changes
- Later schema changes require new migration files
- JPA entities must match Flyway database schema when Hibernate validation is enabled.

## 2026-08-16 - PostgreSQL integration

### Completed

- Added Spring Data JPA and PostgreSQL JDBC driver
- Configured Spring Boot datasource settings using environment variables
- Connected backend to local PostgreSQL Docker service
- Enabled Hibernate schema validation
- Disabled Open EntityManager in View
- Verified HikariCP established database connection
- Confirmed 'GET /api/health' still returns HTTP 200
- Ran Maven test suite successfully

### Lessons

- Adding JPA activates Spring Boot's datasource auto-config
- Maven and Spring Boot do not auto load the root '.env' file.
- Environment variables must be exported before running backend 

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

## 2026-08-14 - PostgreSQL development environment

### Work Completed

- Configured PostgreSQL 18.4 as the 1st Docker Compose service
- Has persistent Docker volume for database
- Added PostgreSQL health check
- Confirmed database connection and user with SQL
- Confirmed installed PostgreSQL version.

### Verification

```sql
SELECT current_database(), current_user;
SELECT version();
```
