package com.rental.auth.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class WhatsappService {
    public static final String ACCOUNT_SID = "AC764516658fb577cbf30536d5cb763e03";
    public static final String AUTH_TOKEN = "9fc5935365b2948dcff97c7aeecdf496";

    public void sendOtp(String phone,String otp){

//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//
//        Message.creator(
//                new PhoneNumber("whatsapp:+91"+phone),
//                new PhoneNumber("whatsapp:+14155238886"),
//                "Your login OTP is: " + otp
//        ).create();
    }
}