# 🚀 Quarkus CRUD Backend API

A production-ready RESTful API built with **Java 21**, **Quarkus 3**, and **PostgreSQL**.

This project demonstrates modern backend development practices including authentication, CRUD operations, pagination, search, sorting, database migration, Docker, Swagger documentation, and automated testing.

---

# ✨ Features

- 🔐 JWT Authentication
- 🔑 BCrypt Password Hashing
- 👤 User CRUD
- 📄 Pagination
- 🔍 Search
- ↕ Sorting
- ✅ Bean Validation
- ⚠ Global Exception Handler
- 🗄 PostgreSQL Database
- 📦 Flyway Database Migration
- 🐳 Docker & Docker Compose
- 📚 Swagger / OpenAPI Documentation
- 🧪 Unit Test (Mockito)
- 🧪 Integration Test (QuarkusTest)

---

# 🛠 Tech Stack

| Category | Technology |
|----------|------------|
| Language | Java 21 |
| Framework | Quarkus 3 |
| Database | PostgreSQL |
| ORM | Hibernate ORM Panache |
| Migration | Flyway |
| Authentication | JWT + BCrypt |
| Documentation | Swagger / OpenAPI |
| Testing | JUnit 5, Mockito, QuarkusTest |
| Containerization | Docker |

---

# 📁 Project Structure

```
src
│
├── auth
├── dto
├── entity
├── exception
├── mapper
├── repository
├── resource
├── service
└── db
    └── migration
```

---

# 🗄 Database

PostgreSQL

Managed using Flyway Migration.

Migration files:

```
src/main/resources/db/migration
```

---

# 🔐 Authentication

JWT Authentication

Password stored using BCrypt.

Endpoints

```
POST /auth/register

POST /auth/login
```

---

# 👥 User API

```
GET    /users

GET    /users/{id}

POST   /users

PUT    /users/{id}

DELETE /users/{id}
```

Supports

- Pagination
- Search
- Sorting

---

# 📖 Swagger

Swagger UI

```
http://localhost:8080/swagger
```

OpenAPI

```
http://localhost:8080/openapi
```

---

# 🐳 Docker

Start containers

```bash
docker compose up -d
```

Stop containers

```bash
docker compose down
```

---

# ▶ Run Project

Clone repository

```bash
git clone https://github.com/YOUR_USERNAME/quarkus-crud-backend.git
```

Enter project

```bash
cd quarkus-crud-backend
```

Run application

```bash
./mvnw quarkus:dev
```

Windows

```bash
mvnw.cmd quarkus:dev
```

---

# 🧪 Testing

Run all tests

```bash
mvn test
```

Includes

- Unit Test (Mockito)
- Integration Test (QuarkusTest)

---

# 🧰 Environment

application.properties

```properties
quarkus.datasource.db-kind=postgresql
quarkus.datasource.username=postgres
quarkus.datasource.password=your_password
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/quarkus
```

---

# 🚀 Future Improvements

- Role Based Access Control (RBAC)
- Refresh Token
- CI/CD Pipeline
- Deployment
- Monitoring
- Logging
- API Rate Limiting

---

# 👨‍💻 Author

Ahmad Farhan Walidain

GitHub

[farhanopet15](https://github.com/farhanopet15)

LinkedIn

[Ahmad Farhan Walidain](https://www.linkedin.com/in/ahmadfarhanwalidain)

---

# ⭐ Portfolio

This project was built as part of my backend portfolio using modern Java technologies.

The frontend for this backend is available in a separate repository:

[quarkus-crud-frontend](https://github.com/farhanopet15/quarkus-crud-frontend)

Built with

- React
- TypeScript
- Vite
- Tailwind CSS
- TanStack Query
- Zustand
