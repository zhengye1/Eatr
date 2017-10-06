package com.vincent.eatr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vincent.eatr.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
