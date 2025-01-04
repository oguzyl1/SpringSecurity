# 🌟 Spring Security Demo Project

This project demonstrates how to implement security mechanisms in a Spring Boot application using Spring Security. It uses **in-memory user details** for authentication and authorization.

---

## ✨ Features

1. **🔒 In-Memory Authentication:**
    - Predefined users with roles (e.g., `USER` and `ADMIN`) are stored in memory.
    - Passwords are encrypted using **BCrypt**.

2. **🛡️ Role-Based Access Control:**
    - Different endpoints are secured based on user roles (e.g., `USER` or `ADMIN`).

3. **🌐 Public and Private Endpoints:**
    - **Public Endpoints:** Accessible without authentication.
    - **Private Endpoints:** Require authentication and are restricted by roles.

4. **💡 HTTP Basic Authentication:**
    - A simple solution for authentication is used to demonstrate security.

---

## 📂 Project Structure

### 🏁 Main Application Class: `InMemoryApplication`

- The entry point of the Spring Boot application.
- Starts the application using `SpringApplication.run`.

---

### 🛠️ Security Configuration: `SecurityConfig`

#### 1. **Password Encryption:**
- Uses **BCrypt** as the password encoder.

#### 2. **In-Memory Users:**
- Two users are pre-configured:
    - **Username:** `funda`, **Password:** `pass`, **Role:** `USER`
    - **Username:** `oguz`, **Password:** `pass`, **Role:** `ADMIN`

#### 3. **Security Rules:**
- **CSRF and Frame Options:** Disabled for simplicity.
- **Access Rules:**
    - `/public/**` and `/auth/**` → Open to everyone.
    - `/private/user/**` → Accessible only by `USER` role.
    - `/private/admin/**` → Accessible only by `ADMIN` role.
    - All other requests → Require authentication.

#### 4. **Authentication Type:**
- Implements **HTTP Basic Authentication** for simplicity.

---

### 🌐 Controller Classes

#### 1. **PublicController:**
- Manages endpoints under `/public`.
- **Example Endpoint:**
    - `GET /public` → Returns: *"Hello World! from public endpoint"*

#### 2. **PrivateController:**
- Manages endpoints under `/private`.
- **Example Endpoints:**
    - `GET /private` → Returns: *"Hello World! from private endpoint"*
    - `GET /private/user` → Restricted to `USER` role → Returns: *"Hello World! from user private endpoint"*
    - `GET /private/admin` → Restricted to `ADMIN` role → Returns: *"Hello World! from admin private endpoint"*

- Demonstrates the use of **`@PreAuthorize`** for method-level security.

---
