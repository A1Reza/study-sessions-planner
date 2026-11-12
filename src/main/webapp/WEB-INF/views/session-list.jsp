<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Study Sessions Planner</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            margin: 0;
            padding: 40px;
        }

        .container {
            max-width: 900px;
            margin: auto;
        }

        h1, h2 {
            color: #263238;
        }

        .card {
            background: white;
            padding: 20px;
            margin-bottom: 15px;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.08);
        }

        a {
            text-decoration: none;
            color: #1976d2;
            margin-right: 10px;
        }

        .button {
            display: inline-block;
            background: #1976d2;
            color: white;
            padding: 10px 16px;
            border-radius: 6px;
            margin-bottom: 20px;
        }

        .subject {
            display: inline-block;
            background: #e3f2fd;
            padding: 8px 14px;
            margin: 5px;
            border-radius: 6px;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>Study Sessions</h1>

    <a class="button"
       href="${pageContext.request.contextPath}/sessions/add">
        Add New Session
    </a>

    <c:forEach var="session" items="${sessions}">

        <div class="card">

            <h3>Session #<c:out value="${session.id}"/></h3>

            <p>
                Subject ID:
                <c:out value="${session.subjectId}"/>
            </p>

            <p>
                Duration:
                <c:out value="${session.minutes}"/> minutes
            </p>

            <p>
                Notes:
                <c:out value="${session.notes}"/>
            </p>

            <a href="${pageContext.request.contextPath}/sessions/detail?id=${session.id}">
                View Details
            </a>

        </div>

    </c:forEach>

    <h2>Subjects</h2>

    <c:forEach var="subject" items="${subjects}">

        <span class="subject">
            <c:out value="${subject.id}"/> -
            <c:out value="${subject.name}"/>
        </span>

    </c:forEach>

    <br><br>

    <a href="${pageContext.request.contextPath}/subjects">
        View All Subjects
    </a>

</div>

</body>
</html>