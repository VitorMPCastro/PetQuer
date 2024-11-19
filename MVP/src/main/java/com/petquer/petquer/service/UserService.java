package com.petquer.petquer.service;

import com.petquer.petquer.dto.UserRegistrationDTO;
import com.petquer.petquer.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    public User registerUser(UserRegistrationDTO userDto) {
        // Mock saving a user
        User user = new User();
        user.setId(1L); // Mocked ID
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setCreatedAt(LocalDateTime.now());

        // Simulate successful user creation
        return user;
    }
}
