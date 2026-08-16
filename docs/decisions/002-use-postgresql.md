# ADR 002: Use PostgreSQL as primary relational database

## Status

Accepted

## Context

The app needs persistent storage for users, journal entries, attachments, tags, collections, and links between records.

## Decision

Use PostgreSQL as primary relational database. Run it locally through Docker Compose and connect Spring Boot backend through Spring Data JPA.

Database credentials will be supplied through environment variables and will not committ to Git.

## Consequences

### Benefits

- Strong relational modeling and transaction support
- Mature indexing and full-text search capabilities
- Decent integration with Spring Boot and Hibernate
- Reproducible local development through Docker Compose

### Tradeoffs

- Develops must run Docker and PostgreSQL locally
- Database schema changes require managed migrations (disabled auto updates)
- Media files should be stores in object storage rather than directly in PostgreSQL