<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Study Sessions Planner | Dashboard</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background: #f4f6fb;
            color: #263238;
        }

        .navbar {
            background: white;
            padding: 20px 7%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 10px rgba(0,0,0,0.05);
        }

        .logo {
            font-size: 22px;
            font-weight: bold;
            color: #2563eb;
        }

        .nav-links a {
            text-decoration: none;
            color: #475569;
            margin-left: 22px;
            font-size: 14px;
            font-weight: 600;
        }

        .nav-links a:hover {
            color: #2563eb;
        }

        .container {
            max-width: 1150px;
            margin: 45px auto;
            padding: 0 20px;
        }

        .welcome {
            margin-bottom: 30px;
        }

        .welcome h1 {
            font-size: 30px;
            margin-bottom: 10px;
        }

        .welcome p {
            color: #64748b;
            line-height: 1.6;
        }

        .stats {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
            margin-bottom: 35px;
        }

        .stat-card {
            background: white;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 3px 12px rgba(0,0,0,0.04);
        }

        .stat-card span {
            color: #64748b;
            font-size: 14px;
        }

        .stat-card h2 {
            font-size: 30px;
            margin-top: 12px;
            color: #2563eb;
        }

        .section-title {
            font-size: 21px;
            margin-bottom: 18px;
        }

        .actions {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 18px;
            margin-bottom: 35px;
        }

        .action-card {
            background: white;
            padding: 25px;
            border-radius: 12px;
            text-decoration: none;
            color: #263238;
            transition: 0.2s;
            box-shadow: 0 3px 12px rgba(0,0,0,0.04);
        }

        .action-card:hover {
            transform: translateY(-4px);
            box-shadow: 0 7px 18px rgba(0,0,0,0.08);
        }

        .action-card h3 {
            margin-bottom: 10px;
            color: #2563eb;
        }

        .action-card p {
            color: #64748b;
            font-size: 14px;
            line-height: 1.6;
        }

        .sessions, .subjects {
            background: white;
            padding: 25px;
            border-radius: 12px;
            margin-bottom: 30px;
            box-shadow: 0 3px 12px rgba(0,0,0,0.04);
        }

        .session-item {
            padding: 16px 0;
            border-bottom: 1px solid #edf0f5;
        }

        .session-item:last-child {
            border-bottom: none;
        }

        .session-item h4 {
            margin-bottom: 7px;
        }

        .session-item p {
            color: #64748b;
            font-size: 14px;
            margin-bottom: 6px;
        }

        .session-item a {
            color: #2563eb;
            text-decoration: none;
            font-size: 13px;
            font-weight: bold;
        }

        .subject-tag {
            display: inline-block;
            background: #eff6ff;
            color: #2563eb;
            padding: 10px 16px;
            border-radius: 8px;
            margin: 5px;
            font-size: 14px;
            font-weight: bold;
        }

        .status {
            background: #ecfdf5;
            color: #047857;
            padding: 16px 20px;
            border-radius: 10px;
            margin-bottom: 30px;
            font-weight: bold;
        }

        .status a {
            color: #047857;
            margin-left: 10px;
        }

        footer {
            text-align: center;
            padding: 25px;
            color: #94a3b8;
            font-size: 13px;
        }

        @media (max-width: 700px) {
            .stats, .actions {
                grid-template-columns: 1fr;
            }

            .navbar {
                flex-direction: column;
                gap: 15px;
            }

            .nav-links a {
                margin: 0 6px;
            }
        }
    </style>
</head>

<body>

<nav class="navbar">

    <div class="logo">
        Study Planner
    </div>

    <div class="nav-links">
        <a href="${pageContext.request.contextPath}/dashboard">Home</a>
        <a href="${pageContext.request.contextPath}/sessions">Sessions</a>
        <a href="${pageContext.request.contextPath}/subjects">Subjects</a>
        <a href="${pageContext.request.contextPath}/status">Status</a>
    </div>

</nav>

