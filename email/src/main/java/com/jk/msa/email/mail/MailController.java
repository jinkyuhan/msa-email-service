package com.jk.msa.email.mail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping(value = "/v1/mail")
public class MailController {

	@Autowired
	MailSendService mailService;

	@Autowired
	AccountRepository accountRepository;

	@ApiOperation("메일 검색")
	@GetMapping("/")
	public CommonResponse<Map<String, List<Mail>>> searchMail(
			@RequestParam(name = "subject", required = false) String subject,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "pageNum", required = false) Integer pageNum,
			@RequestParam(name = "perPage", required = false) Integer perPage) {
		Map<String, List<Mail>> responseData = new HashMap<String, List<Mail>>();
		responseData.put("query", new ArrayList<Mail>());

		return new CommonResponse<Map<String, List<Mail>>>(ApiResult.SUCCESS, responseData);
	}

	// @ApiOperation("메일 전송")
	// @PostMapping("/send")
	// public CommonResponse<Void> sendMailToUsers(SendMailDto dto) {
	// // int successCount = mailService.sendMail(dto);

	// // if (dto.getReceiverUserIds().length != successCount) {
	// // return new CommonResponse<Void>(ApiResult.SUCCESS);
	// // }
	// return new CommonResponse<Void>(ApiResult.PARTIAL_SUCCESS);
	// }
}
