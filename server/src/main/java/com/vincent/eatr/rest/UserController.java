package com.vincent.eatr.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.vincent.eatr.exception.ResourceConflictException;
import com.vincent.eatr.model.Authority;
import com.vincent.eatr.model.User;
import com.vincent.eatr.service.AuthorityService;
import com.vincent.eatr.service.UserService;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

  private static Logger LOGGER = Logger.getLogger(UserController.class);

  @Autowired
  private UserService userService;

  @Autowired
  private AuthorityService authService;

  @RequestMapping(method = GET, value = "/user/{userId}")
  public User loadById(@PathVariable Long userId) {
    return this.userService.findById(userId);
  }

  @RequestMapping(method = GET, value = "/user/all")
  public List<User> loadAll() {
    return this.userService.findAll();
  }

  @RequestMapping(method = GET, value = "/user/reset-credentials")
  public ResponseEntity<Map> resetCredentials() {
    this.userService.resetCredentials();
    Map<String, String> result = new HashMap<>();
    result.put("result", "success");
    return ResponseEntity.accepted().body(result);
  }

  @RequestMapping(method = POST, value = "/signup")
  public ResponseEntity<?> addUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {

    User existUser = this.userService.findByUsername(user.getUsername());
    if (existUser != null) {
      throw new ResourceConflictException(user.getId(), "Username already exists");
    }
    List<Authority> auths = this.authService.findByname("ROLE_USER"); // this.authService.findById(2L);

    user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
    user.setAuthorities(auths);
    LOGGER.info("Saving user" + user);
    this.userService.save(user);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(user.getId()).toUri());
    return new ResponseEntity<User>(user, HttpStatus.CREATED);
  }


  /*
   * We are not using userService.findByUsername here(we could), so it is good that we are making
   * sure that the user has role "ROLE_USER" to access this endpoint.
   */
  @RequestMapping("/whoami")
  @PreAuthorize("hasRole('USER')")
  public User user() {
    return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }

}
