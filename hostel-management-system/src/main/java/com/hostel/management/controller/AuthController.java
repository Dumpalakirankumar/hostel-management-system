package com.hostel.management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hostel.management.dto.request.LoginRequestDTO;
import com.hostel.management.dto.response.LoginResponseDTO;
import com.hostel.management.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(
            AuthService authService) {

        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO>
    login(@RequestBody LoginRequestDTO requestDTO) {

        return ResponseEntity.ok(
                authService.login(requestDTO));
    }
}