<div class="container">

    <section class="welcome">
        <h1>Welcome to Study Planner 👋</h1>

        <p>
            Organize your study sessions, track your learning time,
            and manage all your subjects in one place.
        </p>
    </section>

    <!-- Statistics -->

    <section class="stats">

        <div class="stat-card">
            <span>Total Study Sessions</span>
            <h2>${fn:length(sessions)}</h2>
        </div>

        <div class="stat-card">
            <span>Total Subjects</span>
            <h2>${fn:length(subjects)}</h2>
        </div>

        <div class="stat-card">
            <span>Total Study Time</span>
            <h2>${totalMinutes} min</h2>
        </div>

    </section>

    <!-- Quick Actions -->

    <h2 class="section-title">Quick Actions</h2>

    <section class="actions">

        <a class="action-card"
           href="${pageContext.request.contextPath}/sessions">

            <h3>📚 View Sessions</h3>

            <p>
                Browse all your study sessions and check their details.
            </p>

        </a>

        <a class="action-card"
           href="${pageContext.request.contextPath}/sessions/add">

            <h3>➕ Add New Session</h3>

            <p>
                Create a new study session and record your learning time.
            </p>

        </a>

        <a class="action-card"
           href="${pageContext.request.contextPath}/subjects">

            <h3>📖 View Subjects</h3>

            <p>
                Explore all available subjects in your study planner.
            </p>

        </a>

        <a class="action-card"
           href="${pageContext.request.contextPath}/status">

            <h3>⚙️ Application Status</h3>

            <p>
                Check whether the Study Planner application is running correctly.
            </p>

        </a>

    </section>

    <!-- Recent Sessions -->

    <section class="sessions">

        <h2 class="section-title">Recent Study Sessions</h2>

        <c:choose>

            <c:when test="${not empty sessions}">

                <c:forEach var="session" items="${sessions}" varStatus="loop">

                    <c:if test="${loop.index < 5}">

                        <div class="session-item">

                            <h4>Study Session #${session.id}</h4>

                            <p>
                                Subject:
                                <c:set var="subjectFound" value="false"/>

                                <c:forEach var="subject" items="${subjects}">
                                    <c:if test="${subject.id eq session.subjectId}">
                                        ${subject.name}
                                        <c:set var="subjectFound" value="true"/>
                                    </c:if>
                                </c:forEach>

                                <c:if test="${not subjectFound}">
                                    Unknown Subject
                                </c:if>
                            </p>

                            <p>
                                Duration: ${session.minutes} minutes
                            </p>

                            <p>
                                Notes: <c:out value="${session.notes}"/>
                                <%--<c:out value="..."/> → Escapes the output (i.e. makes <, >, & safe).
                                 This is necessary to prevent XSS; since notes is user input, ${session.notes} should never be written directly.--%>
                            </p>

                            <a href="${pageContext.request.contextPath}/sessions/detail?id=${session.id}">
                                View Details →
                            </a>

                        </div>

                    </c:if>

                </c:forEach>

            </c:when>

            <c:otherwise>

                <p>No study sessions available yet.</p>

            </c:otherwise>

        </c:choose>

    </section>

    <!-- Available Subjects -->

    <section class="subjects">

        <h2 class="section-title">Available Subjects</h2>

        <c:choose>

            <c:when test="${not empty subjects}">

                <c:forEach var="subject" items="${subjects}">

                    <span class="subject-tag">
                        <c:out value="${subject.name}"/>
                    </span>

                </c:forEach>

            </c:when>

            <c:otherwise>

                <p>No subjects available.</p>

            </c:otherwise>

        </c:choose>

    </section>

    <!-- Application Status -->

    <div class="status">

        🟢 Study Planner is ready!

        <a href="${pageContext.request.contextPath}/status">
            Check Status →
        </a>

    </div>

</div>

<footer>

    Study Sessions Planner © 2026

    <br><br>

    Built with Java & Spring MVC

</footer>

</body>
</html>