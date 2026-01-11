package com.alyplus_challenge.api.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class UserModel {

  @Id 
  private UUID id;

  @Column(unique = true)
  private String email;

  @Column(nullable = false, length = 50)
  private String password;

  @Column(nullable = false,length = 30)
  private String userName;
}
