package com.jk.msa.email.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.jk.msa.email.account.dto.AuthPrepareDto;
import com.jk.msa.email.account.dto.AuthValidateDto;
import com.jk.msa.email.account.entity.Account;
import com.jk.msa.email.account.repository.AccountRepository;
import com.jk.msa.email.account.service.AccountAuthService;
import com.jk.msa.email.account.service.AccountSearchService;
import com.jk.msa.email.common.ApiResult;
import com.jk.msa.email.common.CommonResponse;
import com.jk.msa.email.common.SearchOptionDto;
import com.jk.msa.email.common.exception.RequestFailException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/account")
@Validated
public class AccountController {

  @Autowired
  AccountRepository accountRepository;

  @Autowired
  AccountAuthService accountAuthService;

  @Autowired
  AccountSearchService accountSearchService;

  @GetMapping(value = "/")
  @ApiOperation(value = "계정 정보 검색")
  public CommonResponse<Map<String, List<Account>>> searchAccount(
      @RequestParam(name = "subject", required = false) String subject,
      @RequestParam(name = "query", required = false) String query,
      @RequestParam(name = "pageNum", required = false) Integer pageNum,
      @RequestParam(name = "perPage", required = false) Integer perPage
  ) {
    SearchOptionDto searchOption = new SearchOptionDto(query, subject);
    Map<String, List<Account>> responseData = new HashMap<>();
    if (pageNum != null && perPage != null) {
      responseData.put("accounts",
          accountSearchService.searchWithPagination(Optional.of(searchOption), PageRequest.of(pageNum - 1, perPage)));
      return new CommonResponse<>(ApiResult.SUCCESS, responseData);
    }
    responseData.put("accounts", accountSearchService.search(searchOption));
    return new CommonResponse<>(ApiResult.SUCCESS, responseData);
  }

  @GetMapping(value = "/{id}")
  @ApiOperation(value = "계정 id로 조회")
  public CommonResponse<Map<String, Account>> searchById(@PathVariable("id") String accountId) {
    Map<String, Account> responseData = new HashMap<>();
    responseData.put("account", accountSearchService.searchByAccountId(accountId));
    return new CommonResponse<>(ApiResult.SUCCESS, responseData);
  }

  @GetMapping(value = "/is-authenticated")
  @ApiOperation(value = "계정(유저-메일) 인증 여부 조회")
  public CommonResponse<Map<String, Boolean>> isAuthenticatedAccount(@RequestParam("userId") String userId,
      @RequestParam("email") String emailAddress, @RequestParam("since") String sinceTimestamp) {
    Account queryAccount = accountRepository.findByUserIdAndMailAddress(userId, emailAddress)
        .orElseThrow(() -> new RequestFailException(ApiResult.NOT_EXIST_ACCOUNT));

    Map<String, Boolean> isAuthResult = new HashMap<>();
    isAuthResult.put("isAuthenticated", queryAccount.isAuthenticated());
    return new CommonResponse<>(ApiResult.SUCCESS, isAuthResult);
  }

  @PostMapping(value = "/prepare-authentication")
  @ApiOperation(value = "새로운 계정 등록 및 인증 메일 전송")
  public CommonResponse<Void> prepareAccountAuthentication(@Valid @RequestBody final AuthPrepareDto dto) {
    Account accountToAuthenticate = accountRepository.findByUserIdAndMailAddress(dto.getUserId(), dto.getEmailAddress())
        .orElse(null);

    if (accountToAuthenticate == null) {
      accountToAuthenticate = new Account(dto.getUserId(), dto.getEmailAddress());
    }
    accountToAuthenticate.setTag(dto.getTag());
    accountAuthService.prepareAndSendAuthentication(accountToAuthenticate);

    return new CommonResponse<>(ApiResult.SUCCESS);
  }

  @PostMapping(value = "/validate-authentication")
  @ApiOperation(value = "인증 번호 확인 및 사용자를 인증 된 상태로 변경")
  public CommonResponse<Void> validateAccountAuthentication(@RequestBody AuthValidateDto dto) {
    Account accountToValidate = accountRepository.findByUserIdAndMailAddress(dto.getUserId(), dto.getEmailAddress())
        .orElseThrow(() -> new RequestFailException(ApiResult.NOT_EXIST_ACCOUNT));

    if (!accountToValidate.validateAuthCode(dto.getAuthCode())) {
      throw new RequestFailException(ApiResult.INVALID_AUTHENTICATION_CODE);
    }

    accountRepository.save(accountToValidate);

    return new CommonResponse<>(ApiResult.SUCCESS);
  }
}
