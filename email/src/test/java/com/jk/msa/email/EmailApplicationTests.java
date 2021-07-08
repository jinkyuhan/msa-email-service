package com.jk.msa.email;

import com.jk.msa.email.account.AccountController;
import com.jk.msa.email.account.dto.AuthPrepareDto;
import com.jk.msa.email.account.dto.AuthValidateDto;
import com.jk.msa.email.common.ApiResult;
import com.jk.msa.email.config.ServiceConfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        System.out.println("[ tableName configs ]");
        System.out.println("service.tableName.account: " + serviceConfig.getAccountTableName());
        System.out.println("service.tableName.mail: " + serviceConfig.getMailTableName());
        System.out.println("[ mail config loads ]");
        System.out.println("service.mail.senderAddress: " + serviceConfig.getSenderAddress());
        System.out.println("service.mail.authCode.ttl: " + serviceConfig.getAuthCodeTTLMinutes());
        System.out.println("service.mail.authCode.length: " + serviceConfig.getAuthCodeLength());
    }

    @Test
    void addAccountTest() {
        AuthPrepareDto requestBody = new AuthPrepareDto();
        requestBody.setUserId("0000-0000-000000");
        requestBody.setEmailAddress("gkswlsrb95@gmail.com");
        assertEquals(
                accountController.prepareAccountAuthentication(requestBody).getResultCode(),
                ApiResult.SUCCESS.getResultCode()
        );
    }

    @Test
    void validateTest() {
        AuthValidateDto requestBody = new AuthValidateDto();
        requestBody.setEmailAddress("gkswlsrb95@gmail.com");
        requestBody.setUserId("0000-0000-000000");
        requestBody.setAuthCode("Axt0a1");
        assertEquals(
                accountController.validateAccountAuthentication(requestBody).getResultCode(),
                ApiResult.SUCCESS.getResultCode()
        );
    }
}
