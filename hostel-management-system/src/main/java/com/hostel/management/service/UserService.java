package com.hostel.management.service;

import com.hostel.management.dto.request.UserRequestDTO;
import com.hostel.management.dto.response.UserResponseDTO;

public interface UserService {

    UserResponseDTO createUser(
            UserRequestDTO requestDTO);
}
