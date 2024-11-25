package com.eruditus.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eruditus.api.dto.auth.LoginDTO;
import com.eruditus.api.dto.auth.LoginResponseDTO;
import com.eruditus.api.dto.auth.SignUpDTO;
import com.eruditus.api.model.User;

import jakarta.validation.Valid;
import com.eruditus.api.service.AuthService;
import com.eruditus.api.service.TokenService;;

@RestController
@RequestMapping("auth")
public class AuthController {
	@Autowired
	private TokenService tokenService;
	@Autowired
	private AuthService authService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginDTO data) {
		Authentication auth = this.authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(data.username(), data.password()));

		String token = tokenService.generateToken((User) auth.getPrincipal());

		return ResponseEntity.ok(new LoginResponseDTO(token));
	}

	@PostMapping("signup")
	public ResponseEntity<?> signUp(@Valid @RequestBody SignUpDTO data) throws Exception {
		// Gambiarra moment
		Map<String, String> responseBody = new HashMap<>();
		try {
			authService.signUp(data);
		} catch (RuntimeException e) {
			responseBody.put("message", e.getMessage());

			return new ResponseEntity<>(responseBody, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
