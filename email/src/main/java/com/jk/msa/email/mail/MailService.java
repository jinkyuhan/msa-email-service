package com.jk.msa.email.mail;

import com.jk.msa.email.account.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService {

  @Autowired(required = true)
  private MailRepository mailRepository;

  @Autowired
  private AccountRepository accountRepository;

	@Autowired
	private MailLauncher mailLauncher;

}