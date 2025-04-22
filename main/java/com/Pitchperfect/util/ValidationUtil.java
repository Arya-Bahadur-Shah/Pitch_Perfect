package com.Pitchperfect.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;
import jakarta.servlet.http.Part;



/**
 * Utility class for validating various types of input data in the Pitch Perfect application.
 */
public class ValidationUtil {
    
    // Username pattern: 4-20 chars, letters, numbers, underscores
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_]{4,20}$";
    
    // Email pattern (RFC 5322 compliant)
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    
    // Phone pattern (supports international formats)
    private static final String PHONE_PATTERN = "^\\+(?:[0-9] ?){6,14}[0-9]$";
    
    // Password pattern: 8+ chars, 1 upper, 1 lower, 1 digit, 1 special
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    
    // Image extensions
    private static final String[] ALLOWED_IMAGE_EXTENSIONS = {".jpg", ".jpeg", ".png", ".gif"};

    private ValidationUtil() {
        throw new IllegalStateException("Utility class");
    }

    // 1. Basic null/empty check
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    // 2. Validate username format
    public static boolean isValidUsername(String username) {
        return username != null && Pattern.matches(USERNAME_PATTERN, username);
    }

    // 3. Validate full name (allows spaces and international characters)
    public static boolean isValidFullName(String name) {
        return name != null && name.matches("^[\\p{L} .'-]+$") && name.length() >= 2;
    }

    // 4. Validate email format
    public static boolean isValidEmail(String email) {
        return email != null && Pattern.matches(EMAIL_PATTERN, email);
    }

    // 5. Validate phone number format
    public static boolean isValidPhoneNumber(String phone) {
        return phone != null && Pattern.matches(PHONE_PATTERN, phone);
    }

    // 6. Validate password strength
    public static boolean isValidPassword(String password) {
        return password != null && Pattern.matches(PASSWORD_PATTERN, password);
    }

    // 7. Check if passwords match
    public static boolean doPasswordsMatch(String password, String confirmPassword) {
        return password != null && password.equals(confirmPassword);
    }

    // 8. Validate date of birth (minimum age)
    public static boolean isAgeAtLeast16(LocalDate dob) {
        if (dob == null) return false;
        return Period.between(dob, LocalDate.now()).getYears() >= 16;
    }

    // 9. Validate image file type
    public static boolean isValidImageFile(Part filePart) {
        if (filePart == null || filePart.getSize() == 0) {
            return false;
        }
        
        String fileName = filePart.getSubmittedFileName();
        if (fileName == null) return false;
        
        fileName = fileName.toLowerCase();
        for (String ext : ALLOWED_IMAGE_EXTENSIONS) {
            if (fileName.endsWith(ext)) {
                return true;
            }
        }
        return false;
    }

    // 10. Validate date format (YYYY-MM-DD)
    public static boolean isValidDate(String dateStr) {
        try {
            LocalDate.parse(dateStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 11. Validate sport field name (alphanumeric with spaces)
    public static boolean isValidSportFieldName(String name) {
        return name != null && name.matches("^[a-zA-Z0-9 ]{3,50}$");
    }

    // 12. Validate price format (positive decimal)
    public static boolean isValidPrice(String price) {
        return price != null && price.matches("^\\d+(\\.\\d{1,2})?$");
    }

    // 13. Validate time slot format (HH:MM)
    public static boolean isValidTimeSlot(String time) {
        return time != null && time.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
    }
}