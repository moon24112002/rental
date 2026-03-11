package com.rental.user.service;

import com.rental.user.entity.UserDetails;
import com.rental.user.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class UserDetailsService {
    private final UserDetailsRepository userDetailsRepository;
    // fetch by phone
    @Transactional(readOnly = true)
    public UserDetails getByPhone(String phone) {

        return userDetailsRepository.findByPhone(phone)
                .orElseThrow(() -> new RuntimeException("UserDetails not found"));
    }

    public UserDetails updateByPhone(String phone,
                                     MultipartFile licenseImage
                                     ) throws IOException {

        UserDetails userDetails = userDetailsRepository
                .findByPhone(phone)
                .orElse(new UserDetails());

        userDetails.setPhone(phone);
        if (licenseImage != null && !licenseImage.isEmpty()) {
            userDetails.setLicenseImage(licenseImage.getBytes());
        }

        return userDetailsRepository.save(userDetails);
    }

}
