package com.jk.msa.email.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TableNameConfig {

  @Value("${table.mail.name}")
  public static String mailTable;

  @Value("${table.account.name}")
  public static String accountTable;
}