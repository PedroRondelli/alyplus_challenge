package com.alyplus_challenge.api.services;

import com.alyplus_challenge.api.dto.user.SignUpDTO;
import com.alyplus_challenge.api.models.user.UserModel;
import com.alyplus_challenge.api.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired private PasswordEncoder passwordEncoder;

  public String encode(String password) {
    return passwordEncoder.encode(password);
  }

  @Autowired private UserRepository userRepository;

  public String createUser(SignUpDTO dto) {

    String encryptedPassword = passwordEncoder.encode(dto.password());

    UserModel user = new UserModel(dto);
    user.setPassword_hash(encryptedPassword);
    UserModel saved = userRepository.save(user);
    return "Created user: " + saved.getId();
  }
}
