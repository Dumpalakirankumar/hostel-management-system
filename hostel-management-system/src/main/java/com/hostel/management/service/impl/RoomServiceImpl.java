package com.hostel.management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hostel.management.dto.request.RoomRequestDTO;
import com.hostel.management.dto.response.RoomResponseDTO;
import com.hostel.management.entity.Hostel;
import com.hostel.management.entity.Room;
import com.hostel.management.repository.HostelRepository;
import com.hostel.management.repository.RoomRepository;
import com.hostel.management.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final HostelRepository hostelRepository;

    public RoomServiceImpl(
            RoomRepository roomRepository,
            HostelRepository hostelRepository) {

        this.roomRepository = roomRepository;
        this.hostelRepository = hostelRepository;
    }

    @Override
    public RoomResponseDTO createRoom(
            RoomRequestDTO requestDTO) {

        Hostel hostel =
                hostelRepository.findById(
                        requestDTO.getHostelId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Hostel not found"));

        Room room = new Room();

        room.setRoomNumber(
                requestDTO.getRoomNumber());

        room.setRoomType(
                requestDTO.getRoomType());

        room.setCapacity(
                requestDTO.getCapacity());

        room.setOccupiedBeds(0);

        room.setAvailableBeds(
                requestDTO.getCapacity());

        room.setMonthlyRent(
                requestDTO.getMonthlyRent());

        room.setFloorNumber(
                requestDTO.getFloorNumber());

        room.setStatus(
                requestDTO.getStatus());

        room.setHostel(hostel);

        Room savedRoom =
                roomRepository.save(room);

        return new RoomResponseDTO(
                savedRoom.getRoomId(),
                savedRoom.getRoomNumber(),
                savedRoom.getRoomType(),
                savedRoom.getCapacity(),
                savedRoom.getOccupiedBeds(),
                savedRoom.getAvailableBeds(),
                savedRoom.getMonthlyRent(),
                savedRoom.getFloorNumber(),
                savedRoom.getStatus(),
                savedRoom.getHostel().getHostelId()
        );
    }

    @Override
    public List<RoomResponseDTO> getAllRooms() {

        return roomRepository.findAll()
                .stream()
                .map(room -> new RoomResponseDTO(
                        room.getRoomId(),
                        room.getRoomNumber(),
                        room.getRoomType(),
                        room.getCapacity(),
                        room.getOccupiedBeds(),
                        room.getAvailableBeds(),
                        room.getMonthlyRent(),
                        room.getFloorNumber(),
                        room.getStatus(),
                        room.getHostel().getHostelId()))
                .collect(Collectors.toList());
    }
}