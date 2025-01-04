package com.springsecurity.basic_auth.security;

import com.springsecurity.basic_auth.model.Role;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security, HandlerMappingIntrospector introspector) throws Exception {

        //h2 databese consoluna erişmek için ayarlama
        MvcRequestMatcher.Builder mvcRequestBuilder = new MvcRequestMatcher.Builder(introspector);

        security
                .headers(x -> x.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .csrf(csrfConfig -> csrfConfig.ignoringRequestMatchers(mvcRequestBuilder.pattern("/public/**")
                ).ignoringRequestMatchers(PathRequest.toH2Console()))
                .authorizeHttpRequests(x ->
                        x
                                .requestMatchers(mvcRequestBuilder.pattern("/public/**")).permitAll()
                                .requestMatchers(mvcRequestBuilder.pattern("/private/admin/**")).hasRole("ADMIN")
                                .requestMatchers(mvcRequestBuilder.pattern("/private/**")).hasAnyRole(Role.ROLE_ADMIN.getValue(),Role.ROLE_USER.getValue(),Role.ROLE_MODE.getValue())
                                .requestMatchers(PathRequest.toH2Console()).hasRole("ADMIN")
                                .anyRequest().authenticated())

                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());

        return security.build();
    }
}
