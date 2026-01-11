package com.alyplus_challenge.api.dto.user;

import com.alyplus_challenge.api.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SignUpDTO(
    @NotBlank(message = "Password is required") String password,
    @NotBlank(message = "Email is required") @Email(message = "Verify email format") String email,
    @NotBlank(message = "Username is required") String userName,
    Role role) {}
