package com.vincent.eatr.service;

import java.util.List;
import com.vincent.eatr.model.Authority;

public interface AuthorityService {
  List<Authority> findById(Long id);

  List<Authority> findByname(String name);

}
