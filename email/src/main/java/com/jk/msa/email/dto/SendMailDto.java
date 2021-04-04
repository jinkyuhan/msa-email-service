package com.jk.msa.email.dto;

import com.jk.msa.email.entity.MailContent;

public class SendMailDto {
  private MailContent content;
  private String[] receiverUids; 
}
