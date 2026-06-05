package com.hostel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hostel.management.entity.Hostel;


import java.util.List;

public interface HostelRepository
        extends JpaRepository<Hostel, Long> {
	List<Hostel> findByCity(String city);
}