package com.hostel.management.service;

import com.hostel.management.dto.request.LoginRequestDTO;
import com.hostel.management.dto.response.LoginResponseDTO;

public interface AuthService {

    LoginResponseDTO login(
            LoginRequestDTO requestDTO);
}