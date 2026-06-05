package com.hostel.management.dto.response;

import java.time.LocalDate;

public class PaymentResponseDTO {

    private Long paymentId;
    private Double amount;
    private LocalDate paymentDate;
    private String paymentMode;
    private String paymentStatus;
    private Long residentId;

    public PaymentResponseDTO() {
    }

    public PaymentResponseDTO(
            Long paymentId,
            Double amount,
            LocalDate paymentDate,
            String paymentMode,
            String paymentStatus,
            Long residentId) {

        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMode = paymentMode;
        this.paymentStatus = paymentStatus;
        this.residentId = residentId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getResidentId() {
        return residentId;
    }

    public void setResidentId(Long residentId) {
        this.residentId = residentId;
    }
}