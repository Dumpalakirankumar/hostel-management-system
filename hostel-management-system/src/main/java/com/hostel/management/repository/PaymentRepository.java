package com.hostel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hostel.management.entity.Payment;

public interface PaymentRepository
        extends JpaRepository<Payment, Long> {

}