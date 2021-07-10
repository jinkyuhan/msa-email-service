package com.jk.msa.email.account.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.jk.msa.email.account.entity.Account;
import com.jk.msa.email.account.repository.AccountRepository;
import com.jk.msa.email.common.utils.RandomUtils;
import com.jk.msa.email.config.ServiceConfig;
import com.jk.msa.email.mail.dto.SendMailDto;

import com.jk.msa.email.mail.service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountAuthService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ServiceConfig serviceConfig;

    @Autowired
    private MailSendService mailSendService;

    @Transactional
    public void prepareAndSendAuthentication(Account account) {
        account.setAuthenticationCode(RandomUtils.getRandomString(serviceConfig.getAuthCodeLength()));
        account.setAuthenticationCodeExpiredTime(
                LocalDateTime.now().plus(serviceConfig.getAuthCodeTTLMinutes(), ChronoUnit.MINUTES));
        accountRepository.save(account);
        String title = "[" + serviceConfig.getServiceName() + "] 서비스 본인인증 확인용 메일입니다.";
        String body = "인증 확인 창에서 " + account.getAuthenticationCode() + "를 입력해주세요.";
        // 인증 메일은 DB에 저장 안함
        mailSendService.sendMailWithoutSave(new SendMailDto(title, body, new String[]{account.getUserId()}));
    }
}
