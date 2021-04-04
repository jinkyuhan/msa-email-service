package com.jk.msa.email.controller;

import com.jk.msa.email.dto.MailListDto;
import com.jk.msa.email.entity.Mail;
import com.jk.msa.email.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mail")
public class MailController {

  @Autowired
  private MailService mailService;

  @GetMapping(value = "/")
  public ResponseEntity<MailListDto> getMails() {
    Mail[] mails = mailService.getAllMails();
    return new ResponseEntity<MailListDto>(new MailListDto(mails), HttpStatus.OK);
  }
}