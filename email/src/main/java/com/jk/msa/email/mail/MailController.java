package com.jk.msa.email.mail;

import com.jk.msa.email.common.ApiResult;
import com.jk.msa.email.common.CommonResponse;
import com.jk.msa.email.mail.dto.SendMailDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mail")
public class MailController {

  @Autowired
  MailService mailService;

  @PostMapping("/send")
  public CommonResponse<Void> sendMailToUsers(SendMailDto dto) {
    int successCount = mailService.sendMail(dto);

    if (dto.getReceiverUserIds().length != successCount) {
      return new CommonResponse<Void>(ApiResult.SUCCESS);
    }
    return new CommonResponse<Void>(ApiResult.PARTIAL_FAIL);
  }
}
