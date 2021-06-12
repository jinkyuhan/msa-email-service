package com.jk.msa.email.mail.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SendAuthMailDto {
	private String title;
	private String body;
	private String targetUserId;
	private String targetEmailAddress;
}
