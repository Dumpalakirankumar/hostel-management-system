package com.hostel.management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hostel.management.dto.request.RoomRequestDTO;
import com.hostel.management.dto.response.RoomResponseDTO;
import com.hostel.management.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(
            RoomService roomService) {

        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<RoomResponseDTO>
    createRoom(
            @RequestBody RoomRequestDTO requestDTO) {

        return ResponseEntity.ok(
                roomService.createRoom(
                        requestDTO));
    }

    @GetMapping
    public ResponseEntity<List<RoomResponseDTO>>
    getAllRooms() {

        return ResponseEntity.ok(
                roomService.getAllRooms());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<RoomResponseDTO> updateRoom(
            @PathVariable Long id,
            @RequestBody RoomRequestDTO requestDTO) {

        return ResponseEntity.ok(
                roomService.updateRoom(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(
            @PathVariable Long id) {

        roomService.deleteRoom(id);

        return ResponseEntity.noContent().build();
    }
}