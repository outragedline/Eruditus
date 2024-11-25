package com.eruditus.api.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.eruditus.api.model.User;

@Service
public class TokenService {
	@Value("${api.security.token.secret}")
	private String secret;

	private String issuer;

	public TokenService() {
		this.issuer = "eruditus-auth";
	}

	public String generateToken(User user) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create()
					.withIssuer(issuer)
					.withSubject(user.getUsername())
					.withExpiresAt(genExpirationDate())
					.sign(algorithm);
			return token;
		} catch (Exception e) {
			throw new RuntimeException("Error while generating token", e);
		}
	}

	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm)
					.withIssuer(issuer)
					.build()
					.verify(token)
					.getSubject();

		} catch (Exception e) {
			throw new RuntimeException("Error while validating token", e);
		}
	}

	private Instant genExpirationDate() {
		return LocalDateTime.now().plusHours(4).toInstant(ZoneOffset.of("-03:00"));
	}
}
