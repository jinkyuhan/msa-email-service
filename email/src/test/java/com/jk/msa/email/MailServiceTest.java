package com.jk.msa.email;

import com.jk.msa.email.common.exception.ByServerException;
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
		try {
			mailService.sendAuthenticationMail("hjg0911@naver.com");
		} catch (ByServerException exception) {
			System.
		}
  }
}
