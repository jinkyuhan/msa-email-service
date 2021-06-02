package com.jk.msa.email.account;

import java.util.List;

import com.jk.msa.email.account.repository.AccountRepository;
import com.jk.msa.email.account.repository.ProjectionUserIdOnly;

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
  public List<ProjectionUserIdOnly> getAllInvolvedUserIds(String userId) {
    List<ProjectionUserIdOnly> userIds = accountRepository.findBy(ProjectionUserIdOnly.class);
    return userIds;
  }
}
