package com.jk.msa.email.entity;

import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public class MailContent {

  private String title;
  private String body;

  MailContent(String title, String body) {
    this.title = title;
    this.body = body;
  }
}
