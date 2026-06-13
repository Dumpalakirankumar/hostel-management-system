package com.hostel.management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hostel.management.dto.request.BedRequestDTO;
import com.hostel.management.dto.response.BedResponseDTO;
import com.hostel.management.entity.Bed;
import com.hostel.management.entity.Room;
import com.hostel.management.repository.BedRepository;
import com.hostel.management.repository.RoomRepository;
import com.hostel.management.service.BedService;

@Service
public class BedServiceImpl implements BedService {

    private final BedRepository bedRepository;
    private final RoomRepository roomRepository;

    public BedServiceImpl(
            BedRepository bedRepository,
            RoomRepository roomRepository) {

        this.bedRepository = bedRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public BedResponseDTO createBed(
            BedRequestDTO requestDTO) {

        Room room = roomRepository.findById(
                requestDTO.getRoomId())
                .orElseThrow(() ->
                        new RuntimeException("Room not found"));

        Bed bed = new Bed();

        bed.setBedNumber(requestDTO.getBedNumber());
        bed.setStatus(requestDTO.getStatus());
        bed.setRoom(room);

        Bed savedBed = bedRepository.save(bed);

        return new BedResponseDTO(
                savedBed.getBedId(),
                savedBed.getBedNumber(),
                savedBed.getStatus(),
                savedBed.getRoom().getRoomId());
    }

    @Override
    public List<BedResponseDTO> getAllBeds() {

        return bedRepository.findAll()
                .stream()
                .map(bed -> new BedResponseDTO(
                        bed.getBedId(),
                        bed.getBedNumber(),
                        bed.getStatus(),
                        bed.getRoom().getRoomId()))
                .collect(Collectors.toList());
    }

    @Override
    public BedResponseDTO updateBed(
            Long bedId,
            BedRequestDTO requestDTO) {

        Bed bed = bedRepository.findById(bedId)
                .orElseThrow(() ->
                        new RuntimeException("Bed not found"));

        Room room = roomRepository.findById(
                requestDTO.getRoomId())
                .orElseThrow(() ->
                        new RuntimeException("Room not found"));

        bed.setBedNumber(requestDTO.getBedNumber());
        bed.setStatus(requestDTO.getStatus());
        bed.setRoom(room);

        Bed updatedBed = bedRepository.save(bed);

        return new BedResponseDTO(
                updatedBed.getBedId(),
                updatedBed.getBedNumber(),
                updatedBed.getStatus(),
                updatedBed.getRoom().getRoomId());
    }

    @Override
    public void deleteBed(Long bedId) {

        Bed bed = bedRepository.findById(bedId)
                .orElseThrow(() ->
                        new RuntimeException("Bed not found"));

        bedRepository.delete(bed);
    }
}