<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List, dto.Post" %>

<%
    // Session check (simple)
    if (session.getAttribute("loggedUser") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Posts coming from servlet
    List<Post> posts = (List<Post>) request.getAttribute("posts");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Instagram - Home</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<!-- ================= NAVBAR ================= -->
<div class="navbar">
    <h2>Instagram</h2>
    <div>
        <a href="createPost.jsp">Create</a>
        <a href="LogoutServlet">Logout</a>
    </div>
</div>

<!-- ================= FEED ================= -->
<div class="feed-container">

    <% if (posts == null || posts.isEmpty()) { %>
        <p class="no-posts">No posts available.</p>
    <% } else { %>

        <% for (Post p : posts) { %>

            <div class="post-card">

                <!-- Image -->
                <div class="post-image">
                    <img src="<%= p.getImage_url() %>" alt="Post Image">
                </div>

                <!-- Caption -->
                <div class="post-caption">
                    <p><%= p.getCaption() %></p>
                </div>

                <!-- Date -->
                <div class="post-date">
                    <small>Posted on <%= p.getCreated_at() %></small>
                </div>

            </div>

        <% } %>

    <% } %>

</div>

</body>
</html>
