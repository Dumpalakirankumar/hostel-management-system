package com.hostel.management.service;

import java.util.List;

import com.hostel.management.dto.request.RoomRequestDTO;
import com.hostel.management.dto.response.RoomResponseDTO;

public interface RoomService {

    RoomResponseDTO createRoom(
            RoomRequestDTO requestDTO);

    List<RoomResponseDTO> getAllRooms();

    RoomResponseDTO updateRoom(
            Long roomId,
            RoomRequestDTO requestDTO);

    void deleteRoom(
            Long roomId);
}