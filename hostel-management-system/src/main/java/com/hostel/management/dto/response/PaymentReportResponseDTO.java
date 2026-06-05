package com.hostel.management.dto.response;

public class PaymentReportResponseDTO {

    private Long totalPayments;
    private Double totalAmountCollected;

    public PaymentReportResponseDTO() {
    }

    public PaymentReportResponseDTO(
            Long totalPayments,
            Double totalAmountCollected) {

        this.totalPayments = totalPayments;
        this.totalAmountCollected = totalAmountCollected;
    }

    public Long getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(Long totalPayments) {
        this.totalPayments = totalPayments;
    }

    public Double getTotalAmountCollected() {
        return totalAmountCollected;
    }

    public void setTotalAmountCollected(
            Double totalAmountCollected) {

        this.totalAmountCollected =
                totalAmountCollected;
    }
}