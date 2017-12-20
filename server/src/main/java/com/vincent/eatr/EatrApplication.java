package com.vincent.eatr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author Vincent Zheng
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.vincent.eatr")
@EnableJpaRepositories(basePackages = "com.vincent.eatr.repository")
@EntityScan(basePackages = "com.vincent.eatr.model")
public class EatrApplication {

  public static void main(String[] args) {
    SpringApplication.run(EatrApplication.class, args);
  }
}
