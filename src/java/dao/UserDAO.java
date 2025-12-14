
package dao;


import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Statement;
import utils.DBConnector;

public class UserDAO {
    
    
    
     public UserDTO isUserLogin(UserDTO userLogin) {
        UserDTO loggedUser = new UserDTO();

        try (Connection con = DBConnector.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM users WHERE email='" + userLogin.getEmail() + "'")) {


            if (!rs.next()) {
                return null;
            }

            String storedPassword = rs.getString(4);
           
            if (userLogin.getEmail() != null
                    && userLogin.getPassword() != null
                    && userLogin.getPassword().equals(storedPassword)) {

                loggedUser.setUser_Id(rs.getInt(1));
                loggedUser.setUsername(rs.getString(2));
                loggedUser.setEmail(rs.getString(3));
                loggedUser.setBio(rs.getString(5));
                loggedUser.setProfile_Photo(rs.getString(5));
          
                return loggedUser;
            } else {
                System.out.println(" Password mismatch. Login failed.");
            }

        } catch (SQLException e) {
            System.out.println("Exception during login: " + e);
        }
        return null;
    }
     
     public boolean save(UserDTO newUser) {

    try (Connection con = DBConnector.getConnection()) {

        // Check if email already exists
        String checkQuery = "SELECT 1 FROM users WHERE email = ?";
        try (PreparedStatement checkPs = con.prepareStatement(checkQuery)) {
            checkPs.setString(1, newUser.getEmail());
            ResultSet rs = checkPs.executeQuery();
            if (rs.next()) {
                return false;
            }
        }

        // Insert user
        String insertQuery =
            "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(insertQuery)) {
            ps.setString(1, newUser.getUsername());
            ps.setString(2, newUser.getEmail());
            ps.setString(3, newUser.getPassword());

            boolean inserted = ps.executeUpdate() > 0;
            System.out.println("Insert success: " + inserted);
            return inserted;
        }

    } catch (SQLException e) {
        System.out.println("[ERROR] Exception during user signup: " + e.getMessage());
        return false;
    }
}

    
}
