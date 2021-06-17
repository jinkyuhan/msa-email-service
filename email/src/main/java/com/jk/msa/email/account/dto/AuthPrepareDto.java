package com.jk.msa.email.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthPrepareDto {
	private String emailAddress;
	private String userId;
	private String tag;
}
