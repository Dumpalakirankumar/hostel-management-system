package com.hostel.management.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hostel.management.dto.request.LoginRequestDTO;
import com.hostel.management.dto.request.RegisterRequestDTO;
import com.hostel.management.dto.response.LoginResponseDTO;
import com.hostel.management.entity.User;
import com.hostel.management.exception.BusinessException;
import com.hostel.management.repository.UserRepository;
import com.hostel.management.security.jwt.JwtUtil;
import com.hostel.management.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String register(
            RegisterRequestDTO requestDTO) {

        if (userRepository.findByUsername(
                requestDTO.getUsername()).isPresent()) {

            throw new BusinessException(
                    "Username already exists");
        }

        User user = new User();

        user.setUsername(
                requestDTO.getUsername());

        user.setPassword(
                passwordEncoder.encode(
                        requestDTO.getPassword()));

        user.setEmail(
                requestDTO.getEmail());

        user.setMobileNumber(
                requestDTO.getMobileNumber());

        /*user.setRole(
                requestDTO.getRole());*/

        userRepository.save(user);

        return "User Registered Successfully";
    }

    @Override
    public LoginResponseDTO login(
            LoginRequestDTO requestDTO) {

        User user = userRepository
                .findByUsername(
                        requestDTO.getUsername())
                .orElseThrow(() ->
                        new BusinessException(
                                "Invalid Username"));

        if (!passwordEncoder.matches(
                requestDTO.getPassword(),
                user.getPassword())) {

            throw new BusinessException(
                    "Invalid Password");
        }

        String token =
                jwtUtil.generateToken(
                        user.getUsername());

        return new LoginResponseDTO(token);
    }
}