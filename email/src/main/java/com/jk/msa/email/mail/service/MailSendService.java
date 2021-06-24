package com.jk.msa.email.mail.service;

import com.jk.msa.email.account.repository.AccountRepository;
import com.jk.msa.email.mail.MailLauncher;
import com.jk.msa.email.mail.repository.MailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailSendService {

	@Autowired(required = true)
	private MailRepository mailRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private MailLauncher mailLauncher;

}