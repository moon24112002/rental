package com.rental.auth.util;

import java.util.Random;

public class OtpGenerator {

    public static String generateOtp(){

        int otp = 100000 + new Random().nextInt(900000);

        return String.valueOf(otp);
    }
}