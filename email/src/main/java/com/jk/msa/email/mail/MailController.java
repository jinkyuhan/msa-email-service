package com.jk.msa.email.mail;

import com.jk.msa.email.common.ApiResult;
import com.jk.msa.email.common.CommonResponse;
import com.jk.msa.email.mail.dto.SendAuthMailDto;
import com.jk.msa.email.mail.dto.SendMailDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/v1/mail")
public class MailController {

  @Autowired
  MailService mailService;

	@ApiOperation("메일 전송")
  @PostMapping("/send")
  public CommonResponse<Void> sendMailToUsers(SendMailDto dto) {
    int successCount = mailService.sendMail(dto);

    // if (dto.getReceiverUserIds().length != successCount) {
    //   return new CommonResponse<Void>(ApiResult.SUCCESS);
    // }
    return new CommonResponse<Void>(ApiResult.PARTIAL_SUCCESS);
  }

	@ApiOperation("등록을 위한 인증 메일 전송")
	@PostMapping("/send-authentication") 
	public CommonResponse<Void> sendMailToUsers(SendAuthMailDto dto) {
		
		
		// mailSerivce.createUnAuthenticatedNewAccount 
		mailService.sendAuthenticationMail(dto.getTargetEmailAddress());
		return new CommonResponse<Void>(ApiResult.SUCCESS);
	}
}
