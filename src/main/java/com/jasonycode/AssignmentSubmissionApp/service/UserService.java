package com.jasonycode.AssignmentSubmissionApp.service;

import com.jasonycode.AssignmentSubmissionApp.entity.User;
import com.jasonycode.AssignmentSubmissionApp.repositiory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
