package com.jk.msa.email.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@Getter
public class ServiceConfig {
	@Value("${service.name}")
	private String serviceName;

	@Value("${service.tableName.account}")
	private String accountTableName;

	@Value("${service.tableName.mail}")
	private String mailTableName;

	@Value("${service.mail.senderAddress}")
	private String senderAddress;

	@Value("${service.mail.authCode.ttl}")
	private int authCodeTTLMinutes;

	@Value("${service.mail.authCode.length}")
	private int authCodeLength;
}
