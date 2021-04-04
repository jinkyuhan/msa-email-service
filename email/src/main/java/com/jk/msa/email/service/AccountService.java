package com.jk.msa.email.service;

import java.util.List;

import com.jk.msa.email.entity.Account;
import com.jk.msa.email.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  public Account[] getAllAccounts() {
    List<Account> accounts = accountRepository.findAll();
    return accounts.toArray(new Account[accounts.size()]);
  }

  public Account[] getAccountsByUid(String uid) {
    List<Account> accounts = accountRepository.findAllByUid(uid);
    return accounts.toArray(new Account[accounts.size()]);
  }

  public Account getAccountByEmailAddress(String emailAddress) {
    Account account = accountRepository.findByMailAddress(emailAddress);
    return account;
  }
}
