package com.learnspring.sms.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity(debug = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
			.withUser("dev1")
			.password("dev1")
			.roles("USER")
			.and()
			.withUser("admin1")
			.password("admin1")
			.roles("ADMIN");
	}

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// least restrictive is mentioned first
		http.authorizeRequests()
			.antMatchers("/api/v1/security/admin/**").hasRole("ADMIN")
			.antMatchers("/api/v1/security/user/**").hasAnyRole("USER", "ADMIN")
			.antMatchers("/api/v1/**").permitAll()
			.and()
			.httpBasic();
	}
}