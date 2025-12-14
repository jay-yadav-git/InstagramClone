package controller;

import dto.UserDTO;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import model.UserLoginAuthenticator;

import utils.DBConnector;
import utils.PasswordUtils;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.sendRedirect("login.jsp");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
       
        UserDTO userLogin = new UserDTO();
        userLogin.setEmail(email);
        userLogin.setPassword(password);

        UserLoginAuthenticator userLoginAuthenticator = new UserLoginAuthenticator();
    
           UserDTO loggedUser = userLoginAuthenticator.userIsLogin(userLogin);

        // Check authentication result
        if (loggedUser != null) {
            System.out.println("Authentication successful for user: " + loggedUser.getEmail());
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedUser", loggedUser);
            response.sendRedirect("homepage.jsp");
        } else {
            
            response.sendRedirect("login.jsp?error=true");
        }
}
}
