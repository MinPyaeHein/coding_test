package com.example.demo.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.StaffService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	private StaffService staffService;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	@Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("spring")
            .password(passwordEncoder.encode("secret"))
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(staffService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	
	
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
	
	
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests((requests) -> requests
			.antMatchers("/", "/insertStaff").permitAll()
			.anyRequest().authenticated()
		)
		.formLogin((form) -> form
			.loginPage("/login")
			.permitAll()
		)
		.logout((logout) -> logout.permitAll());

	}

}
