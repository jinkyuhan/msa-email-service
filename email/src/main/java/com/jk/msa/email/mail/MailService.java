package com.jk.msa.email.mail;

import java.util.List;

import com.jk.msa.email.mail.dto.SendMailDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

  @Autowired(required = true)
  private MailRepository mailRepository;
  @Autowired(required = true)
  private JavaMailSender mailSender;

  // public CursorResult<Mail> getMails(int cursor, int size, String cursorType) {
  // List<Mail> mails = mailRepository.findAll();
  // return new CursorResult<Mail>(mails.toArray(new Mail[mails.size()]), true);
  // }
  public Mail[] getAllMails() {
    List<Mail> mails = mailRepository.findAll();
    return mails.toArray(new Mail[mails.size()]);
  }

  public int sendMail(SendMailDto sendMailDto) {
    Mail newMail = new Mail();
    
    
    
    
    
    mailSender.send()
    return 1;
  }
}