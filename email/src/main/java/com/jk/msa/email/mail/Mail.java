package com.jk.msa.email.mail;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jk.msa.email.account.entity.Account;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "mail")
public class Mail{

  @Id
  private String id;

  @Embedded
  @Column
  private MailContent content;

  @ManyToOne()
  @JoinColumn(name = "sender_id")
  private Account sender;

  @ManyToOne()
  @JoinColumn(name = "receiver_id")
  private Account receiver;

  @Column(name = "tag_1")
  private String tag1;

  @Column(name = "tag_2")
  private String tag2;

  @CreatedDate
  @Column(name = "created_time")
  private LocalDateTime createTime;

  public Mail(Account sender, Account receiver, MailContent content) {
    this.id = UUID.randomUUID().toString();
    this.sender = sender;
    this.receiver = receiver;
    this.content = content;
  }

  public MailMessage getMailMessage() {
    // if (this.content.getBody() != null) {
      MailMessage message;
      message = new SimpleMailMessage();
      message.setFrom(this.sender.getMailAddress());
      message.setTo(this.receiver.getMailAddress());
      message.setSubject(this.content.getTitle());
      message.setText(this.content.getBody());
      return message;
    // }
  }
}
