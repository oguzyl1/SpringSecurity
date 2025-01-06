package com.springsecurity.jwt_token.controller;

import com.springsecurity.jwt_token.dto.CreateUserRequest;
import com.springsecurity.jwt_token.model.User;
import com.springsecurity.jwt_token.service.JwtService;
import com.springsecurity.jwt_token.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public UserController(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Security JWT Token";
    }

    @PostMapping("/addNewUser")
    public User addNewUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody CreateUserRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(),request.password()));
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(request.username());
        }
        throw new UsernameNotFoundException("Invalid username:" + request.username());
    }

    @GetMapping("/user")
    public String user() {
        return "This is a user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "This is a admin";
    }



}
