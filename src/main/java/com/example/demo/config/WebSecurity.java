package com.example.demo.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
public class WebSecurity{
	@Autowired
	private StaffService staffService;
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
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
	  @Bean
	    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
	         http
	        .cors().and()
	        .csrf().disable().authorizeHttpRequests()
	        .antMatchers("/login").permitAll()
	        .antMatchers("/staffManagement").permitAll()
	        .antMatchers("/departmentManagement").hasAuthority("dept_manage")
	        .antMatchers("/groupManagement").hasAuthority("group_manage")
	        .antMatchers("/pageManagement").hasAuthority("page_manage")
	        .antMatchers("/loanManagement").hasAuthority("loan_manage")
	        .anyRequest().authenticated()
	        .and()
	        .formLogin();
	         return http.build();
	    }
	 
	
	/*@Bean
	    public InMemoryUserDetailsManager userDetailsService() {
	        UserDetails user1 = User.withUsername("defaultUser")
	            .password(passwordEncoder().encode("user1Pass"))
	            .roles("staff_manage")
	            .build();
	   
	        return new InMemoryUserDetailsManager(user1);
	    }*/
	 
	

}
