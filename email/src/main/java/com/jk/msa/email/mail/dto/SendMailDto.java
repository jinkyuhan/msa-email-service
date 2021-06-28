package com.jk.msa.email.mail.dto;

import com.jk.msa.email.mail.entity.MailContent;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SendMailDto {
  private MailContent content;
  private String[] receiverUserIds;
}
