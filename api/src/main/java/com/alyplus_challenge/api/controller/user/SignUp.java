package com.alyplus_challenge.api.controller.user;

import com.alyplus_challenge.api.dto.user.SignUpDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/signup")
public class SignUp {
  @PostMapping
  public void registerUser(@RequestBody @Valid SignUpDTO req) {
    System.out.println("User registered: " + req);
  }
}
