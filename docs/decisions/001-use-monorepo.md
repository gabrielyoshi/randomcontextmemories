# ADR 001: Use a monorepo

## Status

Accepted

## Context

RandomContextMemories uses a Spring Boot backend, React frontend, database config, infrastructure files, and project documentation all developed together as one application.

## Decision

Store all componenets in one GitHub repo. 

## Consequences

### Benefits

- One location for setup and documentation
- Coordinate frontend and backend
- Allows for inspection of complete application
- Simplifies tracking during development

### Tradeoffs
- Repo contains both Maven (Java backend) and npm (JS/TypeScript) dependencies, two different build ecosystems
- CI workflows must test multiple components
- Size of repo scales with application development

