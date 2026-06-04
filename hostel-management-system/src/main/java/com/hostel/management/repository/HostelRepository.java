package com.hostel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hostel.management.entity.Hostel;

public interface HostelRepository
        extends JpaRepository<Hostel, Long> {
}