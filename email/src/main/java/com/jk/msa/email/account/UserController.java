package com.jk.msa.email.account;

import com.jk.msa.email.account.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  AccountRepository accountRepository;

  @GetMapping
  public String getAllInvolvedUserIds(String userId) {
    return "";
  }
}
