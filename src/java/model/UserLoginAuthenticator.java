package model;

import dao.UserDAO;
import dto.UserDTO;
import utils.PasswordUtils;

public class UserLoginAuthenticator {
    
    public UserDTO userIsLogin(UserDTO userLogin) {
        
       
        // Extract raw credentials
        String email = userLogin.getEmail();
        String password = userLogin.getPassword();

        // Hash password before checking
        String hashedPassword = PasswordUtils.hashPassword(password);

        userLogin.setPassword(hashedPassword);
        
        // Call DAO to verify credentials
        UserDAO userLoginCheck = new UserDAO();

        UserDTO result = userLoginCheck.isUserLogin(userLogin);
        
        return result;
    }
}
