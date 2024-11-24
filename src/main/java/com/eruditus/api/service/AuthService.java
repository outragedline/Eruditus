package com.eruditus.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eruditus.api.dto.auth.SignUpDTO;
import com.eruditus.api.model.User;
import com.eruditus.api.model.UserRole;
import com.eruditus.api.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthService {
	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public User signUp(SignUpDTO data) {
		if (repository.findByUsername(data.username()).isPresent()) {
			throw new RuntimeException("Tried to create a user that already exists!");
		}

		User user = new User();
		user.setUsername(data.username());
		user.setPassword(passwordEncoder.encode(data.password()));
		user.setRole(UserRole.USER);
		return repository.save(user);
	}
}
