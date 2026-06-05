package com.hostel.management.entity;

import java.time.LocalDate;

import com.hostel.management.audit.BaseEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_PAYMENT")
public class Payment extends BaseEntity {

    @Id
    @SequenceGenerator(
            name = "payment_seq",
            sequenceName = "SEQ_PAYMENT_ID",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_seq")
    private Long paymentId;

    private Double amount;

    private LocalDate paymentDate;

    private String paymentMode;

    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name = "RESIDENT_ID")
    private Resident resident;

    public Payment() {
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

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }
}