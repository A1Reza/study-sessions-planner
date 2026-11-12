# 📚 Study Sessions Planner

<p align="center">
  A study tracking web application built with Java 21 and Spring MVC.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?logo=openjdk" alt="Java 21"/>
  <img src="https://img.shields.io/badge/Spring%20MVC-6.2.8-6DB33F?logo=spring" alt="Spring MVC"/>
  <img src="https://img.shields.io/badge/Apache%20Tomcat-11-F8DC75?logo=apachetomcat" alt="Tomcat 11"/>
  <img src="https://img.shields.io/badge/Maven-Build-C71A36?logo=apachemaven" alt="Maven"/>
  <img src="https://img.shields.io/badge/MapStruct-1.6.3-brightgreen" alt="MapStruct"/>
  <img src="https://img.shields.io/badge/Validation-Jakarta-blue" alt="Jakarta Validation"/>
  <img src="https://img.shields.io/badge/Storage-In--Memory-blue" alt="In-Memory Storage"/>
</p>

---

## 📖 About The Project

**Study Sessions Planner** is a Java-based web application designed to help students organize their subjects, record study sessions, and monitor their overall study time.

The application provides a centralized dashboard where users can view study statistics, explore available subjects, and manage individual study sessions through a clean and user-friendly interface.

Built with **Spring MVC**, the project follows a layered architecture and uses Java-based configuration, DTOs, MapStruct, Jakarta Bean Validation, and in-memory data storage.

## ✨ Features

### 📊 Dashboard
- View the total number of study sessions.
- Track the number of available subjects.
- Calculate total study time.
- Display study session information.
- Navigate between application sections.

### 📚 Subject Management
- View available subjects.
- Display subject information.
- Associate study sessions with specific subjects.

### ⏱️ Study Session Management
- View all recorded study sessions.
- Create new study sessions.
- Select a subject when creating a session.
- Specify study duration in minutes.
- Add notes and descriptions.
- View detailed session information.

### 🛡️ Data Validation
- Validate incoming request data using Jakarta Bean Validation.
- Ensure study duration is at least one minute.
- Validate required subject selection and notes.
- Enforce maximum note length.
- Verify that the selected subject exists before saving a session.

### 🔄 DTO Mapping
- Separate request and response DTOs from domain models.
- Use Java Records for DTO definitions.
- Automatically convert DTOs and entities using MapStruct.
- Keep mapping logic separate from business logic.

### 🩺 Application Status
- Dedicated application status endpoint.
- HTTP status response.
- Custom response header containing the application version.

## 🛠️ Technologies & Tools

| Technology | Purpose |
|---|---|
| Java 21 | Core programming language |
| Spring MVC 6.2.8 | Web application framework |
| Apache Tomcat 11 | Servlet container |
| Maven | Dependency and build management |
| JSP | Dynamic server-side views |
| JSTL 3 | JSP rendering and iteration |
| MapStruct 1.6.3 | DTO and Entity mapping |
| Jakarta Bean Validation 3.1 | Input validation |
| Hibernate Validator 9.0.1 | Bean Validation implementation |
| HTML5 | Web page structure |
| CSS3 | User interface styling |
| Jakarta Servlet | HTTP request and response handling |
| IntelliJ IDEA | Development environment |

## 🏗️ Architecture

The application follows a **Layered Architecture** to separate responsibilities and improve maintainability.

```text
┌──────────────────────────────┐
│          View Layer          │
│          JSP + JSTL           │
└──────────────┬───────────────┘
               │
┌──────────────▼───────────────┐
│       Controller Layer       │
│          Spring MVC           │
└──────────────┬───────────────┘
               │
┌──────────────▼───────────────┐
│          Service Layer       │
│       Business Operations    │
└──────────────┬───────────────┘
               │
┌──────────────▼───────────────┐
│        Repository Layer      │
│       In-Memory Storage      │
└──────────────────────────────┘

       Supporting Components

┌──────────────────────────────┐
│          DTO Layer           │
│     Request & Response DTOs  │
└──────────────────────────────┘

┌──────────────────────────────┐
│         Mapper Layer         │
│           MapStruct          │
└──────────────────────────────┘
```

