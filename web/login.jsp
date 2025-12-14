<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Instagram - Login</title>
    <link rel="stylesheet" href="style.css">
</head>

<body class="auth-page">
    <div class="auth-container">
        <div class="auth-box">
            <h1>Instagram</h1>

            <% if (request.getAttribute("error") != null) { %>
                <div class="error-message">
                    <%= request.getAttribute("error") %>
                </div>
            <% } %>

            <form action="LoginServlet" method="POST">
                <input type="email" name="email" placeholder="Email" required>
                <input type="password" name="password" placeholder="Password" required>
                <button type="submit" class="btn-primary">Login</button>
            </form>

            <p>
                Don't have an account?
                <a href="signup.jsp">Sign up</a>
            </p>
        </div>
    </div>
</body>
</html>
