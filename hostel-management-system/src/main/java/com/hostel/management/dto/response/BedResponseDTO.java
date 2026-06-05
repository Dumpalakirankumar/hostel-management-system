package com.hostel.management.dto.response;

public class BedResponseDTO {

    private Long bedId;
    private String bedNumber;
    private String status;
    private Long roomId;

    public BedResponseDTO() {
    }

    public BedResponseDTO(
            Long bedId,
            String bedNumber,
            String status,
            Long roomId) {

        this.bedId = bedId;
        this.bedNumber = bedNumber;
        this.status = status;
        this.roomId = roomId;
    }

    public Long getBedId() {
        return bedId;
    }

    public void setBedId(Long bedId) {
        this.bedId = bedId;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}