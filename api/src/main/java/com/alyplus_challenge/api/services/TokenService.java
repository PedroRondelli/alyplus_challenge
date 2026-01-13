package com.alyplus_challenge.api.services;

import com.alyplus_challenge.api.models.user.UserModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
  @Value("${api.security.token.secret}")
  private String secret;

  public String generateToken(UserModel user) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);

      String token =
          JWT.create()
              .withIssuer("login-auth-api")
              .withSubject(user.getEmail())
              .withClaim("role", user.getRole().toString())
              .withExpiresAt(this.generateExpirationDate())
              .sign(algorithm);
      return token;
    } catch (JWTCreationException exception) {
      throw new RuntimeException("Error while authenticating");
    }
  }

  public String validateToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.require(algorithm).withIssuer("login-auth-api").build().verify(token).getSubject();
    } catch (JWTVerificationException exception) {
      return null;
    }
  }

  public String extractRole(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      String role = JWT.require(algorithm)
              .withIssuer("login-auth-api")
              .build()
              .verify(token)
              .getClaim("role")
              .asString();
              return role;
    } catch (JWTVerificationException exception) {
      return null;
    }
  }

  private Instant generateExpirationDate() {
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
  }
}
