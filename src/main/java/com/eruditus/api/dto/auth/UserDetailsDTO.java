package com.eruditus.api.dto.auth;

import java.util.UUID;

import com.eruditus.api.model.User;
import com.eruditus.api.model.UserRole;

public record UserDetailsDTO(UUID id, String username, String role) {
	public UserDetailsDTO(User user) {
		this(user.getId(), user.getUsername(), user.getRole().toString());
	}
}
