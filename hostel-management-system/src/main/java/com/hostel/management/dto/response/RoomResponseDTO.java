package com.hostel.management.dto.response;

public class RoomResponseDTO {

    private Long roomId;
    private String roomNumber;
    private String roomType;
    private Integer capacity;
    private Integer occupiedBeds;
    private Integer availableBeds;
    private Double monthlyRent;
    private Integer floorNumber;
    private String status;
    private Long hostelId;

    public RoomResponseDTO() {
    }

    public RoomResponseDTO(
            Long roomId,
            String roomNumber,
            String roomType,
            Integer capacity,
            Integer occupiedBeds,
            Integer availableBeds,
            Double monthlyRent,
            Integer floorNumber,
            String status,
            Long hostelId) {

        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.capacity = capacity;
        this.occupiedBeds = occupiedBeds;
        this.availableBeds = availableBeds;
        this.monthlyRent = monthlyRent;
        this.floorNumber = floorNumber;
        this.status = status;
        this.hostelId = hostelId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getOccupiedBeds() {
        return occupiedBeds;
    }

    public void setOccupiedBeds(Integer occupiedBeds) {
        this.occupiedBeds = occupiedBeds;
    }

    public Integer getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(Integer availableBeds) {
        this.availableBeds = availableBeds;
    }

    public Double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(Double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getHostelId() {
        return hostelId;
    }

    public void setHostelId(Long hostelId) {
        this.hostelId = hostelId;
    }
}