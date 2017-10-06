package com.vincent.eatr.service;


import java.util.List;
import com.vincent.eatr.model.User;

public interface UserService {
  void resetCredentials();

  User findById(Long id);

  User findByUsername(String username);

  List<User> findAll();
}
