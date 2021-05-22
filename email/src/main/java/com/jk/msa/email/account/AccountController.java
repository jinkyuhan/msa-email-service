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
  public List<Account> getAllAccountsOfUid(String uid) {
    List<Account> accountsOfUid = accountRepository.findAllByUid(uid);
    return accountsOfUid;
  }

}