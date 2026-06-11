package com.hostel.management.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hostel.management.dto.request.HostelRequestDTO;
import com.hostel.management.dto.response.HostelResponseDTO;

public interface HostelService {

    HostelResponseDTO createHostel(
            HostelRequestDTO requestDTO);

    List<HostelResponseDTO> getAllHostels();

    Page<HostelResponseDTO> getAllHostels(
            int page,
            int size);

    List<HostelResponseDTO> getHostelsByCity(
            String city);

    HostelResponseDTO updateHostel(
            Long hostelId,
            HostelRequestDTO requestDTO);

    void deleteHostel(
            Long hostelId);
}