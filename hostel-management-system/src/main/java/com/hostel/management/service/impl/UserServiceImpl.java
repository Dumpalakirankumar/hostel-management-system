package com.hostel.management.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hostel.management.dto.request.UserRequestDTO;
import com.hostel.management.dto.response.UserResponseDTO;
import com.hostel.management.entity.User;
import com.hostel.management.exception.DuplicateRecordException;
import com.hostel.management.repository.RoleRepository;
import com.hostel.management.repository.UserRepository;
import com.hostel.management.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO requestDTO) {

        if(userRepository.existsByUsername(
                requestDTO.getUsername())) {

            throw new DuplicateRecordException(
                    "Username already exists");
        }

        if(userRepository.existsByEmail(
                requestDTO.getEmail())) {

            throw new DuplicateRecordException(
                    "Email already exists");
        }

        if(userRepository.existsByMobileNumber(
                requestDTO.getMobileNumber())) {

            throw new DuplicateRecordException(
                    "Mobile number already exists");
        }

        User user = new User();

        user.setUsername(requestDTO.getUsername());
        user.setEmail(requestDTO.getEmail());
        user.setMobileNumber(requestDTO.getMobileNumber());

        user.setPassword(
                passwordEncoder.encode(
                        requestDTO.getPassword()));

        User savedUser = userRepository.save(user);

        return new UserResponseDTO(
                savedUser.getUserId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getMobileNumber(),
                null
        );
    }
}