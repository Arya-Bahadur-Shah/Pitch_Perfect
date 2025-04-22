package com.Pitchperfect.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.Pitchperfect.config.DbConfig;
import com.Pitchperfect.model.UserModel;
public class RegistrationService {

    private Connection dbConn;

    /**
     * Constructor initializes the database connection.
     */
    public RegistrationService() {
        try {
        	
            this.dbConn = DbConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Database connection error: " + ex.getMessage());
            ex.printStackTrace();
        }
        System.out.print("True");
    }

    /**
     * Registers a new user in the database.
     *
     * @param userModel the user details to be registered
     * @return Boolean indicating the success of the operation
     */
    
        public Boolean addUser(UserModel user) {
            String insertQuery = "INSERT INTO user (first_name, last_name, username, dob, email, phone, password) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (Connection conn = DbConfig.getDbConnection();
                 PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                
                pstmt.setString(1, user.getFirstName());
                pstmt.setString(2, user.getLastName());
                pstmt.setString(3, user.getUsername());
                pstmt.setDate(4, Date.valueOf(user.getDob()));
                pstmt.setString(5, user.getEmail());
                pstmt.setString(6, user.getPhoneNumber());
                pstmt.setString(7, user.getPassword());

                int rows = pstmt.executeUpdate();
                return rows > 0;
            } catch (SQLException | ClassNotFoundException ex) {
                System.err.println("Registration failed: " + ex.getMessage());
                ex.printStackTrace();
                return false;
            }
        }
    }
    
