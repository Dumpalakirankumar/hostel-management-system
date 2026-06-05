package com.hostel.management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostel.management.dto.response.PaymentReportResponseDTO;
import com.hostel.management.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(
            ReportService reportService) {

        this.reportService = reportService;
    }

    @GetMapping("/payments")
    public ResponseEntity<PaymentReportResponseDTO>
    getPaymentReport() {

        return ResponseEntity.ok(
                reportService.getPaymentReport());
    }
}