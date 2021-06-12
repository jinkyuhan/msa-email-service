package com.jk.msa.email.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "table")
@Getter
@Setter
public class TableNameConfig {
  private String mailTable;
  private String accountTable;
}