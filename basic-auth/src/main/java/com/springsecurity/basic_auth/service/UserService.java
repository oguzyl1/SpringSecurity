package com.springsecurity.basic_auth.service;


import com.springsecurity.basic_auth.config.PasswordEncoderConfig;
import com.springsecurity.basic_auth.dto.CreateUserRequest;
import com.springsecurity.basic_auth.model.User;
import com.springsecurity.basic_auth.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoderConfig passwordEncoderConfig;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoderConfig passwordEncoderConfig, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoderConfig = passwordEncoderConfig;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> getByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    public User createUser(CreateUserRequest request) {
        User newUser = User.builder()
                .name(request.name())
                .username(request.userName())
                .password(passwordEncoder.encode(request.password()))
                .authorities(request.authorities())
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .build();

        return userRepository.save(newUser);
    }


}
