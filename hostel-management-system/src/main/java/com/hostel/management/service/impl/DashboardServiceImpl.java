package com.hostel.management.service.impl;

import org.springframework.stereotype.Service;

import com.hostel.management.dto.response.DashboardResponseDTO;
import com.hostel.management.repository.BedRepository;
import com.hostel.management.repository.HostelRepository;
import com.hostel.management.repository.PaymentRepository;
import com.hostel.management.repository.ResidentRepository;
import com.hostel.management.repository.RoomRepository;
import com.hostel.management.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final HostelRepository hostelRepository;
    private final RoomRepository roomRepository;
    private final BedRepository bedRepository;
    private final ResidentRepository residentRepository;
    private final PaymentRepository paymentRepository;

    public DashboardServiceImpl(
            HostelRepository hostelRepository,
            RoomRepository roomRepository,
            BedRepository bedRepository,
            ResidentRepository residentRepository,
            PaymentRepository paymentRepository) {

        this.hostelRepository = hostelRepository;
        this.roomRepository = roomRepository;
        this.bedRepository = bedRepository;
        this.residentRepository = residentRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public DashboardResponseDTO getDashboardSummary() {

        return new DashboardResponseDTO(
                hostelRepository.count(),
                roomRepository.count(),
                bedRepository.count(),
                residentRepository.count(),
                paymentRepository.count());
    }
}