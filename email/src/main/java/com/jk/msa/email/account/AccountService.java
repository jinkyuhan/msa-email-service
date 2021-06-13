package com.jk.msa.email.account;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jk.msa.email.account.entity.Account;
import com.jk.msa.email.account.repository.AccountRepository;
import com.jk.msa.email.common.ApiResult;
import com.jk.msa.email.common.exception.RequestFailException;
import com.jk.msa.email.common.utils.DateUtils;
import com.jk.msa.email.common.utils.RandomUtils;
import com.jk.msa.email.config.ServiceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ServiceConfig serviceConfig;

	public List<Account> findAccountsByEmail(String emailAddress) {
		return accountRepository
				.findByMailAddress(emailAddress)
				.orElseGet(() -> new ArrayList<Account>());
	}

	public boolean isAlreadyExistEmail(String email) {
		return accountRepository.findByMailAddress(email).orElseGet(() ->null) != null;
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
	
	public boolean isAuthenticatedAccount(Account account) {
		return account.getAuthenticatedSuccessTime() != null;
	}
	public boolean isAuthenticatedAccount(String userId, String emailAddress) {
		return isAuthenticatedAccount(findAccountByUserIdAndEmailAddress(userId, emailAddress));
	}

	public boolean isAuthenticatedAccountSince(Account account, Long since) {
		return isAuthenticatedAccount(account)
				&& account.getAuthenticatedSuccessTime().isAfter(DateUtils.longTimestampToLocalDateTime(since));
	}

	public boolean isAuthenticatedAccount(String userId, String emailAddress, Long since) {
		return isAuthenticatedAccountSince(
			findAccountByUserIdAndEmailAddress(userId, emailAddress),
			since
		);
	}

	public void assignRandomAuthCodeToAccount(Account account) {
		account.setAuthenticationCode(RandomUtils.getRandomString(serviceConfig.getAuthCodeLength()));
		accountRepository.save(account);
	}

	public void assignRandomAuthCodeToAccount(String userId, String emailAddress, String code) {
		assignRandomAuthCodeToAccount(findAccountByUserIdAndEmailAddress(userId, emailAddress));
	}
	
	public Account findAccountByUserIdAndEmailAddress(String userId, String emailAddress) {
		return accountRepository
				.findByUserIdAndMailAddress(userId, emailAddress)
				.orElseThrow(() -> new RequestFailException(ApiResult.NOT_EXIST_ACCOUNT));
	}

	public boolean validateAuthenticationCode(String userId, String emailAddress, String code) {
		Account matchedAccount = findAccountByUserIdAndEmailAddress(userId, emailAddress)
		return matchedAccount.getAuthenticationCode() == code;
	}

}
