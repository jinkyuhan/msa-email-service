package com.jk.msa.email.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  @Autowired
  AccountRepository accountRepository;

  @GetMapping
  public List<Account> getAllAccountsOfUser(String userId) {
    List<Account> accountsOfUser = accountRepository.findAllByUid(userId);
    return accountsOfUser;
  }

}