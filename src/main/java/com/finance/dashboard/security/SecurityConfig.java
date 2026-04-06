package com.finance.dashboard.security;

//package com.finance.dashboard.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                                // ALLOW anyone to POST to /users to create their first account
//                                .requestMatchers(HttpMethod.POST, "/users/**").permitAll()

                                // Keep the rest of the user management for ADMIN only
//                                .requestMatchers(HttpMethod.GET, "/users/**").hasRole("ADMIN")
                                .requestMatchers( "/users/**").hasRole("ADMIN")
                                .requestMatchers("/records/**").authenticated()
                                .anyRequest().permitAll()
//                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()); // simple auth (username/password)

        return http.build();
    }
}
