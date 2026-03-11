package com.rental.auth.repository;

import com.rental.auth.entity.OtpVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpRepository extends JpaRepository<OtpVerification,String> {
    Optional<OtpVerification> findTopByPhoneOrderByExpiryTimeDesc(String phone);
}