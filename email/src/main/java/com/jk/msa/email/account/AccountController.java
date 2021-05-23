package com.jk.msa.email.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  @Autowired
  AccountRepository accountRepository;

  @GetMapping
  public List<Account> getAccountsOfUser(String userId) {
    List<Account> accountsOfUser = accountRepository.findAllByUserId(userId).orElse(new ArrayList<Account>());
    return accountsOfUser;
  }
}