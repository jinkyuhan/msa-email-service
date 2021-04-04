package com.jk.msa.email.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {

  @Id
  private String id;

  @Column(name = "mail_address", unique = true)
  private String mailAddress;

  @Column(name = "uid")
  private String uid;

  @Column(name = "is_authenticated", nullable = false)
  private boolean isAuthenticated;

  @CreatedDate
  @Column(name = "create_time")
  private LocalDateTime createdTime;

  @LastModifiedDate
  @Column(name = "update_time")
  private LocalDateTime updatedTime;

  public Account(String uid, String mailAddress) {
    this.uid = uid;
    this.mailAddress = mailAddress;
    this.isAuthenticated = false;
  }
}