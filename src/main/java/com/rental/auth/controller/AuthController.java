package com.rental.auth.controller;

import com.rental.auth.dto.VerifyOtpRequest;
import com.rental.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/send-otp")
    public String sendOtp(@RequestParam String phone){
        authService.sendOtp(phone);
        return "OTP sent successfully";
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestBody VerifyOtpRequest request){

        boolean verified =
                authService.verifyOtp(request.getPhone(), request.getOtp());

        if(verified){
            return "OTP verified successfully";
        }

        return "OTP verification failed";
    }

}