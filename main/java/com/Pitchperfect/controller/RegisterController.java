package com.Pitchperfect.controller;

import com.Pitchperfect.model.UserModel;
import com.Pitchperfect.service.RegistrationService;
import com.Pitchperfect.util.PasswordUtil;
import com.Pitchperfect.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;




@WebServlet("/register")
@MultipartConfig
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private final RegistrationService registrationService = new RegistrationService();
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/Registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	System.out.println("Registration attempt started...");
    	
        // Extract parameters from request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String dobStr = request.getParameter("dob");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Validate form inputs
        String validationError = validateInputs(firstName, lastName, username, dobStr, 
                                              email, phone, password, confirmPassword);
        
        if (validationError != null) {
            request.setAttribute("error", validationError);
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("username", username);
            request.setAttribute("dob", dobStr);
            request.setAttribute("email", email);
            request.setAttribute("phone", phone);
            request.getRequestDispatcher("WEB-INF/pages/Registration.jsp").forward(request, response);
            return;
        }

        // Convert dob string to LocalDate
        LocalDate dob = LocalDate.parse(dobStr);
        
        // Encrypt password
        String encryptedPassword = PasswordUtil.encrypt(username, password);
        
        // Create UserModel object
        UserModel user = new UserModel(firstName, lastName, username, dob, email, phone, encryptedPassword);
        
        // Attempt registration
        Boolean registrationResult = registrationService.addUser(user);
        
        if (registrationResult == null) {
            // Database error
            request.setAttribute("error", "Registration failed due to server error. Please try again.");
            request.getRequestDispatcher("WEB-INF/pages/Registration.jsp").forward(request, response);
        } else if (registrationResult) {
            // Success
            request.setAttribute("success", "Registration successful! Please login.");
            request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
        } else {
            // Username/email already exists
            request.setAttribute("error", "Username or email already exists.");
            request.getRequestDispatcher("WEB-INF/pages/Registration.jsp").forward(request, response);
        }
    }

    private String validateInputs(String firstName, String lastName, String username, 
                                String dobStr, String email, String phone, 
                                String password, String confirmPassword) {
        
        if (ValidationUtil.isNullOrEmpty(firstName)) return "First name is required";
        if (ValidationUtil.isNullOrEmpty(lastName)) return "Last name is required";
        if (ValidationUtil.isNullOrEmpty(username)) return "Username is required";
        if (ValidationUtil.isNullOrEmpty(dobStr)) return "Date of birth is required";
        if (ValidationUtil.isNullOrEmpty(email)) return "Email is required";
        if (ValidationUtil.isNullOrEmpty(phone)) return "Phone number is required";
        if (ValidationUtil.isNullOrEmpty(password)) return "Password is required";
        if (ValidationUtil.isNullOrEmpty(confirmPassword)) return "Please confirm your password";

        try {
            LocalDate dob = LocalDate.parse(dobStr);
            if (!ValidationUtil.isAgeAtLeast16(dob)) {
                return "You must be at least 16 years old to register";
            }
        } catch (Exception e) {
            return "Invalid date format. Please use YYYY-MM-DD";
        }

        if (!ValidationUtil.isValidUsername(username)) {
            return "Username must be 4-20 alphanumeric characters";
        }

        if (!ValidationUtil.isValidEmail(email)) {
            return "Invalid email format";
        }

        if (!ValidationUtil.isValidPhoneNumber(phone)) {
            return "Invalid phone number format";
        }

        if (!ValidationUtil.isValidPassword(password)) {
            return "Password must be 8+ chars with uppercase, number, and special char";
        }

        if (!password.equals(confirmPassword)) {
            return "Passwords do not match";
        }

        return null;
    }
    
}