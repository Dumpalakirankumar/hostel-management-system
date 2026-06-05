package com.hostel.management.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hostel.management.dto.response.PaymentReportResponseDTO;
import com.hostel.management.entity.Payment;
import com.hostel.management.repository.PaymentRepository;
import com.hostel.management.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

    private final PaymentRepository paymentRepository;

    public ReportServiceImpl(
            PaymentRepository paymentRepository) {

        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentReportResponseDTO getPaymentReport() {

        List<Payment> payments =
                paymentRepository.findAll();

        Double totalAmount =
                payments.stream()
                        .mapToDouble(Payment::getAmount)
                        .sum();

        return new PaymentReportResponseDTO(
                (long) payments.size(),
                totalAmount);
    }
}