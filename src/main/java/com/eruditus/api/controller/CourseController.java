package com.eruditus.api.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eruditus.api.dto.auth.LoginDTO;
import com.eruditus.api.dto.auth.LoginResponseDTO;
import com.eruditus.api.dto.auth.SignUpDTO;
import com.eruditus.api.model.Course;
import com.eruditus.api.model.User;

import jakarta.validation.Valid;
import com.eruditus.api.service.AuthService;
import com.eruditus.api.service.TokenService;;

@RestController
@RequestMapping("courses")
public class CourseController {
	@GetMapping("/{id}")
	ResponseEntity<Course> courseDetails(@PathVariable UUID id) {
		Course course =
	}
}
