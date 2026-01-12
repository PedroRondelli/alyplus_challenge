package com.alyplus_challenge.api.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SignInDTO(
    @NotBlank(message = "Email is required") @Email(message = "Check email format") String email,
    @NotBlank(message = "Password is required") String password) {}
