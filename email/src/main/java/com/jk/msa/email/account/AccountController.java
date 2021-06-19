package com.jk.msa.email.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jk.msa.email.account.dto.AuthPrepareDto;
import com.jk.msa.email.account.dto.AuthValidateDto;
import com.jk.msa.email.account.dto.IsAuthResultDto;
import com.jk.msa.email.account.entity.Account;
import com.jk.msa.email.account.repository.AccountRepository;
import com.jk.msa.email.account.service.AccountAuthService;
import com.jk.msa.email.common.ApiResult;
import com.jk.msa.email.common.CommonResponse;
import com.jk.msa.email.common.exception.RequestFailException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	AccountAuthService accountAuthService;

	
	@GetMapping(value = "/")
	@ApiOperation(value = "이메일주소로 등록 현황 조회")
	public CommonResponse<Map<String, List<Account>>> getAccountByEmail(@RequestParam("email") String emailAddress) {
		Map<String, List<Account>> accountListResultMap = new HashMap<String, List<Account>>();
		accountListResultMap.put(
			"accounts", 
			accountRepository.findByMailAddress(emailAddress).orElseGet(
				() -> new ArrayList<Account>()
			)
		);
		
		return new CommonResponse<Map<String, List<Account>>>(
			ApiResult.SUCCESS,
			accountListResultMap
		);
	}

	@GetMapping(value = "/is-authenticated")
	@ApiOperation(value = "계정(유저-메일) 인증 여부 조회")
	public CommonResponse<Map<String, Boolean>> isAuthenticatedAccount(
			@RequestParam("userId") String userId, 
			@RequestParam("email") String emailAddress,
			@RequestParam("since") String sinceTimestamp
	) {
		Account queryAccount = accountRepository
				.findByUserIdAndMailAddress(userId, emailAddress)
				.orElseThrow(() -> new RequestFailException(ApiResult.NOT_EXIST_ACCOUNT));

		Map<String, Boolean> isAuthResult = new HashMap<String, Boolean>();
		isAuthResult.put("isAuthenticated", queryAccount.isAuthenticated());
		return new CommonResponse<Map<String,Boolean>>(
			ApiResult.SUCCESS,
			isAuthResult
		);
	}

	@PostMapping(value = "/prepare-authentication")
	@ApiOperation(value = "새로운 계정 등록 및 인증 메일 전송")
	public CommonResponse<Void> prepareAccountAuthentication(
		@RequestBody AuthPrepareDto dto
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
		accountAuthService.prepareAndSendAuthentication(accountToAuthenticate);

		return new CommonResponse<Void>(ApiResult.SUCCESS);
	}

	@PostMapping(value = "/validate-authentication")
	@ApiOperation(value = "인증 번호 확인 및 사용자를 인증 된 상태로 변경")
	public CommonResponse<Void> validateAccountAuthentication(
		@RequestBody AuthValidateDto dto
	) {
		Account accountToValidate = accountRepository
				.findByUserIdAndMailAddress(dto.getUserId(), dto.getEmailAddress())
				.orElseThrow(() -> new RequestFailException(ApiResult.NOT_EXIST_ACCOUNT));
		
		if (accountToValidate.isAuthenticated()) {
			throw new RequestFailException(ApiResult.ALREADY_AUTHENTICATED);
		}
		
		if (!accountToValidate.validateAuthCode(dto.getAuthCode())) {
			throw new RequestFailException(ApiResult.INVALID_AUTHENTICATION_CODE);
		}

		accountRepository.save(accountToValidate);
		
		return new CommonResponse<Void>(ApiResult.SUCCESS);
	}
}