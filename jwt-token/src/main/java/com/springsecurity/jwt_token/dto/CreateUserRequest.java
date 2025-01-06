package com.springsecurity.jwt_token.dto;

import com.springsecurity.jwt_token.model.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public record CreateUserRequest(
        String name,
        String userName,
        String password,
        Set<Role> authorities
) {

}
