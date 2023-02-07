package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringWebSecurityConfic {
	 @Bean
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		    http.csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/admin/**")
            .hasRole("ADMIN")
            .antMatchers("/anonymous*")
            .anonymous()
            .antMatchers("/login*")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and();
		      return http.build();
	    }
}
