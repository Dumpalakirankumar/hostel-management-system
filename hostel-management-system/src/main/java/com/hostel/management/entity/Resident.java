package com.hostel.management.entity;

import com.hostel.management.audit.BaseEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_RESIDENT")
public class Resident extends BaseEntity {

    @Id
    @SequenceGenerator(
            name = "resident_seq",
            sequenceName = "SEQ_RESIDENT_ID",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "resident_seq")
    private Long residentId;

    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
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

	public Bed getBed() {
		return bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}

	private String gender;
    private String aadhaarNumber;

    @ManyToOne
    @JoinColumn(name = "BED_ID")
    private Bed bed;

    public Resident() {
    }

    // Generate getters and setters
}