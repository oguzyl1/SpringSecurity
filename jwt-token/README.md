# 🌟 Spring Security JWT Token Project

This project showcases how to implement **JSON Web Token (JWT)** based authentication and authorization in a modern **Spring Boot** application. It aims to provide a comprehensive guide for developers aiming to build secure APIs.

## 📖 Project Goals
- **Security:** Handle user authentication and authorization securely.
- **Scalability:** Adopt a stateless architecture suitable for modern application design.
- **Education:** Demonstrate how to integrate tools like Spring Security, JWT, and PostgreSQL in a real-world project.

## 🚀 Features
1. **🔐 Authentication:**
    - Users are authenticated using JWT after login.
    - Tokens act as portable credentials for user verification.

2. **👥 Authorization:**
    - Endpoint access is controlled based on user roles (e.g., **USER**, **ADMIN**).
    - **/auth/user** is accessible only to users with the USER role.
    - **/auth/admin** is accessible only to users with the ADMIN role.

3. **📂 Database Support:**
    - User and role data are securely stored using PostgreSQL.
    - Hibernate handles database operations through JPA.

4. **🛠️ Flexibility:**
    - The modular structure of Spring Boot and Spring Security allows for easy extensibility.
    - Additional security policies or authentication providers can be added seamlessly.

5. **🐳 Docker Integration:**
    - Quick setup for PostgreSQL using Docker.
    - Easy configuration with environment variables.

6. **📜 Testability:**
    - Leverage Spring Security Test for end-to-end security testing.

## 🔧 Requirements
- ☕ **Java 17+**
- 🛠️ **Maven**
- 🐋 **Docker** (optional)
- 🗄️ **PostgreSQL**

## 🛠️ Setup Steps
1. **Start PostgreSQL:**
    ```bash  
    docker-compose up -d  
    ```  

2. **Configure Database Settings:**
    - Open the `application.properties` file and update the following lines as needed:
      ```properties  
      spring.datasource.url=jdbc:postgresql://localhost:5432/token-services  
      spring.datasource.username=postgres  
      spring.datasource.password=12345  
      ```  

3. **Run the Project:**  
   Use Maven to start the Spring Boot application:
    ```bash  
    mvn spring-boot:run  
    ```  

4. **Test API Endpoints:**
    - **/auth/welcome**: Public access.
    - **/auth/addNewUser**: Add a new user.
    - **/auth/generateToken**: Generate a token.
    - **/auth/user**: User-specific endpoint.
    - **/auth/admin**: Admin-specific endpoint.

## 💻 Technologies Used
- **Spring Boot**: A framework for rapid application development.
- **Spring Security**: Core module for application security.
- **JWT**: Token-based authentication and authorization.
- **PostgreSQL**: A reliable and robust relational database.
- **Docker**: A container technology for environmental independence.

## 🌟 Why This Project?
This project is designed to solve real-world security scenarios. It can be used for:
- Securing APIs with Spring Security and JWT.
- Managing user authentication and role-based access.
