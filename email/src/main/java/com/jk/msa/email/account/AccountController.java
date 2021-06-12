package com.jk.msa.email.account;

import java.util.List;

import com.jk.msa.email.account.dto.IsAuthResultDto;
import com.jk.msa.email.account.entity.Account;
import com.jk.msa.email.account.repository.AccountRepository;
import com.jk.msa.email.common.ApiResult;
import com.jk.msa.email.common.CommonResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/v1/account")
public class AccountController {

  @Autowired
  AccountRepository accountRepository;

	@Autowired
	AccountService accountService;

	
	@GetMapping(value = "/")
	@ApiOperation(value = "이메일주소로 등록 현황 조회")
	public CommonResponse<List<Account>> getAccountByEmail(@RequestParam("email") String email) {
		List<Account> matchedAccounts = accountService.findAccountsByEmail(email);
		return new CommonResponse<List<Account>>(ApiResult.SUCCESS, matchedAccounts);
	}

	@GetMapping(value = "/is-authenticated")
	@ApiOperation(value = "계정(유저-메일) 인증 여부 조회")
	public CommonResponse<IsAuthResultDto> isAuthenticatedAccount(
			@RequestParam("userId") String userId, 
			@RequestParam("email") String email,
			@RequestParam("since") String sinceTimestamp
	) {
		return new CommonResponse<IsAuthResultDto>(
				ApiResult.SUCCESS,
				new IsAuthResultDto(accountService.isAuthenticatedAccount(userId, email, Long.parseLong(sinceTimestamp)))
		);
	}
}