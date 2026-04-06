package com.finance.dashboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @Column(unique = true)
        private String email;

        private String password;

        @Enumerated(EnumType.STRING)
        private Role role;

        @Enumerated(EnumType.STRING)
        private Status status;

        private LocalDateTime createdAt = LocalDateTime.now();
    }

