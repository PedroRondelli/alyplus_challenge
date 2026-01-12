package com.alyplus_challenge.api.repository.user;

import com.alyplus_challenge.api.models.user.UserModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, UUID> {}
