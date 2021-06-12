package com.jk.msa.email.mail.dto;

import com.jk.msa.email.mail.MailContent;

public class SendMailDto {
  private MailContent content;
  private String senderUserId;
  private String[] receiverUserIds;

	public SendMailDto(String title, String content, String senderUserId, receiverUserIds) {

	}
}
