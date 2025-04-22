package com.Pitchperfect.util;

import jakarta.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Utility class for handling image uploads in the Pitch Perfect application.
 */
public class ImageUtil {
    
    // Base directory for image uploads (relative to webapp)
    private static final String UPLOAD_BASE_DIR = "/resources/images/";
    
    /**
     * Uploads a profile image to the server.
     * @param imagePart The uploaded file part
     * @param username The username to associate with the image
     * @return The relative path where the image was saved, or null if upload failed
     * @throws IOException if an I/O error occurs
     */
    public String uploadProfileImage(Part imagePart, String username) throws IOException {
        if (imagePart == null || imagePart.getSize() == 0) {
            return null;
        }
        
        // Get the web application root path
        String appPath = System.getProperty("catalina.base") + "/webapps/Pitch_Perfect";
        
        // Create upload directory if it doesn't exist
        Path uploadDir = Paths.get(appPath + UPLOAD_BASE_DIR + "profiles");
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        
        // Generate unique filename
        String originalFileName = getFileName(imagePart);
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String uniqueFileName = username + "_" + UUID.randomUUID().toString() + fileExtension;
        
        // Save the file
        Path filePath = uploadDir.resolve(uniqueFileName);
        imagePart.write(filePath.toString());
        
        // Return relative path for database storage
        return UPLOAD_BASE_DIR + "profiles/" + uniqueFileName;
    }
    
    /**
     * Extracts the filename from a Part object.
     * @param part The file part to process
     * @return The original filename or "default.png" if not found
     */
    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                return item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }
        return "default.png";
    }
    
    /**
     * Validates if a file is an image.
     * @param part The file part to validate
     * @return true if the file is an image, false otherwise
     */
    public boolean isImageFile(Part part) {
        if (part == null || part.getSize() == 0) {
            return false;
        }
        
        String fileName = getFileName(part).toLowerCase();
        return fileName.endsWith(".jpg") || 
               fileName.endsWith(".jpeg") ||
               fileName.endsWith(".png") ||
               fileName.endsWith(".gif");
    }
    
    /**
     * Deletes an existing profile image.
     * @param imagePath The relative path of the image to delete
     * @return true if deletion was successful or file didn't exist, false otherwise
     */
    public boolean deleteProfileImage(String imagePath) {
        if (imagePath == null || imagePath.isEmpty()) {
            return true;
        }
        
        try {
            String fullPath = System.getProperty("catalina.base") + "/webapps/Pitch_Perfect" + imagePath;
            return Files.deleteIfExists(Paths.get(fullPath));
        } catch (IOException e) {
            return false;
        }
    }
}