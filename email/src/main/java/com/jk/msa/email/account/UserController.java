package com.jk.msa.email.account;

import java.util.ArrayList;
import java.util.List;

import com.jk.msa.email.account.dto.EmailRegistrationDto;
import com.jk.msa.email.account.entity.Account;
import com.jk.msa.email.account.repository.AccountRepository;
import com.jk.msa.email.common.ApiResult;
import com.jk.msa.email.common.CommonResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("User Controller")
@RequestMapping(value = "/v1/user")
public class UserController {

	@Autowired
	AccountService accountService;

  @Autowired
  AccountRepository accountRepository;

	@GetMapping(value = "/{id}/account")
	@ApiOperation(value = "유저에게 등록된 이메일 계정 조회")
  public CommonResponse<List<Account>> getAccountsByUserId(@PathVariable("id") String userId) {
		List<Account> accountsOfUser = accountRepository
				.findAllByUserId(userId)
				.orElseGet(() -> new ArrayList<Account>());
    return new CommonResponse<List<Account>>(ApiResult.SUCCESS, accountsOfUser);
  }

	@PostMapping(value = "/account")
	@ApiOperation(value = "유저에게 메일 등록")
	public CommonResponse<Void> registerAccount(@RequestBody EmailRegistrationDto dto) {
		List<Account> matchedAccounts = accountService.findAccountsByEmail(dto.getEmailAddress());

		if (matchedAccounts.size() == 0) {
			accountService.cleanCreateNewAccount(dto.getUserId(), dto.getEmailAddress());
			return new CommonResponse<Void>(ApiResult.SUCCESS);
		}

		if (accountService.isUserInAccounts(dto.getUserId(), matchedAccounts)) {
			return new CommonResponse<Void>(ApiResult.SUCCESS, "이미 업데이트 됨");
		}

		return null;
	}
	
	
	
}
