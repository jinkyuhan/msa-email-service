package com.jk.msa.email.account;

import java.util.ArrayList;
import java.util.List;

import com.jk.msa.email.account.dto.AuthPrepareDto;
import com.jk.msa.email.account.dto.IsAuthResultDto;
import com.jk.msa.email.account.entity.Account;
import com.jk.msa.email.account.repository.AccountRepository;
import com.jk.msa.email.common.ApiResult;
import com.jk.msa.email.common.CommonResponse;
import com.jk.msa.email.common.exception.RequestFailException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public CommonResponse<List<Account>> getAccountByEmail(@RequestParam("email") String emailAddress) {
		return new CommonResponse<List<Account>>(
			ApiResult.SUCCESS,
			accountRepository.findByMailAddress(emailAddress).orElseGet(() -> new ArrayList<Account>())
		);
	}

	@PostMapping(value = "/auth-mail")
	@ApiOperation(value = "새로운 계정 등록 및 인증 메일 전송")
	public CommonResponse<Void> prepareAccountAuthentication(
		AuthPrepareDto dto
	) {
		Account accountToAuthenticate = accountRepository
				.findByUserIdAndMailAddress(dto.getUserId(), dto.getEmailAddress())
				.orElse(null);

		// check if the account is already authenticated
		if (accountToAuthenticate != null) {
			if (accountToAuthenticate.isAuthenticated()) {
				throw new RequestFailException(ApiResult.ALREADY_AUTHENTICATED);
			}
		} else {
			// if not exist, create new one
			accountToAuthenticate = new Account(dto.getUserId(), dto.getEmailAddress());
		}
		accountToAuthenticate.setTag(dto.getTag());
		
		accountService.prepareAuthentication(accountToAuthenticate);

		return new CommonResponse<Void>(ApiResult.SUCCESS);
	}

	@GetMapping(value = "/is-authenticated")
	@ApiOperation(value = "계정(유저-메일) 인증 여부 조회")
	public CommonResponse<IsAuthResultDto> isAuthenticatedAccount(
			@RequestParam("userId") String userId, 
			@RequestParam("email") String emailAddress,
			@RequestParam("since") String sinceTimestamp
	) {
		Account queryAccount = accountRepository
				.findByUserIdAndMailAddress(userId, emailAddress)
				.orElseThrow(() -> new RequestFailException(ApiResult.NOT_EXIST_ACCOUNT));
		return new CommonResponse<IsAuthResultDto>(
			ApiResult.SUCCESS,
			new IsAuthResultDto(queryAccount.isAuthenticated())
		);
	}

}