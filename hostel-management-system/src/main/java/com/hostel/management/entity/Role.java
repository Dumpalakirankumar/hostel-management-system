package com.hostel.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_ROLE")
public class Role {

    @Id
    @SequenceGenerator(
            name = "role_seq",
            sequenceName = "SEQ_ROLE_ID",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_seq")
    private Long roleId;

    @Column(
            name = "ROLE_NAME",
            nullable = false,
            unique = true)
    private String roleName;

    private String description;

    // Default Constructor
    public Role() {
    }

    // Parameterized Constructor
    public Role(Long roleId, String roleName, String description) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.description = description;
    }

    // Getter for roleId
    public Long getRoleId() {
        return roleId;
    }

    // Setter for roleId
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    // Getter for roleName
    public String getRoleName() {
        return roleName;
    }

    // Setter for roleName
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }
}