package com.hostel.management.service;

import java.util.List;

import com.hostel.management.dto.request.HostelRequestDTO;
import com.hostel.management.dto.response.HostelResponseDTO;

public interface HostelService {

    HostelResponseDTO createHostel(
            HostelRequestDTO requestDTO);

    List<HostelResponseDTO> getAllHostels();
}