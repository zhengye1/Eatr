package com.vincent.eatr.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vincent.eatr.model.User;
import com.vincent.eatr.service.UserService;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

  @Autowired
  private UserService userService;

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
