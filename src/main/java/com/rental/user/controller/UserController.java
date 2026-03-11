package com.rental.user.controller;

import com.rental.user.entity.User;
import com.rental.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Get user by phone
    @GetMapping("/phone/{phone}")
    public User getUserByPhone(@PathVariable String phone) {
        return userService.getUserByPhone(phone);
    }

    // Update user by phone
    @PutMapping("/phone/{phone}")
    public User updateUserByPhone(@PathVariable String phone,
                                  @RequestBody User user) {
        return userService.updateUserByPhone(phone, user);
    }
}