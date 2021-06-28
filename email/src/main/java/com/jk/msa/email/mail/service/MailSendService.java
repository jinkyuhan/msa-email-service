package com.jk.msa.email.mail.service;

import java.util.List;

import com.jk.msa.email.account.entity.Account;
import com.jk.msa.email.account.repository.AccountRepository;
import com.jk.msa.email.mail.MailLauncher;
import com.jk.msa.email.mail.dto.SendMailDto;
import com.jk.msa.email.mail.entity.Mail;
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

  public void sendMails(SendMailDto mailDto) {
    List<Account> receiverAccounts = accountRepository.findByUserIdIn(mailDto.getReceiverUserIds());

    Mail mailToSend = new Mail(mailDto.getContent());

  }

  publc

}