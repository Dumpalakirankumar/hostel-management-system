package com.hostel.management.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hostel.management.dto.request.PaymentRequestDTO;
import com.hostel.management.dto.response.PaymentResponseDTO;
import com.hostel.management.entity.Payment;
import com.hostel.management.entity.Resident;
import com.hostel.management.repository.PaymentRepository;
import com.hostel.management.repository.ResidentRepository;
import com.hostel.management.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final ResidentRepository residentRepository;

    public PaymentServiceImpl(
            PaymentRepository paymentRepository,
            ResidentRepository residentRepository) {

        this.paymentRepository = paymentRepository;
        this.residentRepository = residentRepository;
    }

    @Override
    public PaymentResponseDTO createPayment(
            PaymentRequestDTO requestDTO) {

        Resident resident =
                residentRepository.findById(
                        requestDTO.getResidentId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Resident not found"));

        Payment payment = new Payment();

        payment.setAmount(
                requestDTO.getAmount());

        payment.setPaymentMode(
                requestDTO.getPaymentMode());

        payment.setPaymentStatus(
                requestDTO.getPaymentStatus());

        payment.setPaymentDate(
                LocalDate.now());

        payment.setResident(resident);

        Payment savedPayment =
                paymentRepository.save(payment);

        return new PaymentResponseDTO(
                savedPayment.getPaymentId(),
                savedPayment.getAmount(),
                savedPayment.getPaymentDate(),
                savedPayment.getPaymentMode(),
                savedPayment.getPaymentStatus(),
                savedPayment.getResident().getResidentId());
    }

    @Override
    public List<PaymentResponseDTO> getAllPayments() {

        return paymentRepository.findAll()
                .stream()
                .map(payment -> new PaymentResponseDTO(
                        payment.getPaymentId(),
                        payment.getAmount(),
                        payment.getPaymentDate(),
                        payment.getPaymentMode(),
                        payment.getPaymentStatus(),
                        payment.getResident().getResidentId()))
                .collect(Collectors.toList());
    }
    
    @Override
    public PaymentResponseDTO updatePayment(
            Long paymentId,
            PaymentRequestDTO requestDTO) {

        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() ->
                        new RuntimeException("Payment not found"));

        Resident resident = residentRepository.findById(
                requestDTO.getResidentId())
                .orElseThrow(() ->
                        new RuntimeException("Resident not found"));

        payment.setAmount(requestDTO.getAmount());
        payment.setPaymentMode(requestDTO.getPaymentMode());
        payment.setPaymentStatus(requestDTO.getPaymentStatus());
        payment.setResident(resident);

        Payment updatedPayment =
                paymentRepository.save(payment);

        return new PaymentResponseDTO(
                updatedPayment.getPaymentId(),
                updatedPayment.getAmount(),
                updatedPayment.getPaymentDate(),
                updatedPayment.getPaymentMode(),
                updatedPayment.getPaymentStatus(),
                updatedPayment.getResident().getResidentId());
    }

    @Override
    public void deletePayment(Long paymentId) {

        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() ->
                        new RuntimeException("Payment not found"));

        paymentRepository.delete(payment);
    }
}