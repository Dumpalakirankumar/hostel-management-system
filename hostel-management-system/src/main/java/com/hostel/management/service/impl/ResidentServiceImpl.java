package com.hostel.management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hostel.management.dto.request.ResidentRequestDTO;
import com.hostel.management.dto.response.ResidentResponseDTO;
import com.hostel.management.entity.Bed;
import com.hostel.management.entity.Resident;
import com.hostel.management.repository.BedRepository;
import com.hostel.management.repository.ResidentRepository;
import com.hostel.management.service.ResidentService;

@Service
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository residentRepository;
    private final BedRepository bedRepository;

    public ResidentServiceImpl(
            ResidentRepository residentRepository,
            BedRepository bedRepository) {

        this.residentRepository = residentRepository;
        this.bedRepository = bedRepository;
    }

    @Override
    public ResidentResponseDTO createResident(
            ResidentRequestDTO requestDTO) {

        Bed bed = bedRepository.findById(
                requestDTO.getBedId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Bed not found"));

        Resident resident = new Resident();

        resident.setFirstName(
                requestDTO.getFirstName());

        resident.setLastName(
                requestDTO.getLastName());

        resident.setMobileNumber(
                requestDTO.getMobileNumber());

        resident.setEmail(
                requestDTO.getEmail());

        resident.setGender(
                requestDTO.getGender());

        resident.setAadhaarNumber(
                requestDTO.getAadhaarNumber());

        resident.setBed(bed);

        Resident savedResident =
                residentRepository.save(resident);

        return new ResidentResponseDTO(
                savedResident.getResidentId(),
                savedResident.getFirstName(),
                savedResident.getLastName(),
                savedResident.getMobileNumber(),
                savedResident.getEmail(),
                savedResident.getGender(),
                savedResident.getAadhaarNumber(),
                savedResident.getBed().getBedId());
    }

    @Override
    public List<ResidentResponseDTO> getAllResidents() {

        return residentRepository.findAll()
                .stream()
                .map(resident -> new ResidentResponseDTO(
                        resident.getResidentId(),
                        resident.getFirstName(),
                        resident.getLastName(),
                        resident.getMobileNumber(),
                        resident.getEmail(),
                        resident.getGender(),
                        resident.getAadhaarNumber(),
                        resident.getBed().getBedId()))
                .collect(Collectors.toList());
    }
}