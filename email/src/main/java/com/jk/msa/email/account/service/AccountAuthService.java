package com.jk.msa.email.account.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.jk.msa.email.account.entity.Account;
import com.jk.msa.email.account.repository.AccountRepository;
import com.jk.msa.email.common.utils.RandomUtils;
import com.jk.msa.email.config.ServiceConfig;
import com.jk.msa.email.mail.Mail;
import com.jk.msa.email.mail.MailLauncher;
import com.jk.msa.email.mail.entity.MailContent;

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
	private MailLauncher mailLauncher;

	@Transactional
	public void prepareAndSendAuthentication(Account account) {
		account.setAuthenticationCode(RandomUtils.getRandomString(serviceConfig.getAuthCodeLength()));
		account.setAuthenticationCodeExpiredTime(
				LocalDateTime.now().plus(serviceConfig.getAuthCodeTTLMinutes(), ChronoUnit.MINUTES));
		accountRepository.save(account);

		Mail authMail = new Mail(account, new MailContent("[" + serviceConfig.getServiceName() + "] 서비스 본인인증 확인용 메일입니다.",
				"인증 확인 창에서 " + account.getAuthenticationCode() + "를 입력해주세요."));
		mailLauncher.sendMimeMail(authMail);
		// 인증 메일은 DB에 저장 안함
	}
}
