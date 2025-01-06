package com.springsecurity.jwt_token.dto;

public record AuthRequest(
        String userName,
        String password
) {

}
