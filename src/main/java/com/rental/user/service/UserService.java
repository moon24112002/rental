package com.rental.user.service;

import com.rental.user.entity.User;
import com.rental.user.entity.UserDetails;
import com.rental.user.repository.UserDetailsRepository;
import com.rental.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    // Fetch user by phone
    public User getUserByPhone(String phone) {
        return userRepository.findByPhone(phone)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Update user by phone
    public User updateUserByPhone(String phone, User updatedUser) {

        User user = userRepository.findByPhone(phone)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setRole(updatedUser.getRole());

        return userRepository.save(user);
    }


}
