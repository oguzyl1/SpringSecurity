package com.springsecurity.security_demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("private")
public class PrivateController {

    @GetMapping
    public String hello() {
        return "Hello World! from private endpoint";
    }

    // iste bu şekilde istersek de config de tanımlayabiliriz @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String user() {
        return "Hello World! from user private endpoint";
    }


    // iste bu şekilde istersek de config de tanımlayabiliriz @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "Hello World! from admin private endpoint";
    }

}
