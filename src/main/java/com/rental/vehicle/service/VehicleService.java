package com.rental.vehicle.service;

import com.rental.vehicle.entity.Vehicle;
import com.rental.vehicle.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class VehicleService
{

    private final VehicleRepository vehicleRepository;

    public Vehicle registerVehicle(Vehicle vehicle) {
        vehicle.setCreatedAt(LocalDateTime.now());
        return vehicleRepository.save(vehicle);
    }
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }
}
