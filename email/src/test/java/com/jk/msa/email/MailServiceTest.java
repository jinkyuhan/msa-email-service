package com.jk.msa.email;

import com.jk.msa.email.mail.MailService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailServiceTest {

  @Autowired
  private MailService mailService;

  @Test
  public void mailSendingTest() {
    // String[] receiverIds = { "user" };
    // String[] co
    // int result = mailService.sendMail(new SendMailDto(new MailContent("title", "body"), userIdToSendMail, )fhh;
    // assertNotNull(result);
  }
}
