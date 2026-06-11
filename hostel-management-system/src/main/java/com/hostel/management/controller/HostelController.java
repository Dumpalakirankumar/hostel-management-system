package com.hostel.management.controller;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hostel.management.dto.request.HostelRequestDTO;
import com.hostel.management.dto.response.HostelResponseDTO;
import com.hostel.management.service.HostelService;

@RestController
@RequestMapping("/api/hostels")
public class HostelController {

    private final HostelService hostelService;

    public HostelController(
            HostelService hostelService) {

        this.hostelService = hostelService;
    }

    @PostMapping
    public ResponseEntity<HostelResponseDTO> createHostel(
            @Valid @RequestBody HostelRequestDTO requestDTO) {

        return ResponseEntity.ok(
                hostelService.createHostel(requestDTO));
    }

    @GetMapping
    public ResponseEntity<List<HostelResponseDTO>>
    getAllHostels() {

        return ResponseEntity.ok(
                hostelService.getAllHostels());
    }
    
    @GetMapping("/paged")
    public ResponseEntity<Page<HostelResponseDTO>>
    getAllHostelsPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(
                hostelService.getAllHostels(
                        page,
                        size));
    }
    @GetMapping("/search")
    public ResponseEntity<List<HostelResponseDTO>>
    getHostelsByCity(
            @RequestParam String city) {

        return ResponseEntity.ok(
                hostelService.getHostelsByCity(city));
    }
    @PutMapping("/{id}")
    public ResponseEntity<HostelResponseDTO> updateHostel(
            @PathVariable Long id,
            @Valid @RequestBody HostelRequestDTO requestDTO) {

        return ResponseEntity.ok(
                hostelService.updateHostel(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHostel(
            @PathVariable Long id) {

        hostelService.deleteHostel(id);

        return ResponseEntity.noContent().build();
    }
}