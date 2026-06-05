package com.hostel.management.dto.response;

public class ResidentResponseDTO {

    private Long residentId;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private String gender;
    private String aadhaarNumber;
    private Long bedId;

    public ResidentResponseDTO() {
    }

    public ResidentResponseDTO(
            Long residentId,
            String firstName,
            String lastName,
            String mobileNumber,
            String email,
            String gender,
            String aadhaarNumber,
            Long bedId) {

        this.residentId = residentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.gender = gender;
        this.aadhaarNumber = aadhaarNumber;
        this.bedId = bedId;
    }

    public Long getResidentId() {
        return residentId;
    }

    public void setResidentId(Long residentId) {
        this.residentId = residentId;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public Long getBedId() {
        return bedId;
    }

    public void setBedId(Long bedId) {
        this.bedId = bedId;
    }
}