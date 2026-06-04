package com.hostel.management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_HOSTEL")
public class Hostel {

    @Id
    @SequenceGenerator(
            name = "hostel_seq",
            sequenceName = "SEQ_HOSTEL_ID",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hostel_seq")
    private Long hostelId;

    @Column(nullable = false)
    private String hostelName;

    private String address;
    private String city;
    private String state;
    private String pincode;
    private String contactNumber;
    private String email;

    public Hostel() {
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