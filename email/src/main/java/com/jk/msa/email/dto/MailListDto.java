package com.jk.msa.email.dto;

import com.jk.msa.email.entity.Mail;

import lombok.Data;

@Data
public class MailListDto {
  private Mail[] mails;

  public MailListDto(Mail[] mails) {
    this.mails = mails;
  }
}
