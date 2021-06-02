package com.jk.msa.email.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:smtp.properties")
public class SMTPConfig {

  @Value("${smtp.account}")
  public static String senderAccount;
}
