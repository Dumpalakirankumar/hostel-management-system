package com.hostel.management.service;

import java.util.List;

import com.hostel.management.dto.request.BedRequestDTO;
import com.hostel.management.dto.response.BedResponseDTO;

public interface BedService {

    BedResponseDTO createBed(
            BedRequestDTO requestDTO);

    List<BedResponseDTO> getAllBeds();
}