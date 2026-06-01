package com.hostel.management.dto.response;

public class UserResponseDTO {

    private Long userId;
    private String username;
    private String email;
    private String mobileNumber;
    private String roleName;

    // Default Constructor
    public UserResponseDTO() {
    }

    // Parameterized Constructor
    public UserResponseDTO(Long userId,
                           String username,
                           String email,
                           String mobileNumber,
                           String roleName) {

        this.userId = userId;
        this.username = username;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.roleName = roleName;
    }

    // Getter for userId
    public Long getUserId() {
        return userId;
    }

    // Setter for userId
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for mobileNumber
    public String getMobileNumber() {
        return mobileNumber;
    }

    // Setter for mobileNumber
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    // Getter for roleName
    public String getRoleName() {
        return roleName;
    }

    // Setter for roleName
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}