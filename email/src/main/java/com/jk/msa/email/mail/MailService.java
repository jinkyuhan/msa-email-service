package com.jk.msa.email.mail;

import java.util.List;

import com.jk.msa.email.mail.dto.SendMailDto;

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