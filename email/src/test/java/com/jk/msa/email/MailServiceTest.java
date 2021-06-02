package com.jk.msa.email;

import com.jk.msa.email.mail.MailContent;
import com.jk.msa.email.mail.MailService;
import com.jk.msa.email.mail.dto.SendMailDto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailServiceTest {

  @Autowired
  private MailService mailService;

  @Test
  public void mailSendingTest() {
    String[] userIdToSendMail = { "user" };
    int result = mailService.sendMail(new SendMailDto(new MailContent("title", "body"), userIdToSendMail));

  }

}
