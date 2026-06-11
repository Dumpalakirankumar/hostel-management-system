package com.hostel.management.service;

import com.hostel.management.dto.request.LoginRequestDTO;
import com.hostel.management.dto.request.RegisterRequestDTO;
import com.hostel.management.dto.response.LoginResponseDTO;

public interface AuthService {

    String register(
            RegisterRequestDTO requestDTO);

    LoginResponseDTO login(
            LoginRequestDTO requestDTO);
}