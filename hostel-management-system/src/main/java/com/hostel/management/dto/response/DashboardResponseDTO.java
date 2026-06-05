package com.hostel.management.dto.response;

public class DashboardResponseDTO {

    private Long totalHostels;
    private Long totalRooms;
    private Long totalBeds;
    private Long totalResidents;
    private Long totalPayments;

    public DashboardResponseDTO() {
    }

    public DashboardResponseDTO(
            Long totalHostels,
            Long totalRooms,
            Long totalBeds,
            Long totalResidents,
            Long totalPayments) {

        this.totalHostels = totalHostels;
        this.totalRooms = totalRooms;
        this.totalBeds = totalBeds;
        this.totalResidents = totalResidents;
        this.totalPayments = totalPayments;
    }

	public Long getTotalHostels() {
		return totalHostels;
	}

	public void setTotalHostels(Long totalHostels) {
		this.totalHostels = totalHostels;
	}

	public Long getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(Long totalRooms) {
		this.totalRooms = totalRooms;
	}

	public Long getTotalBeds() {
		return totalBeds;
	}

	public void setTotalBeds(Long totalBeds) {
		this.totalBeds = totalBeds;
	}

	public Long getTotalResidents() {
		return totalResidents;
	}

	public void setTotalResidents(Long totalResidents) {
		this.totalResidents = totalResidents;
	}

	public Long getTotalPayments() {
		return totalPayments;
	}

	public void setTotalPayments(Long totalPayments) {
		this.totalPayments = totalPayments;
	}

    // Generate getters and setters
}