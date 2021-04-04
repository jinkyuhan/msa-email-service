package com.jk.msa.email.service;

import java.util.List;

import com.jk.msa.email.dto.SendMailDto;
import com.jk.msa.email.entity.Mail;
import com.jk.msa.email.repository.MailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService {

  @Autowired(required = true)
  private MailRepository mailRepository;

  // public CursorResult<Mail> getMails(int cursor, int size, String cursorType) {
  // List<Mail> mails = mailRepository.findAll();
  // return new CursorResult<Mail>(mails.toArray(new Mail[mails.size()]), true);
  // }
  public Mail[] getAllMails() {
    List<Mail> mails = mailRepository.findAll();
    return mails.toArray(new Mail[mails.size()]);
  }

  public int sendMail(SendMailDto sendMailDto) {
    return 1;
  }
}