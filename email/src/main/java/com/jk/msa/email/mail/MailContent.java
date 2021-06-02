package com.jk.msa.email.mail;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Embeddable
public class MailContent {

  private String title;
  private String body;
}
