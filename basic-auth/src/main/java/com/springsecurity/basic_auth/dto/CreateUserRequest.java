package com.springsecurity.basic_auth.dto;

import com.springsecurity.basic_auth.model.Role;
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
