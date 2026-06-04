package com.hostel.management.dto.response;

public class HostelResponseDTO {

    private Long hostelId;
    private String hostelName;
    private String address;
    private String city;
    private String state;
    private String pincode;
    private String contactNumber;
    private String email;

    public HostelResponseDTO() {
    }

    public HostelResponseDTO(Long hostelId,
                             String hostelName,
                             String address,
                             String city,
                             String state,
                             String pincode,
                             String contactNumber,
                             String email) {

        this.hostelId = hostelId;
        this.hostelName = hostelName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public Long getHostelId() {
        return hostelId;
    }

    public void setHostelId(Long hostelId) {
        this.hostelId = hostelId;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}