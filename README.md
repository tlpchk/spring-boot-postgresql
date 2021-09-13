# Spring Boot & Postgres

Simple Spring Boot project with PostgreSQL database and JPA repositories. The DB is dockerized.

Postgres schema is taken from here: https://github.com/dlbunker/ps-first-spring-boot-app/tree/master/database/postgresql

Sessions and speakers have many-to-many relations.

## Running DB

```shell
docker-compose up -d
```
## API
1. Sessions
   - `GET /api/v1/sessions` - return all sessions in the DB
   - `GET /api/v1/sessions/{id}` - get session by its id
   - `POST /api/v1/sessions` - create session
   - `PUT /api/v1/sessions/{id}` - update session by its id
2. Speakers
   - `GET /api/v1/speakers` - return all speakers in the DB
   - `GET /api/v1/speakers/{id}` - get speaker by its id
   - `POST /api/v1/speakers` - create speaker
   - `PUT /api/v1/speakers/{id}` - update speaker by its id

