package com.jk.msa.email.account.service;

import com.jk.msa.email.account.repository.AccountRepository;
import com.jk.msa.email.config.ServiceConfig;
import com.jk.msa.email.mail.MailLauncher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountFindService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ServiceConfig serviceConfig;

	@Autowired
	private MailLauncher mailLauncher;

}
