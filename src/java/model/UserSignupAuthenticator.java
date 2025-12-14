/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import dao.UserDAO;
import dto.UserDTO;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.SQLException;
import utils.PasswordUtils;

/**
 *
 * @author LENOVO
 */
public class UserSignupAuthenticator {
    
     public boolean isSignup(UserDTO newUser)
    {
        String username = newUser.getUsername();
        String password = newUser.getPassword();
        String email = newUser.getEmail();
        
        //To get the Hashed the Password
        String hashedPassword = PasswordUtils.hashPassword(password);
        newUser.setPassword(hashedPassword);
        
        UserDAO newUserDAO = new UserDAO();
        
        return newUserDAO.save(newUser);
    }
     
    
    
}
