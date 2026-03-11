package com.rental.user.controller;

import com.rental.user.entity.UserDetails;
import com.rental.user.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/user-details")
@RequiredArgsConstructor
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    // fetch by phone
    @GetMapping("/phone/{phone}")
    public UserDetails getByPhone(@PathVariable String phone) {
        return userDetailsService.getByPhone(phone);
    }

    // update by phone
    @PutMapping(path = "/phone/{phone}", consumes = "multipart/form-data")
    public UserDetails updateByPhone(
            @PathVariable String phone,
            @RequestParam("licenseImage") MultipartFile licenseImage) throws Exception {

        return userDetailsService.updateByPhone(phone, licenseImage);
    }
}