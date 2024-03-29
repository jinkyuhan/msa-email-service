package com.jk.msa.email.mail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.jk.msa.email.common.ApiResult;
import com.jk.msa.email.common.CommonResponse;
import com.jk.msa.email.common.SearchOptionDto;
import com.jk.msa.email.mail.dto.SendMailDto;
import com.jk.msa.email.mail.entity.Mail;
import com.jk.msa.email.mail.service.MailSearchService;
import com.jk.msa.email.mail.service.MailSendService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/v1/mail")
public class MailController {

  @Autowired
  MailSendService mailSendService;

  @Autowired
  MailSearchService mailSearchService;

  @ApiOperation("메일 검색")
  @GetMapping("/")
  public CommonResponse<Map<String, List<Mail>>> searchMail(
      @RequestParam(name = "subject", required = false) String subject,
      @RequestParam(name = "query", required = false) String query,
      @RequestParam(name = "pageNum", required = false) Integer pageNum,
      @RequestParam(name = "perPage", required = false) Integer perPage) {

    SearchOptionDto searchOption = new SearchOptionDto(query, subject);
    Map<String, List<Mail>> responseData = new HashMap<String, List<Mail>>();
    if (pageNum != null && perPage != null) {
      responseData.put("mails",
          mailSearchService.searchWithPagination(Optional.of(searchOption), PageRequest.of(pageNum, perPage)));
      return new CommonResponse<>(ApiResult.SUCCESS, responseData);
    }

    responseData.put("mails", mailSearchService.search(searchOption));
    return new CommonResponse<>(ApiResult.SUCCESS, responseData);
  }

  @ApiOperation("메일 상세 검색")
  @GetMapping("/{id}")
  public CommonResponse<Map<String, Mail>> searchMailById(@PathVariable("id") String id) {
    Map<String, Mail> responseData = new HashMap<>();
    responseData.put("mail", mailSearchService.searchById(id));
    return new CommonResponse<>(ApiResult.SUCCESS);
  }

  @ApiOperation("메일 전송")
  @PostMapping("/send")
  public CommonResponse<Void> sendMailToUsers(SendMailDto dto) {
    mailSendService.sendMail(dto);
    return new CommonResponse<>(ApiResult.SUCCESS);
  }
}
