package com.jk.msa.email.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "mail")
public class Mail {

  @Id
  private String id;

  @Column
  private MailContent content;

  @Column
  private String senderId;

  @Column
  private String receiverId;

  public Mail(String senderId, String receiverId, MailContent content) {
    this.id = UUID.randomUUID().toString();
    this.senderId = senderId;
    this.receiverId = receiverId;
    this.content = content;
  }

}
