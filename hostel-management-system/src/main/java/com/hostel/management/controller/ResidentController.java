package com.hostel.management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hostel.management.dto.request.ResidentRequestDTO;
import com.hostel.management.dto.response.ResidentResponseDTO;
import com.hostel.management.service.ResidentService;

@RestController
@RequestMapping("/api/residents")
public class ResidentController {

    private final ResidentService residentService;

    public ResidentController(
            ResidentService residentService) {

        this.residentService = residentService;
    }

    @PostMapping
    public ResponseEntity<ResidentResponseDTO>
    createResident(
            @RequestBody ResidentRequestDTO requestDTO) {

        return ResponseEntity.ok(
                residentService.createResident(
                        requestDTO));
    }

    @GetMapping
    public ResponseEntity<List<ResidentResponseDTO>>
    getAllResidents() {

        return ResponseEntity.ok(
                residentService.getAllResidents());
    }
}