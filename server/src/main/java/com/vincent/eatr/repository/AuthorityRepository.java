package com.vincent.eatr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vincent.eatr.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
  Authority findByName(String name);
}
