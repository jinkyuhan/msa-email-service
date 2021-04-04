package com.jk.msa.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class EmailApplication {

  public static void main(String[] args) {
    SpringApplication.run(EmailApplication.class, args);
  }
}
