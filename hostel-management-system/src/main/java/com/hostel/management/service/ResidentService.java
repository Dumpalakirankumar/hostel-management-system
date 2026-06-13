package com.hostel.management.service;

import java.util.List;

import com.hostel.management.dto.request.ResidentRequestDTO;
import com.hostel.management.dto.response.ResidentResponseDTO;

public interface ResidentService {

    ResidentResponseDTO createResident(
            ResidentRequestDTO requestDTO);

    List<ResidentResponseDTO> getAllResidents();

    ResidentResponseDTO updateResident(
            Long residentId,
            ResidentRequestDTO requestDTO);

    void deleteResident(
            Long residentId);
}