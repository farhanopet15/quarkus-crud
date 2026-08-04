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

```text
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

# 🔐 Authentication

```
POST /auth/register
POST /auth/login
```

---

# 👤 User API

```
GET    /users
GET    /users/{id}
POST   /users
PUT    /users/{id}
DELETE /users/{id}
```

Supports:

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
git clone https://github.com/farhanopet15/quarkus-crud-backend.git
```

Run application

```bash
cd quarkus-crud-backend
./mvnw quarkus:dev
```

Windows

```bash
mvnw.cmd quarkus:dev
```

---

# 🧪 Testing

```bash
mvn test
```

---

# 📸 Screenshots

Coming Soon

---

# ⭐ Related Project

Frontend Repository

[quarkus-crud-frontend](https://github.com/farhanopet15/quarkus-crud-frontend)

---

# 👨‍💻 Author

Ahmad Farhan Walidain

GitHub

[farhanopet15](https://github.com/farhanopet15)
