package com.hostel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hostel.management.entity.UserRole;

@Repository
public interface UserRoleRepository
        extends JpaRepository<UserRole, Long> {
}
