package com.jk.msa.email.entity;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class MailContent {

  private String title;
  private String body;

  MailContent(String title, String body) {
    this.title = title;
    this.body = body;
  }

}
