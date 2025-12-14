/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserSignupAuthenticator;

/**
 *
 * @author LENOVO
 */
public class SignupServlet extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.sendRedirect("signup.jsp");
   
    }
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
     
         //Retrieving User details from html Page
         
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         String email = request.getParameter("email");
         
         //Setting User details in UserDTO
         
         UserDTO newUser = new UserDTO();
         newUser.setUsername(username);
         newUser.setPassword(password);
         newUser.setEmail(email);
 
         
         //Authenticating the signup
         
         UserSignupAuthenticator  userSignupAuthenticator = new UserSignupAuthenticator();
         boolean signup = userSignupAuthenticator.isSignup(newUser);
         
         if(signup)
         {
         response.sendRedirect("login.jsp");
         }
         else
         {
             response.sendRedirect("signup.jsp?error=true");
         }
     }
}