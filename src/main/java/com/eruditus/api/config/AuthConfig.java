package com.eruditus.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.eruditus.api.model.UserRole;
import com.eruditus.api.model.User;
import com.eruditus.api.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class AuthConfig {
	@Autowired
	SecurityFilter securityFilter;

	@Autowired
	private UserRepository userRepository;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(HttpMethod.POST, "/courses").hasRole(UserRole.ADMIN.name())
						.requestMatchers("/auth/me").authenticated()
						.anyRequest().permitAll())
				.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}

	@Bean
	public CommandLineRunner rootUser() {
		return args -> {
			if (userRepository.findByUsername("root").isEmpty()) {
				User rootUser = new User();
				rootUser.setUsername("root");
				rootUser.setPassword(passwordEncoder().encode("root"));
				rootUser.setRole(UserRole.ADMIN);
				userRepository.save(rootUser);
			}
		};
	}
}
