package com.jk.msa.email.mail.dto;

import com.jk.msa.email.mail.entity.MailContent;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SendMailDto {
	private MailContent content;
	private String senderUserId;
	private String[] receiverUserIds;
}
