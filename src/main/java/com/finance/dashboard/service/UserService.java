package com.finance.dashboard.service;

import com.finance.dashboard.entity.Status;
import com.finance.dashboard.entity.User;
import com.finance.dashboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    public User createUser(User user) {
//        user.setStatus(Status.ACTIVE);
//        return userRepository.save(user);
//    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Autowired
    private PasswordEncoder encoder;

    public User createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatus(Status.ACTIVE);
        return userRepository.save(user);
    }
}
