<%--
  Created by IntelliJ IDEA.
  User: rezaa
  Date: 11/10/2026
  Time: 12:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Study Session</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            padding: 40px;
        }

        .container {
            max-width: 500px;
            margin: auto;
        }

        .card {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.08);
        }

        input, textarea, select {
            width: 100%;
            padding: 12px;
            margin: 10px 0 20px;
            border: 1px solid #ddd;
            border-radius: 6px;
            box-sizing: border-box;
        }

        button {
            background: #1976d2;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
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

        <h1>Add Study Session</h1>

        <form action="${pageContext.request.contextPath}/sessions/save"
              method="post">

            <label for="subjectId">Subject</label>

            <select id="subjectId" name="subjectId" required>  <%--Drop-down list, Select element or Select control, Combo box--%>
                <option value="">Select a subject</option>

                <c:forEach var="subject" items="${subjects}">
                    <option value="${subject.id}">
                            ${subject.name}
                    </option>
                </c:forEach>

            </select>

            <label for="minutes">Duration (Minutes)</label>

            <input type="number"
                   id="minutes"
                   name="minutes"
                   min="1"
                   required>

            <label for="notes">Notes</label>

            <textarea id="notes"
                      name="notes"
                      rows="4"
                      required></textarea>

            <button type="submit">Save Session</button>

        </form>

        <a href="${pageContext.request.contextPath}/sessions">
            Back to Sessions
        </a>

    </div>
</div>

</body>
</html>