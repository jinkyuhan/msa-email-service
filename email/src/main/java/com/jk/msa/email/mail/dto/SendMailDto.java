package com.jk.msa.email.mail.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SendMailDto {
  private String title;
  private String body;
  private String[] receiverUserIds;
}
