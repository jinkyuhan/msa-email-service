package com.jk.msa.email.mail.entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Embeddable
@Getter
@Setter
public class MailContent {
	private String title;
	private String body;
}
