package com.alyplus_challenge.api.controller.user;

import com.alyplus_challenge.api.dto.user.SignInDTO;
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
@RequestMapping("user/signin")
public class SignIn {

  @Autowired private UserService userService;

  @PostMapping
  public ResponseEntity<String> signInUser(@RequestBody @Valid SignInDTO req) {
    try {

      String result = userService.signInUser(req);
      return ResponseEntity.status(HttpStatus.CREATED).body(result);
    } catch (Exception e) {

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Error signing in user" + e.getMessage());
    }
  }
}
