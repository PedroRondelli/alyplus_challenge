package com.alyplus_challenge.api.models.user;

import com.alyplus_challenge.api.dto.user.SignUpDTO;
import com.alyplus_challenge.api.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class UserModel {

  @Id private UUID id;

  @Column(unique = true)
  private String email;

  @Column(nullable = false, length = 60)
  private String password_hash;

  @Column(nullable = false, length = 30)
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Role role;

  protected UserModel() {}

  public UserModel(SignUpDTO req) {
    this.id = UUID.randomUUID();
    this.email = req.email();
    this.password_hash = req.password();
    this.name = req.userName();
    this.role = req.role();
  }
}
