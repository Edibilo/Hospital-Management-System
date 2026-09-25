# Qom Clinic Appointment Management System

A **Clinic Appointment Management System** built with **Spring Boot** to demonstrate user management, role-based authentication, doctor-patient relationships, and appointment scheduling.

The project is developed for **educational purposes** and focuses on practicing backend application development with Spring Boot, Spring Data JPA, Spring Security, and MySQL.

## 📌 Project Overview

The Qom Clinic Appointment Management System provides a simple platform for managing clinic users and doctor appointments.

The system supports different user roles, including:

* **ADMIN** — manages system roles and administrative operations.
* **DOCTOR** — accesses authorized user information and participates in appointment management.
* **PATIENT** — can register, authenticate, view authorized information, and create appointments.

The application uses **Spring Security** to control access to different endpoints based on the authenticated user's role.

---

## 🎯 Project Purpose

The main purpose of this project is **educational**.

It was created to practice and demonstrate:

* Spring Boot application development
* Spring MVC architecture
* Spring Data JPA
* Entity relationships
* Spring Security
* Role-Based Access Control (RBAC)
* Password encryption with BCrypt
* User authentication and authorization
* Doctor-patient appointment management
* Enum-based entity attributes
* Database persistence with JPA/Hibernate

---

## 🛠️ Technologies Used

| Technology         | Purpose                        |
| ------------------ | ------------------------------ |
| Java               | Programming language           |
| Spring Boot        | Backend framework              |
| Spring MVC         | Web/API layer                  |
| Spring Data JPA    | Database persistence           |
| Hibernate          | ORM                            |
| Spring Security    | Authentication & authorization |
| BCrypt             | Password encryption            |
| Jakarta Validation | Input validation               |
| MySQL              | Database                       |
| Maven              | Dependency management          |
| Thymeleaf          | Server-side web pages          |

---

## 🏗️ Project Architecture

The project follows a layered Spring Boot architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Entity
    ↓