### Layer Responsibilities

| Component | Responsibility |
|---|---|
| Controller | Handles HTTP requests, validation results, and application responses. |
| Service | Implements application logic and coordinates repository operations. |
| Repository | Provides methods for retrieving and storing application data. |
| Model | Represents the core application entities. |
| DTO | Defines request and response data structures. |
| Mapper | Converts between DTOs and entities using MapStruct. |
| View | Displays application data using JSP and JSTL. |

### Dependency Injection

The application uses Spring's constructor-based dependency injection to connect controllers, services, and repositories.

This approach reduces tight coupling and improves maintainability and testability.

### DTO Mapping with MapStruct

MapStruct is used to generate mapping implementations at compile time.

The application separates incoming request data and outgoing response data from its internal models.

This keeps controllers and services independent of direct presentation-layer entity exposure.

### Input Validation

Jakarta Bean Validation is used to validate incoming study session data.

Validation constraints include:
- Subject ID must not be null.
- Study duration must be at least one minute.
- Notes must not be blank.
- Notes must not exceed 255 characters.

The service layer also checks whether the selected subject exists before creating a study session.

## 📂 Project Structure

```text
study-sessions-planner/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── ir/
│       │       └── reza/
│       │           └── studyplanner/
│       │               │
│       │               ├── config/
│       │               │   └── AppConfig.java
│       │               │
│       │               ├── controller/
│       │               │   ├── HomeController.java
│       │               │   ├── SessionController.java
│       │               │   ├── SubjectController.java
│       │               │   └── StatusController.java
│       │               │
│       │               ├── dto/
│       │               │   ├── request/
│       │               │   │   └── StudySessionRequestDto.java
│       │               │   │
│       │               │   └── response/
│       │               │       ├── StudySessionResponseDto.java
│       │               │       └── SubjectResponseDto.java
│       │               │
│       │               ├── mapper/
│       │               │   ├── StudySessionMapper.java
│       │               │   └── SubjectMapper.java
│       │               │
│       │               ├── model/
│       │               │   ├── Subject.java
│       │               │   └── StudySession.java
│       │               │
│       │               ├── repository/
│       │               │   ├── SubjectRepository.java
│       │               │   ├── StudySessionRepository.java
│       │               │   └── impl/
│       │               │       ├── SubjectRepositoryImpl.java
│       │               │       └── StudySessionRepositoryImpl.java
│       │               │
│       │               ├── service/
│       │               │   ├── SubjectService.java
│       │               │   ├── StudySessionService.java
│       │               │   └── impl/
│       │               │       ├── SubjectServiceImpl.java
│       │               │       └── StudySessionServiceImpl.java
│       │               │
│       │               └── initializer/
│       │                   └── WebAppInitializer.java
│       │
│       └── webapp/
│           ├── WEB-INF/
│           │   └── views/
│           │       ├── session-list.jsp
│           │       ├── session-detail.jsp
│           │       └── add-session.jsp
│           │
│           └── index.jsp
│
├── api-requests.http
├── .gitignore
├── pom.xml
└── README.md
```

## 🧩 Data Models

### Subject

Represents a study subject.

| Field | Type | Description |
|---|---|---|
| id | Long | Unique subject identifier |
| name | String | Subject name |

### StudySession

Represents an individual study session.

| Field | Type | Description |
|---|---|---|
| id | Long | Unique session identifier |
| subjectId | Long | Associated subject identifier |
| minutes | int | Study duration in minutes |
| notes | String | Additional session information |

## 📦 DTOs

The application uses Java Records to define its DTOs.

### StudySessionRequestDto

Represents incoming data when creating a study session.

| Field | Type | Validation |
|---|---|---|
| subjectId | Long | @NotNull |
| minutes | int | @Min(1) |
| notes | String | @NotBlank, @Size(max = 255) |

### StudySessionResponseDto

Represents study session data returned to the presentation layer.

| Field | Type |
|---|---|
| id | Long |
| subjectId | Long |
| minutes | int |
| notes | String |

### SubjectResponseDto

Represents subject information returned to the presentation layer.

