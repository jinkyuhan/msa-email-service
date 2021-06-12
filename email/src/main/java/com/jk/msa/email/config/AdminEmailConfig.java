package com.jk.msa.email.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "spring.mail")
@Getter
@Setter
public class AdminEmailConfig {
	private String username;
	private String password;
	private String authEmailSender;
}
