package com.petquer.petquer.controllers;

import com.petquer.petquer.dto.UserRegistrationDTO;
import com.petquer.petquer.entity.User;
import com.petquer.petquer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationDTO userDto) {
        // Call the service layer to handle registration
        User user = userService.registerUser(userDto);

        // Return the created user with a 201 status code
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}

