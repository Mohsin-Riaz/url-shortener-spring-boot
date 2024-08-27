# URL SHORTENER BACKEND

Backend for URL Shortener App. Using Java/Spring Boot and MongoDB/PostgreSQL.
---
Backend for URL Shortener App. Using Java, Spring Boot and MongoDB/PostgreSQL.

Common Java/Spring Boot backend server using Maven.

## Deploy

Deploy using 'Dockerfile'

`docker build -t <docker-image-name> -f Dockerfile .`

`docker run <docker-image-name>`

### Environment Variables
---
#### Build and Development
- `BACKEND_URL=dev` for development environment, leave blank for production
- Add frontend url for CORS to variable `FRONTEND_URL`
- `PSQL_TABLE` to rename table, default='links_table'

#### MONGODB_ENDPOINT
- Add mongodb uri to `MONGODB_URI`

#### PSQL_ENDPOINT
---
### CORS
- Add frontend domain to `CORS_ALLOWED_ORIGIN` 

### Database
Choose either MongoDB or Postgres and add the environment variable below. Add only the database you wish to use, defaults to MongoDB if both are added.

##### MongoDB Endpoint
- Add MongoDB uri to `MONGODB_URI`

##### Postgres Endpoint
- PSQL URL endpoint `PSQL_PASSWORD`
- PSQL endpoint password
