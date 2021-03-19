package com.jk.msa.email;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mail {
  private String title;
  private String content;
  private String senderId;
  private String receiverId;

  public Mail(String senderId, String receiverId, String title) {
    this.senderId = senderId;
    this.receiverId = receiverId;
    this.title = title;
    this.content = "";
  }

}
