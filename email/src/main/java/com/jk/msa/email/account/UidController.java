package com.jk.msa.email.account;

import javax.websocket.server.PathParam;

import com.jk.msa.email.mail.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/uid")
public class UidController {

  @Autowired
  private AccountService accountService;

  @GetMapping(value = "/{uid}/mail")
  public Mail[] getMailsOfUid() {
    return new Mail[5];
  }

  @GetMapping(value = "/{uid}/account")
  public Account[] getAccountsOfUid(@PathParam(value = "uid") String uid) {
    Account[] accounts = accountService.getAccountsByUid(uid);
    return accounts;
  }

  @PostMapping(value = "/{uid}/account")
  public boolean registerNewAccount() {

    return true;
  }

  @DeleteMapping(value = "/{uid}/account")
  public int deleteAllAccountOfUid() {
    return 0;
  }
}
