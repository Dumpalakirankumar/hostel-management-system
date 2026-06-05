package com.hostel.management.service;

import java.util.List;

import com.hostel.management.dto.request.HostelRequestDTO;
import com.hostel.management.dto.response.HostelResponseDTO;

import org.springframework.data.domain.Page;

public interface HostelService {

    HostelResponseDTO createHostel(
            HostelRequestDTO requestDTO);

    List<HostelResponseDTO> getAllHostels();

    Page<HostelResponseDTO> getAllHostels(
            int page,
            int size);
    
    List<HostelResponseDTO> getHostelsByCity(
            String city);
}
