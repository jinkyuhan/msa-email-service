package com.jk.msa.email;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Mail {

  @Id
  private String id;

  @Column
  private String title;

  @Column
  private String content;

  @Column
  private String senderEmail;

  @Column
  private String receiverEmail;

  public Mail(String senderId, String receiverId, String title) {
    this.id = UUID.randomUUID().toString();
    this.senderEmail = senderId;
    this.receiverEmail = receiverId;
    this.title = title;
    this.content = "";
  }

}
