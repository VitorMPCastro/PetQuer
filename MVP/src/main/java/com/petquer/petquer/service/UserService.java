package com.petquer.petquer.service;

import com.petquer.petquer.entity.Company;
import com.petquer.petquer.entity.Individual;
import com.petquer.petquer.entity.User;
import com.petquer.petquer.repository.CompanyRepository;
import com.petquer.petquer.repository.IndividualRepository;
import com.petquer.petquer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private IndividualRepository individualRepository;

    @Transactional
    public User createUserWithDetails(User user, Individual individual, Company company) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        User savedUser = userRepository.save(user);

        if (individual != null) {
            individual.setUser(savedUser);
            individualRepository.save(individual);
        }

        if (company != null) {
            company.setUser(savedUser);
            companyRepository.save(company);
        }

        return savedUser;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            // Update other fields as necessary
            userRepository.save(existingUser);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}