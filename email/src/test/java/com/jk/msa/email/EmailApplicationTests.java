package com.jk.msa.email;

import com.jk.msa.email.account.AccountController;
import com.jk.msa.email.config.ServiceConfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailApplicationTests {

	@Autowired
	ServiceConfig serviceConfig;

	@Autowired
	AccountController accountController;

	@Test
	void contextLoads() {
	}

	@Test
	void configLoadsTest() {
		System.out.println("service config loads...");
		System.out.println("service.name: " + serviceConfig.getServiceName());
		System.out.println("tableName config loads ..."); 
		System.out.println("service.tableName.account: " + serviceConfig.getAccountTableName());
		System.out.println("service.tableName.mail: " + serviceConfig.getMailTableName());
		System.out.println("mail config loads ..."); 
		System.out.println("service.mail.senderAddress: " + serviceConfig.getSenderAddress());
		System.out.println("service.mail.authCode.ttl: " + serviceConfig.getAuthCodeTTLMinutes());
		System.out.println("service.mail.authCode.length: " + serviceConfig.getAuthCodeLength());
	}

}
