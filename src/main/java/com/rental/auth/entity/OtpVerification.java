package com.rental.auth.entity;

import com.rental.config.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OtpVerification extends BaseEntity {

    private String phone;

    private String otp;

    private LocalDateTime expiryTime;

    private boolean verified;
}