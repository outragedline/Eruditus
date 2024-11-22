package com.eruditus.api.model;

public enum UserRole {
	ADMIN("admin"),
	USER("user");

	public String getRole() {
		return role;
	}

	private String role;

	UserRole(String role){
		this.role = role;
	}
}
