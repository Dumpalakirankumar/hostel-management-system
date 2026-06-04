package com.hostel.management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_ROOM")
public class Room {

    @Id
    @SequenceGenerator(
            name = "room_seq",
            sequenceName = "SEQ_ROOM_ID",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "room_seq")
    private Long roomId;

    @Column(nullable = false)
    private String roomNumber;

    private String roomType;

    private Integer capacity;

    private Integer occupiedBeds;

    private Integer availableBeds;

    private Double monthlyRent;

    private Integer floorNumber;

    private String status;

    @ManyToOne
    @JoinColumn(name = "HOSTEL_ID")
    private Hostel hostel;

    public Room() {
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

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }
}