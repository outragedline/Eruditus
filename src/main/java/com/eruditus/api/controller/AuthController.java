package com.eruditus.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eruditus.api.dto.auth.SignUpDTO;

import jakarta.validation.Valid;
import com.eruditus.api.service.AuthService;;

@RestController
@RequestMapping("auth")
public class AuthController {
	@Autowired
	AuthService authService;

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

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
