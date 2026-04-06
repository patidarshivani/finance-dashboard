package com.finance.dashboard.controller;

import com.finance.dashboard.entity.User;
import com.finance.dashboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(service.createUser(user));
    }




//    @PostMapping
//    public ResponseEntity<User> create(@RequestBody User user) {
//        return ResponseEntity.ok(service.createUser(user));
//    }

    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }
}
