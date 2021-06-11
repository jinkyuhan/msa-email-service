package com.jk.msa.email.account;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jk.msa.email.account.entity.Account;
import com.jk.msa.email.account.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

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

	public boolean isAuthenticatedAccount(String userId, String email,) {
		Account matchedAccount = accountRepository
				.findByUserIdAndMailAddress(userId, email)
				.orElseThrow(() -> new CommonException(ApiResult.NOT_EXIST_ACCOUNT));
		return matchedAccount.getAuthenticatedSuccessTime() != null;
	}
}
