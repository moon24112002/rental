package com.rental.vehicle.entity;

import com.rental.config.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "vehicles")
public class Vehicle  extends BaseEntity {

    private String brand;

    private String model;

    private String fuelType;

    private String transmission;

    private int seatingCapacity;

    private double pricePerDay;

    private String status;

    private LocalDateTime createdAt;
}