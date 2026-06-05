package com.hostel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hostel.management.entity.Bed;

public interface BedRepository
        extends JpaRepository<Bed, Long> {
}