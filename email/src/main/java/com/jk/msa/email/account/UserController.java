package com.jk.msa.email.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/user")
public class UserController {

  @Autowired
  AccountRepository accountRepository;

  @GetMapping
  public List<String> getUserId(String userId) {
    List<String> userIds = accountRepository.findAll()
    return 
  }

}