| Field | Type |
|---|---|
| id | Long |
| name | String |

## 💾 Data Storage

The application uses **in-memory storage** instead of a relational database.

Repositories maintain application data using Java collections and initialize sample records when the application starts.

### Initial Sample Data

**Subjects:**
- MATH
- PHYSICS
- CS

**Study Sessions:**

| ID | Subject | Duration | Notes |
|---|---|---:|---|
| 1 | MATH | 60 min | Math practice |
| 2 | MATH | 90 min | Calculus |
| 3 | PHYSICS | 45 min | Physics study |
| 4 | CS | 120 min | Java programming |

**Initial Statistics:**
- Total Subjects: 3
- Total Sessions: 4
- Total Study Time: 315 minutes

> Note: Since the application uses in-memory storage, data is reset to its initial state when the application is restarted.

## 🔗 Application Endpoints

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/dashboard` | Displays the main dashboard |
| GET | `/sessions` | Displays all study sessions |
| GET | `/sessions/add` | Displays the new session form |
| GET | `/sessions/detail?id=1` | Displays session details |
| POST | `/sessions/save` | Creates a new study session |
| GET | `/subjects` | Displays available subjects |
| GET | `/status` | Checks application status |

### Status Endpoint

The status endpoint returns:

- **HTTP Status:** 200 OK
- **Header:** `X-Planner-Version: 1.0`
- **Response Body:** `Study Sessions Planner is running!`

## 🚀 Getting Started

### Prerequisites

Make sure the following tools are installed:

- [JDK 21](https://www.oracle.com/java/technologies/downloads/)
- [Apache Maven](https://maven.apache.org/)
- [Apache Tomcat 11](https://tomcat.apache.org/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)

### 1. Clone the Repository

```bash
git clone https://github.com/A1Reza/study-sessions-planner.git
```

### 2. Open the Project

Open the cloned project in IntelliJ IDEA and wait for Maven to download the required dependencies.

### 3. Build the Application

Run the following command in the project root:

```bash
mvn clean package
```

The generated WAR file will be available inside the `target/` directory.

### 4. Configure Apache Tomcat

1. Add Apache Tomcat 11 to your IntelliJ IDEA configuration.
2. Configure the project artifact as a WAR or WAR Exploded deployment.
3. Set the application context path to:

```text
/study-planner
```

4. Start the Tomcat server.

### 5. Access the Application

Open the dashboard in your browser:

```text
http://localhost:8080/study-planner/dashboard
```

## 🧪 Testing

The project includes an `api-requests.http` file containing HTTP requests for testing application endpoints directly from IntelliJ IDEA.

Use IntelliJ IDEA's built-in HTTP Client to execute requests and inspect responses.

## 🎯 Learning Objectives

This project provides practical experience with:

- Building Java web applications using Spring MVC.
- Understanding the Model-View-Controller design pattern.
- Implementing layered application architecture.
- Applying interface-based programming.
- Using constructor-based dependency injection.
- Configuring Spring without XML configuration files.
- Handling HTTP GET and POST requests.
- Rendering dynamic pages with JSP and JSTL.
- Using Java Records for DTOs.
- Implementing DTO mapping with MapStruct.
- Applying Jakarta Bean Validation.
- Separating presentation data from domain models.
- Managing data through in-memory repositories.
- Deploying Maven WAR applications to Apache Tomcat.

## 🔮 Future Improvements

Potential enhancements for future versions include:

- Database integration using PostgreSQL.
- User authentication and session management.
- Editing and deleting study sessions.
- Filtering sessions by subject.
- Date-based study history.
- Weekly and monthly study statistics.
- Improved dashboard visualizations.
- Automated unit and integration tests.

## 👨‍💻 Author

**Reza Asadipour**

Java Backend Developer | Computer Engineering

- GitHub: [@A1Reza](https://github.com/A1Reza)
- Repository: [Study Sessions Planner](https://github.com/A1Reza/study-sessions-planner)

---

<p align="center">
  ⭐ If you find this project useful, consider giving it a star!
</p>

<p align="center">
  Built with ☕ Java
</p>
