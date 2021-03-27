package com.jk.msa.email.controller;

import com.jk.msa.email.dto.MailListDto;
import com.jk.msa.email.entity.Mail;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/mail")
public class MailController {

  // @Autowired
  // private MailService mailService;

  @GetMapping(path = "/")
  public ResponseEntity<MailListDto> getMails() {
    // Mail[] mails = mailService.getAllMails();
    Mail[] mails = {};
    return new ResponseEntity<MailListDto>(new MailListDto(mails), HttpStatus.OK);
  }
}