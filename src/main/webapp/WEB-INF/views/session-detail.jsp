<%--
  Created by IntelliJ IDEA.
  User: rezaa
  Date: 11/10/2026
  Time: 12:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Session Details</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            padding: 40px;
        }

        .container {
            max-width: 600px;
            margin: auto;
        }

        .card {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.08);
        }

        h1 {
            color: #263238;
        }

        p {
            font-size: 16px;
            margin: 20px 0;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            color: #1976d2;
            text-decoration: none;
        }
    </style>
</head>
<body>

<div class="container">

    <div class="card">

        <h1>Session Details</h1>

        <h3>Session #${session.id}</h3>

        <p>
            <strong>Subject ID:</strong>
            ${session.subjectId}
        </p>

        <p>
            <strong>Duration:</strong>
            ${session.minutes} minutes
        </p>

        <p>
            <strong>Notes:</strong>
            ${session.notes}
        </p>

        <a href="${pageContext.request.contextPath}/sessions">
            Back to Sessions
        </a>

    </div>

</div>

</body>
</html>