package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.User;
import com.udacity.jdnd.course3.critter.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        this.userRepository.save(user);
    }

}
