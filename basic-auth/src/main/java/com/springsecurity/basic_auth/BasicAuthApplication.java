package com.springsecurity.basic_auth;

import com.springsecurity.basic_auth.dto.CreateUserRequest;
import com.springsecurity.basic_auth.model.Role;
import com.springsecurity.basic_auth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner {

	private final UserService userService;

    public BasicAuthApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
		SpringApplication.run(BasicAuthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createDummyData();
	}

	public void createDummyData(){
		CreateUserRequest request = CreateUserRequest.builder()
				.name("oguz")
				.userName("oguz")
				.password("pass")
				.authorities(Set.of(Role.ROLE_ADMIN))
				.build();
		userService.createUser(request);

		CreateUserRequest request2 = CreateUserRequest.builder()
				.name("veli")
				.userName("veli")
				.password("pass")
				.authorities(Set.of(Role.ROLE_USER))
				.build();
		userService.createUser(request2);

		CreateUserRequest request3 = CreateUserRequest.builder()
				.name("ali")
				.userName("ali")
				.password("pass")
				.authorities(Set.of(Role.ROLE_MODE))
				.build();
		userService.createUser(request3);
	}
}
