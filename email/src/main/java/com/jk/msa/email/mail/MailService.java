package com.jk.msa.email.mail;

import com.jk.msa.email.account.repository.AccountRepository;
import com.jk.msa.email.mail.dto.SendMailDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

  @Autowired(required = true)
  private MailRepository mailRepository;

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private JavaMailSender mailSender;


	// public void sendAuthenticationMail()

  public int sendMail(SendMailDto sendMailDto) {
    // Mail newMail = new Mail();
    // mailSender.send((MimeMessage) newMail.getMailMessage());
    return 1;
  }
}