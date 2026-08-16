# randomcontextmemories

## Overview

A private, full-stack digital memory journal that helps users save, organize, search, and share text, images, videos, and links.

## Features

- Save text and links
- Upload images and video
- Organize entries with tags and collections
- Search saved content
- Maintain private user accounts
- Selectively export/share user-controlled context

## Screenshots

TBD as user interface development proceeds

## Technology Stack

Frontend, backend, database, storage, testing, and deployment
- Backend: Java 21, Spring Boot, Spring Web MVC
- Persistence: Spring Data JPA and Hibernate
- Database: PostgreSQL 18
- Infrastructure: Docker Compose
- Build and testing: Maven, JUnit, and MockMvc
- Frontend, object storage, and deployment: TBD

### Implemented
- Java 21
- Spring Boot
- Maven
- PostgreSQL 18.4
- Docker and Docker Compose
- JUnit
- Spring MockMvc
- Git and GitHub
- Configured PostgreSQL for local development with Docker Compose
- Connected Spring Boot to PostgreSQL through Spring Data JPA
- Configured database credentials through environment variables
- Verified PostgreSQL connection through HikariCP

### Planned

- React
- TypeScript
- Object storage
- Continuous integration and deployment
#### Specifics
- Design and Implement first persistent 'Entry" domain entity
- Add database schema migrations
- Implement repo tests

## Architecture

Uses monorepo containing backend, frontend, infrastructure config, and documentation

## Getting Started

Requirements and install instructions

- Java 21 or later
- Docker Desktop
- Git

## Testing

Running backend and frontend tests.

## API Documentation

Current API documentation is available in ```docs/api.md```

Implemented endpoint:

```GET /api/health```

## Project Status

In active development

Completed:
- Established monorepo for backend, frontend, documentation, and infrastructure
- Initialized a Java and Spring Boot backend using Maven
- Verified Spring application with JUnit
- Implemented GET /api/health
- Added a focused web-layer test that verifies the endpoint's HTTP status, content type, and JSON response
- Configured PostgreSQL 18.4 as Docker Compose service
- Added environment-based local database configuration
- Added persistent PostgreSQL volume and container health check
- Verified database, application user, authentication, and SQL execution

Next:

- Connect Spring Boot to PostgreSQL through JDBC and Spring Data JPA
- Introduce version-controlled database migrations
- Add first persistent domain entity

## Roadmap
Planned milestones include:

- Persistent entries containing text and links
- Image and video attachments
- Tags and collections
- User authentication and authorization
- Full-text search
- A React and TypeScript frontend
- User-controlled export and sharing
- Optional integrations that let users provide selected memories as context to AI tools

Planning to integrate tags and collections for easy sharing with users AI subscriptions for better chat context

## Design Decisions

Architectural decisions documented here ```docs/decisions/```

## License
