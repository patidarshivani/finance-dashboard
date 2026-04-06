package com.finance.dashboard.controller;

import com.finance.dashboard.entity.Status;
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


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @RequestBody User user
    ) {
        return ResponseEntity.ok(service.updateUser(id, user));
    }


    @PatchMapping("/{id}/status")
    public ResponseEntity<User> updateStatus(
            @PathVariable Long id,
            @RequestParam Status status
    ) {
        User user = service.updateStatus(id, status);
        return ResponseEntity.ok(user);
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
