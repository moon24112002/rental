package com.rental.auth.service;

import com.rental.auth.entity.OtpVerification;
import com.rental.auth.repository.OtpRepository;
import com.rental.auth.util.OtpGenerator;
import com.rental.user.entity.User;
import com.rental.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AuthService {
    private final OtpRepository otpRepository;
    private final WhatsappService whatsappService;
    private final UserRepository userRepository;

    public AuthService(OtpRepository otpRepository, WhatsappService whatsappService, UserRepository userRepository) {
        this.otpRepository = otpRepository;
        this.whatsappService = whatsappService;
        this.userRepository = userRepository;
    }

    @Transactional
    public void sendOtp(String phone){

        String otp = OtpGenerator.generateOtp();

        OtpVerification entity = new OtpVerification();

        entity.setPhone(phone);
        entity.setOtp(otp);
        entity.setExpiryTime(LocalDateTime.now().plusMinutes(5));

        otpRepository.save(entity);

        whatsappService.sendOtp(phone,otp);

    }

    public boolean verifyOtp(String phone, String otp){

        OtpVerification data =
                otpRepository.findTopByPhoneOrderByExpiryTimeDesc(phone)
                        .orElseThrow(() -> new RuntimeException("OTP not found"));

        if(!data.getOtp().equals(otp)){
            throw new RuntimeException("Invalid OTP");
        }

        if(data.getExpiryTime().isBefore(LocalDateTime.now())){
            throw new RuntimeException("OTP expired");
        }

        data.setVerified(true);
        otpRepository.save(data);

        if(!userRepository.findByPhone(phone).isPresent()){
            User user = new User();
            user.setPhone(phone);
            userRepository.save(user);
        }

        return true;
    }

}
