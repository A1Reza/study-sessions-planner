# 📚 Study Sessions Planner

<p align="center">
  A simple and organized study tracking application built with Java and Spring MVC.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?logo=openjdk" alt="Java 21"/>
  <img src="https://img.shields.io/badge/Spring%20MVC-6.2.8-6DB33F?logo=spring" alt="Spring MVC"/>
  <img src="https://img.shields.io/badge/Apache%20Tomcat-11-F8DC75?logo=apachetomcat" alt="Tomcat 11"/>
  <img src="https://img.shields.io/badge/Maven-Build-C71A36?logo=apachemaven" alt="Maven"/>
  <img src="https://img.shields.io/badge/Storage-In--Memory-blue" alt="In-Memory Storage"/>
</p>

---

## 📖 About The Project

**Study Sessions Planner** is a Java-based web application designed to help students organize their subjects, record study sessions, and monitor their overall study time.

The application provides a centralized dashboard where users can view study statistics, explore their subjects, and manage individual study sessions through a clean and user-friendly interface.

This project demonstrates the implementation of a layered architecture using **Spring MVC**, with Java-based configuration and in-memory data storage.

## ✨ Features

### 📊 Dashboard
- View the total number of study sessions.
- Track the number of available subjects.
- Calculate total study time.
- Display recent study sessions.
- Navigate easily between application sections.

### 📚 Subject Management
- View all available subjects.
- Display subject information.
- Associate study sessions with specific subjects.

### ⏱️ Study Session Management
- View all recorded study sessions.
- Add new study sessions.
- Select a subject when creating a session.
- Specify study duration in minutes.
- Add notes and descriptions.
- View detailed information about each session.

### 🩺 Application Status
- Dedicated application health endpoint.
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
| JSTL 3 | JSP view rendering and iteration |
| HTML5 | Web page structure |
| CSS3 | User interface styling |
| Jakarta Servlet | HTTP request and response handling |
| IntelliJ IDEA | Development environment |

## 🏗️ Architecture

The application follows a **Layered Architecture** to separate responsibilities and keep the code organized and maintainable.

```text
┌──────────────────────────────┐
│         View Layer           │
│          JSP + JSTL           │
└──────────────┬───────────────┘
               │
┌──────────────▼───────────────┐
│       Controller Layer       │
│          Spring MVC           │
└──────────────┬───────────────┘
               │
┌──────────────▼───────────────┐
│         Service Layer        │
│      Business Operations     │
└──────────────┬───────────────┘
               │
┌──────────────▼───────────────┐
│        Repository Layer      │
│       Data Management        │
└──────────────┬───────────────┘
               │
┌──────────────▼───────────────┐
│         Model Layer          │
│     Subject & StudySession   │
└──────────────────────────────┘
```

### Layer Responsibilities

| Layer | Responsibility |
|---|---|
| Controller | Handles incoming HTTP requests and determines application responses. |
| Service | Contains application operations and coordinates repository access. |
| Repository | Provides methods for retrieving and storing application data. |
| Model | Represents the application's core data structures. |
| View | Displays application data using JSP and JSTL. |

### Dependency Injection

Spring's constructor-based dependency injection is used to connect controllers, services, and repositories.

This approach reduces tight coupling and makes the application easier to maintain and test.

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

## 💾 Data Storage

This application uses **in-memory storage** instead of a relational database.

The repositories maintain application data using Java collections and initialize sample records when the application starts.

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

The following endpoints are available:

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/dashboard` | Displays the main dashboard |
| GET | `/sessions` | Retrieves all study sessions |
| GET | `/sessions/add` | Displays the new session form |
| GET | `/sessions/detail?id=1` | Displays session details |
| POST | `/sessions/save` | Creates a new study session |
| GET | `/subjects` | Displays all subjects |
| GET | `/status` | Checks application status |

### Status Endpoint

The status endpoint returns an HTTP response with:

- **HTTP Status:** 200 OK
- **Header:** `X-Planner-Version: 1.0`
- **Response Body:** `Study Sessions Planner is running!`

## 🚀 Getting Started

Follow these instructions to run the project locally.

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

The project includes an `api-requests.http` file containing HTTP requests for testing the application's endpoints directly from IntelliJ IDEA.

You can use IntelliJ IDEA's built-in HTTP Client to execute the requests and inspect their responses.

## 🎯 Learning Objectives

This project provides practical experience with:

- Building Java web applications using Spring MVC.
- Understanding the Model-View-Controller design pattern.
- Implementing layered application architecture.
- Using interfaces and implementation classes.
- Applying constructor-based dependency injection.
- Configuring Spring without XML configuration files.
- Handling HTTP GET and POST requests.
- Rendering dynamic pages with JSP and JSTL.
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

## 👨‍💻 Author

**Reza Asadipour**

Java Backend Developer | Computer Engineering

- GitHub: [@A1Reza](https://github.com/A1Reza)

---

<p align="center">
  ⭐ If you find this project useful, consider giving it a star!
</p>

<p align="center">
  Built with ☕ Java
</p>
