package com.jk.msa.email.account;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import com.jk.msa.email.account.entity.Account;
import com.jk.msa.email.account.repository.AccountRepository;
import com.jk.msa.email.common.utils.RandomUtils;
import com.jk.msa.email.config.ServiceConfig;
import com.jk.msa.email.mail.Mail;
import com.jk.msa.email.mail.MailContent;
import com.jk.msa.email.mail.MailLauncher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ServiceConfig serviceConfig;

	@Autowired
	private MailLauncher mailLauncher;

	public boolean isAlreadyExistEmail(String emailAddress) {
		return accountRepository.findByMailAddress(emailAddress).orElseGet(() ->null) != null;
	}
	
	public void cleanCreateNewAccount(String userId, String email) {
		this.accountRepository.save(new Account(userId, email));
	}

	public boolean isUserInAccounts(String userId, List<Account> accounts) {
		return accounts
				.stream()
				.filter(account -> account.getUserId() == userId)
				.collect(Collectors.toList())
				.size() > 0;
	}

	public void prepareAuthentication(Account account) {
		//TODO transaction
		account.setAuthenticationCode(RandomUtils.getRandomString(serviceConfig.getAuthCodeLength()));
		account.setAuthenticationCodeExpiredTime(
			LocalDateTime
					.now()
					.plus(
						serviceConfig.getAuthCodeTTLMinutes(),
						ChronoUnit.MINUTES
					)
		);
		accountRepository.save(account);

		Mail authMail = new Mail(
			account,
			new MailContent("인증 제목", "인증 내용")
		);
		mailLauncher.sendMimeMail(authMail);
		// 인증 메일은 DB에 저장 안함
	}
}