Database
```

### Main Layers

**Controller**

Handles HTTP requests and exposes application endpoints.

**Service**

Contains business logic and coordinates operations between controllers and repositories.

**Repository**

Uses Spring Data JPA to communicate with the database.

**Entity**

Represents database tables and relationships.

**Security Configuration**

Controls authentication and authorization using Spring Security.

---

## 👥 User Roles

The application uses three main roles.

### ADMIN

Administrators can access role-management endpoints.

```text
ROLE_ADMIN
```

Example:

```http
/api/v1/roles/**
```

---

### DOCTOR

Doctors have access to authorized user information and can participate in the appointment workflow.

```text
ROLE_DOCTOR
```

---

### PATIENT

Patients can create appointments.

```http
POST /api/v1/appointments
```

The endpoint requires:

```text
ROLE_PATIENT
```

---

## 🔐 Authentication & Authorization

Spring Security is used to protect application resources.

The application uses **role-based access control**.

Example:

```java
request.requestMatchers("/api/v1/roles/**")
       .hasRole("ADMIN");
```

Only administrators can access role-management endpoints.

User endpoints allow authenticated users with specific roles:

```java
request.requestMatchers(
        HttpMethod.GET,
        "/api/v1/users/**"
).hasAnyRole("ADMIN", "DOCTOR", "PATIENT");
```

Patients are allowed to create appointments:

```java
request.requestMatchers(
        HttpMethod.POST,
        "/api/v1/appointments"
).hasRole("PATIENT");
```

---

## 🔑 Password Security

Passwords are encrypted using BCrypt through Spring Security's `PasswordEncoder`.

```java
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```

Passwords should never be stored as plain text in the database.

---

## 📅 Appointment Management

The `Appointment` entity represents a doctor-patient appointment.

Each appointment contains:

```text
Appointment
├── id
├── appointmentDate
├── startTime
├── endTime
├── doctor
├── patient
└── status
```

### Appointment Status

The appointment status is represented using the `AppointmentStatus` enum.

For example:

```text
PENDING
```

New appointments automatically receive a `PENDING` status when no status is provided.

```java
@PrePersist
void prePersists() {
    if (status == null) {
        status = AppointmentStatus.PENDING;
    }
}
```

---

## 👨‍⚕️ Doctor & Patient Relationship

Appointments connect two users:

```text
             ┌──────────────┐
             │     User     │
             └──────┬───────┘
                    │
              ┌─────┴─────┐
              │           │
           Doctor       Patient
              │           │
              └─────┬─────┘
                    │
             ┌──────▼──────┐
             │ Appointment │
             └─────────────┘
```

The appointment entity contains two relationships with the `User` entity:

```java
@ManyToOne
private User doctor;

@ManyToOne
private User patient;
```

This allows multiple appointments to be associated with the same doctor or patient.

---

## 👤 User Entity

Users contain information such as:

```text
User
├── id
├── username
├── email
├── password
├── genderStatus
├── accountStatus
└── role
```

The user also has a relationship with the `Role` entity:

```java
@ManyToOne
private Role role;
```

---

## 🏷️ Role Entity

Roles are stored separately in the database.

```text
Role
├── id
└── name
```

This allows users to be assigned different roles.

Example:

```text
ADMIN
DOCTOR
PATIENT
```

---

## 📊 Database Relationships

The main relationships are:

```text
Role
  │
  │ 1
  │
  │ *
User
  │
  ├───────────────┐
  │               │
  │               │
  │ *             │ *
Appointment ──────┘
```

More specifically:

```text
Role 1 ─────── * User

User 1 ─────── * Appointment (as Doctor)

User 1 ─────── * Appointment (as Patient)
```

---

## 🔒 Security Endpoints

| Endpoint               | Method  | Access                 |
| ---------------------- | ------- | ---------------------- |
| `/api/v1/auth/**`      | Various | Public                 |
| `/api/v1/roles/**`     | Various | ADMIN                  |
| `/api/v1/users/**`     | GET     | ADMIN, DOCTOR, PATIENT |
| `/api/v1/appointments` | POST    | PATIENT                |
| Other endpoints        | Various | Authenticated users    |

> The exact available endpoints depend on the controllers implemented in the project.

---

## 📂 Suggested Project Structure

```text
src/main/java/iki/qom
│
├── config
│   └── SpringConfig.java
│
├── controller
│
├── dto
│
├── entity
│   ├── Appointment.java
│   ├── Role.java
│   └── User.java
│
├── enumerator
│   ├── AccountStatus.java
│   ├── AppointmentStatus.java
│   └── GenderStatus.java
│
├── mapper
│
├── repository
│
├── service
│
└── QomApplication.java
```

---

## ⚙️ Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Edibilo/Qom.git
```

```bash
cd Qom
```

### 2. Configure the Database

Create a MySQL database:

```sql
CREATE DATABASE qom;
```

Then configure your database connection in:

```text
application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/qom
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Build the Project

Using Maven:

```bash
mvn clean install
```

### 4. Run the Application

```bash
mvn spring-boot:run
```

The application will start using the configured Spring Boot port.

---

## 🧪 Example Workflow

A typical workflow can be:

```text
1. Register a user
        ↓
2. Assign a role
        ↓
3. Login
        ↓
4. Authenticate with Spring Security
        ↓
5. Access authorized resources
        ↓
6. Patient creates an appointment
        ↓
7. Appointment receives PENDING status
        ↓
8. Doctor and patient are associated with the appointment
```

---

## 🔮 Possible Future Improvements

The project can be extended with:

* Doctor availability management
* Appointment cancellation
* Appointment rescheduling
* Appointment confirmation
* Appointment history
* Doctor specialization
* Patient medical records
* Prescription management
* Email notifications
* REST API documentation with Swagger/OpenAPI
* Pagination and filtering
* Global exception handling
* DTO-based API responses
* Validation and custom error responses
* JWT authentication
* Docker support
* Automated tests

---

## 📚 Learning Objectives

This project provides practical experience with:

```text
Spring Boot
     ↓
Spring MVC
     ↓
Spring Data JPA
     ↓
Hibernate
     ↓
MySQL
     ↓
Spring Security
     ↓
Role-Based Access Control
     ↓
Authentication & Authorization
     ↓
Business Logic
```

It is intended as a practical learning project for understanding how these technologies can be combined to build a real-world backend application.

---

## 👨‍💻 Author

**Mohamed**

Software Development Project — Educational Purpose

---

## 📄 License

This project is created for **educational and learning purposes**.
