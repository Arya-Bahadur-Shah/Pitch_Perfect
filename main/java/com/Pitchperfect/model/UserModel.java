package com.Pitchperfect.model;


import java.time.LocalDate;

import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class UserModel
 */
@WebServlet("/UserModel")

public class UserModel {

    private String username;

    private String firstName;

    private String lastName;

    private LocalDate dob;

    private String email;

    private String phone;

    private String password;



    // Constructor for login

    public UserModel(String username, String password) {

        this.username = username;

        this.password = password;

    }



    // Constructor for insert (without ID)

    public UserModel(String firstName, String lastName, String username, LocalDate dob,

                     String email, String phone, String password) {

        this.firstName = firstName;

        this.lastName = lastName;

        this.username = username;

        this.dob = dob;

        this.email = email;

        this.phone = phone;

        this.password = password;

    }



/*    // Full constructor with ID (for fetch/update)

    public usermodel(int id, String firstName, String lastName, String username, LocalDate dob, String gender,

                     String email, String phoneNumber, String password) {

        this.id = id;

        this.firstName = firstName;

        this.lastName = lastName;

        this.username = username;

        this.dob = dob;

        this.gender = gender;

        this.email = email;

        this.phoneNumber = phoneNumber;

        this.password = password;

    }



    // Constructor for listing (partial fields)

    public usermodel(int id, String firstName, String lastName, String email, String phoneNumber) {

        this.id = id;

        this.firstName = firstName;

        this.lastName = lastName;

        this.email = email;

        this.phoneNumber = phoneNumber;

    }

*/

    // Getters and Setters



   



    public String getUsername() {

        return username;

    }



    public void setUsername(String username) {

        this.username = username;

    }



    public String getFirstName() {

        return firstName;

    }



    public void setFirstName(String firstName) {

        this.firstName = firstName;

    }



    public String getLastName() {

        return lastName;

    }



    public void setLastName(String lastName) {

        this.lastName = lastName;

    }



    public LocalDate getDob() {

        return dob;

    }



    public void setDob(LocalDate dob) {

        this.dob = dob;

    }



    public String getEmail() {

        return email;

    }



    public void setEmail(String email) {

        this.email = email;

    }



    public String getPhoneNumber() {

        return phone;

    }



    public void setPhoneNumber(String phone) {

        this.phone = phone;

    }



    public String getPassword() {

        return password;

    }



    public void setPassword(String password) {

        this.password = password;

    }

}