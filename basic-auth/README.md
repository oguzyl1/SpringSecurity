# 🌟 Spring Security Basic Authentication Project

This project is developed to demonstrate basic authentication and authorization using **Spring Security**. It includes customized access control and user management features for different roles.

## 📖 Table of Contents 
- [Features](#features)
- [Project Structure](#project-structure)
- [User Roles](#user-roles)
- [Example API Calls](#example-api-calls)
- [Dummy Data](#dummy-data)

---

## ✨ Features 

- **User and Role Management:** Users can be registered with different roles (ADMIN, USER, MODE).
- **Authorization:**
    - Access control is configured based on roles such as `ADMIN`, `USER`, and `MODE`.
- **Public and Private Endpoints:**
    - `/public` (Accessible to everyone 🌍)
    - `/private` (Requires authentication 🔒)

---

## 🏗️ Project Structure 

```plaintext
src
├── main
│   ├── java
│   │   └── com.springsecurity.basic_auth
│   │       ├── config             # Spring Security configurations
│   │       ├── controller         # Public and Private API endpoints
│   │       ├── dto                # Data Transfer Objects (DTO)
│   │       ├── model              # User and Role models
│   │       ├── repository         # JPA Repository classes
│   │       ├── security           # Security configurations
│   │       └── service            # Business logic services
│   └── resources
│       ├── application.properties # Project configuration file
│       └── data.sql               # Dummy data
```

---

## 🛡️ User Roles 

| Role         | Description                                                             |
|--------------|-------------------------------------------------------------------------|
| `ADMIN`      | Has access to all resources.                                            |
| `USER`       | Can only access endpoints allowed for their role.                       |
| `MODE`       | A custom role for demonstrating additional authorization possibilities. |

---

## 📡 Example API Calls 

### 🌟 Public Endpoints 

1. **Public endpoint:**
   ```http
   GET /public
   Response: "Hello World! from public endpoint"
   ```

### 🔒 Private Endpoints 

1. **Private General Endpoint:**
   ```http
   GET /private
   Authorization: Basic <Base64EncodedCredentials>
   Response: "Hello World! from private endpoint"
   ```

2. **User Endpoint:**
   ```http
   GET /private/user
   Authorization: Basic <Base64EncodedCredentials>
   Response: "Hello World! from user private endpoint"
   ```

3. **Admin Endpoint:**
   ```http
   GET /private/admin
   Authorization: Basic <Base64EncodedCredentials>
   Response: "Hello World! from admin private endpoint"
   ```

---

## 🗂️ Dummy Data 

Upon application startup, the following dummy users are automatically created:

| Name | Username | Password | Roles       |
|------|----------|----------|-------------|
| Oguz | oguz     | pass     | ADMIN       |
| veli | veli     | pass     | USER        |
| Ali  | ali      | pass     | MODE        |

---

## 📝 Notes 

- This project aims to teach the basics of Spring Security.
- Additionally, features such as CSRF protection, H2 Console access, and role-based authorization have been configured.
