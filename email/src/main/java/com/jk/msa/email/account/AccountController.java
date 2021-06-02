package com.jk.msa.email.account;

import java.util.ArrayList;
import java.util.List;

import com.jk.msa.email.account.entity.Account;
import com.jk.msa.email.account.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

  @Autowired
  AccountRepository accountRepository;

  @GetMapping
<<<<<<< HEAD
  public List<Account> getAllAccountsOfUser(String userId) {
    List<Account> accountsOfUser = accountRepository.findAll();
=======
  public List<Account> getAccountsOfUser(String userId) {
    List<Account> accountsOfUser = accountRepository.findAllByUserId(userId).orElse(new ArrayList<Account>());
>>>>>>> b6392a8f459b5f1778a26f5f31822f0486a20d27
    return accountsOfUser;
  }
}