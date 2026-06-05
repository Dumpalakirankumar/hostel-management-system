package com.hostel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hostel.management.entity.Resident;

public interface ResidentRepository
        extends JpaRepository<Resident, Long> {
}