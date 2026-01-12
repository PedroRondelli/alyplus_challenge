package com.alyplus_challenge.api.controller.user;

import com.alyplus_challenge.api.dto.user.SignUpDTO;
import com.alyplus_challenge.api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/signup")
public class SignUp {

  @Autowired private UserService userService;

  @PostMapping
  public ResponseEntity<String> registerUser(@RequestBody @Valid SignUpDTO req) {
    try {

      String result = userService.createUser(req);
      return ResponseEntity.status(HttpStatus.CREATED).body(result);
    } catch (Exception e) {

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user");
    }
  }
}
