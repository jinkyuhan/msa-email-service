package com.jk.msa.email.account.service;

import java.util.List;
import java.util.Optional;

import com.jk.msa.email.account.dto.SearchOptionDto;
import com.jk.msa.email.account.entity.Account;
import com.jk.msa.email.account.repository.AccountRepository;
import com.jk.msa.email.common.ApiResult;
import com.jk.msa.email.common.exception.RequestFailException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AccountSearchService {

	@Autowired
	private AccountRepository accountRepository;

	public List<Account> search(SearchOptionDto searchOption) {
		String queryInput = Optional.ofNullable(searchOption.getQuery()).orElse("");
		if (queryInput.isBlank()) {
			return accountRepository.findAll();
		}
		switch (searchOption.getSubject()) {
			case "userId":
				return accountRepository.findByUserIdContaining(queryInput);
			case "email":
				return accountRepository.findByMailAddressContaining(queryInput);
			default:
				throw new RequestFailException(ApiResult.BAD_PARAMETER);
		}
	}

	public List<Account> searchWithPagination(SearchOptionDto findOption, PageRequest pageRequest) {
		String queryInput = Optional.ofNullable(findOption.getQuery()).orElse("");
		if (queryInput.isBlank()) {
			return accountRepository.findAll(pageRequest).toList();
		}
		switch (findOption.getSubject()) {
			case "userId":
				return accountRepository.findByUserIdContaining(queryInput, pageRequest).toList();
			case "email":
				return accountRepository.findByMailAddressContaining(queryInput, pageRequest).toList();
			default:
				throw new RequestFailException(ApiResult.BAD_PARAMETER);
		}
	}

	public List<Account> findByEmailAddress(String emailAddress) {
		return accountRepository.findByMailAddress(emailAddress);
	}

	public List<Account> findByUserId(String userId) {
		return accountRepository.findByUserId(userId);
	}
}