package com.hostel.management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hostel.management.dto.request.HostelRequestDTO;
import com.hostel.management.dto.response.HostelResponseDTO;
import com.hostel.management.entity.Hostel;
import com.hostel.management.repository.HostelRepository;
import com.hostel.management.service.HostelService;

@Service
public class HostelServiceImpl implements HostelService {

    private final HostelRepository hostelRepository;

    public HostelServiceImpl(HostelRepository hostelRepository) {
        this.hostelRepository = hostelRepository;
    }

    @Override
    public HostelResponseDTO createHostel(
            HostelRequestDTO requestDTO) {

        Hostel hostel = new Hostel();

        hostel.setHostelName(requestDTO.getHostelName());
        hostel.setAddress(requestDTO.getAddress());
        hostel.setCity(requestDTO.getCity());
        hostel.setState(requestDTO.getState());
        hostel.setPincode(requestDTO.getPincode());
        hostel.setContactNumber(requestDTO.getContactNumber());
        hostel.setEmail(requestDTO.getEmail());

        Hostel savedHostel = hostelRepository.save(hostel);

        return new HostelResponseDTO(
                savedHostel.getHostelId(),
                savedHostel.getHostelName(),
                savedHostel.getAddress(),
                savedHostel.getCity(),
                savedHostel.getState(),
                savedHostel.getPincode(),
                savedHostel.getContactNumber(),
                savedHostel.getEmail());
    }

    @Override
    public List<HostelResponseDTO> getAllHostels() {

        return hostelRepository.findAll()
                .stream()
                .map(hostel -> new HostelResponseDTO(
                        hostel.getHostelId(),
                        hostel.getHostelName(),
                        hostel.getAddress(),
                        hostel.getCity(),
                        hostel.getState(),
                        hostel.getPincode(),
                        hostel.getContactNumber(),
                        hostel.getEmail()))
                .collect(Collectors.toList());
    }

    @Override
    public Page<HostelResponseDTO> getAllHostels(
            int page,
            int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Hostel> hostelPage =
                hostelRepository.findAll(pageable);

        List<HostelResponseDTO> hostelDTOs =
                hostelPage.getContent()
                        .stream()
                        .map(hostel -> new HostelResponseDTO(
                                hostel.getHostelId(),
                                hostel.getHostelName(),
                                hostel.getAddress(),
                                hostel.getCity(),
                                hostel.getState(),
                                hostel.getPincode(),
                                hostel.getContactNumber(),
                                hostel.getEmail()))
                        .toList();

        return new PageImpl<>(
                hostelDTOs,
                pageable,
                hostelPage.getTotalElements());
    }

    @Override
    public List<HostelResponseDTO> getHostelsByCity(
            String city) {

        return hostelRepository.findByCity(city)
                .stream()
                .map(hostel -> new HostelResponseDTO(
                        hostel.getHostelId(),
                        hostel.getHostelName(),
                        hostel.getAddress(),
                        hostel.getCity(),
                        hostel.getState(),
                        hostel.getPincode(),
                        hostel.getContactNumber(),
                        hostel.getEmail()))
                .toList();
    }

    @Override
    public HostelResponseDTO updateHostel(
            Long hostelId,
            HostelRequestDTO requestDTO) {

        Hostel hostel = hostelRepository.findById(hostelId)
                .orElseThrow(() ->
                        new RuntimeException("Hostel not found"));

        hostel.setHostelName(requestDTO.getHostelName());
        hostel.setAddress(requestDTO.getAddress());
        hostel.setCity(requestDTO.getCity());
        hostel.setState(requestDTO.getState());
        hostel.setPincode(requestDTO.getPincode());
        hostel.setContactNumber(requestDTO.getContactNumber());
        hostel.setEmail(requestDTO.getEmail());

        Hostel updatedHostel = hostelRepository.save(hostel);

        return new HostelResponseDTO(
                updatedHostel.getHostelId(),
                updatedHostel.getHostelName(),
                updatedHostel.getAddress(),
                updatedHostel.getCity(),
                updatedHostel.getState(),
                updatedHostel.getPincode(),
                updatedHostel.getContactNumber(),
                updatedHostel.getEmail());
    }

    @Override
    public void deleteHostel(Long hostelId) {

        Hostel hostel = hostelRepository.findById(hostelId)
                .orElseThrow(() ->
                        new RuntimeException("Hostel not found"));

        hostelRepository.delete(hostel);
    }
}