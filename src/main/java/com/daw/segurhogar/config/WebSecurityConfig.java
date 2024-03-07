package com.daw.segurhogar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final AuthenticationProvider authProvider;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(
					(authorize) -> authorize
				.requestMatchers("/swagger/**","/swagger-ui/**","/h2-console/**","/signup","/v3/**","/logout","/login").permitAll()
				.anyRequest().authenticated())
			.logout(logout -> logout
					.logoutUrl("/logout")
					.invalidateHttpSession(true)
					.clearAuthentication(true)
					.permitAll())
			.csrf(AbstractHttpConfigurer::disable)
		    .headers(AbstractHttpConfigurer::disable)
		    .sessionManagement(sessionManager-> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		    .authenticationProvider(authProvider)
		    .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.getOrBuild();
	}	

 }
