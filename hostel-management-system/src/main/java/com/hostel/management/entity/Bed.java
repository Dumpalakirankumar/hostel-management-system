package com.hostel.management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_BED")
public class Bed {

    @Id
    @SequenceGenerator(
            name = "bed_seq",
            sequenceName = "SEQ_BED_ID",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bed_seq")
    private Long bedId;

    @Column(nullable = false)
    private String bedNumber;

    private String status;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    public Bed() {
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}