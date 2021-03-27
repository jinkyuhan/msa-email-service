package com.jk.msa.email.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "mail_account")
public class MailAccount {
  @Id
  private String uid;

  @Column(name = "mail_address")
  private String mailAddress;

  @Column(name = "is_authenticated")
  private boolean isAuthenticated;

}