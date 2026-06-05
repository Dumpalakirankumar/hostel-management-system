package com.hostel.management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hostel.management.dto.request.BedRequestDTO;
import com.hostel.management.dto.response.BedResponseDTO;
import com.hostel.management.service.BedService;

@RestController
@RequestMapping("/api/beds")
public class BedController {

    private final BedService bedService;

    public BedController(
            BedService bedService) {

        this.bedService = bedService;
    }

    @PostMapping
    public ResponseEntity<BedResponseDTO>
    createBed(
            @RequestBody BedRequestDTO requestDTO) {

        return ResponseEntity.ok(
                bedService.createBed(requestDTO));
    }

    @GetMapping
    public ResponseEntity<List<BedResponseDTO>>
    getAllBeds() {

        return ResponseEntity.ok(
                bedService.getAllBeds());
    }
}