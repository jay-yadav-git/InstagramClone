<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Instagram - Sign Up</title>
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

            <form action="SignupServlet" method="POST">
                <input type="text" name="username" placeholder="Username" required>
                <input type="email" name="email" placeholder="Email" required>
                <input type="password" name="password" placeholder="Password" required>
                <button type="submit" class="btn-primary">Sign Up</button>
            </form>

            <p>
                Already have an account?
                <a href="login.jsp">Login</a>
            </p>
        </div>
    </div>
</body>
</html>
