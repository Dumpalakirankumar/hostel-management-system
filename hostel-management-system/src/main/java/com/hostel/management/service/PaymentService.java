package com.hostel.management.service;

import java.util.List;

import com.hostel.management.dto.request.PaymentRequestDTO;
import com.hostel.management.dto.response.PaymentResponseDTO;

public interface PaymentService {

    PaymentResponseDTO createPayment(
            PaymentRequestDTO requestDTO);

    List<PaymentResponseDTO> getAllPayments();

    PaymentResponseDTO updatePayment(
            Long paymentId,
            PaymentRequestDTO requestDTO);

    void deletePayment(
            Long paymentId);
}