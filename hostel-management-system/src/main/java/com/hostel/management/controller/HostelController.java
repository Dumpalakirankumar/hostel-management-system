package com.hostel.management.controller;

import java.util.List;

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
    public ResponseEntity<HostelResponseDTO>
    createHostel(
            @RequestBody HostelRequestDTO requestDTO) {

        return ResponseEntity.ok(
                hostelService.createHostel(
                        requestDTO));
    }

    @GetMapping
    public ResponseEntity<List<HostelResponseDTO>>
    getAllHostels() {

        return ResponseEntity.ok(
                hostelService.getAllHostels());
    }
}