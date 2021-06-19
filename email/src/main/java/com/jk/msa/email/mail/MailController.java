package com.jk.msa.email.mail;

import com.jk.msa.email.account.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/mail")
public class MailController {

  @Autowired
  MailService mailService;

	@Autowired
	AccountRepository accountRepository;

	// @ApiOperation("메일 전송")
  // @PostMapping("/send")
  // public CommonResponse<Void> sendMailToUsers(SendMailDto dto) {
  //   // int successCount = mailService.sendMail(dto);

  //   // if (dto.getReceiverUserIds().length != successCount) {
  //   //   return new CommonResponse<Void>(ApiResult.SUCCESS);
  //   // }
  //   return new CommonResponse<Void>(ApiResult.PARTIAL_SUCCESS);
  // }
}
