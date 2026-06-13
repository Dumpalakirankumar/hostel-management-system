package com.hostel.management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hostel.management.dto.request.PaymentRequestDTO;
import com.hostel.management.dto.response.PaymentResponseDTO;
import com.hostel.management.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(
            PaymentService paymentService) {

        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentResponseDTO>
    createPayment(
            @RequestBody PaymentRequestDTO requestDTO) {

        return ResponseEntity.ok(
                paymentService.createPayment(
                        requestDTO));
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponseDTO>>
    getAllPayments() {

        return ResponseEntity.ok(
                paymentService.getAllPayments());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> updatePayment(
            @PathVariable Long id,
            @RequestBody PaymentRequestDTO requestDTO) {

        return ResponseEntity.ok(
                paymentService.updatePayment(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(
            @PathVariable Long id) {

        paymentService.deletePayment(id);

        return ResponseEntity.noContent().build();
    }
}