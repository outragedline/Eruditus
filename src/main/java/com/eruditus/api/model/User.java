package com.eruditus.api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@NotBlank
	@Column(unique = true)
	private String username;

	@NotBlank
	private String password;

	@NotNull
	private UserRole role;

	@CreationTimestamp
	private LocalDateTime created_at;

	@UpdateTimestamp
	private LocalDateTime updated_at;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		switch (this.role) {
			case UserRole.ADMIN:
				authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			case UserRole.USER:
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
				break;
			default:
				break;
		}
		return authorities;
	}
}
