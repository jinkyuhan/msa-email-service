package com.jk.msa.email.mail.dto;

import com.jk.msa.email.mail.Mail;

import lombok.Data;

@Data
public class MailListDto {
  private Mail[] mails;

  public MailListDto(Mail[] mails) {
    this.mails = mails;
  }
}
