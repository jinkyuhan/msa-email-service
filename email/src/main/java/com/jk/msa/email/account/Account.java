package com.jk.msa.email.account;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {

  @Id
  private String id;

  @Column(name = "mail_address", unique = true, nullable: true)
  private String mailAddress;

  @Column(name = "user_id", nullable = true)
  private String userId;

  @Column(name = "is_authenticated", nullable = false)
  private boolean isAuthenticated;

  @CreatedDate
  @Column(name = "create_time")
  private LocalDateTime createdTime;

  @LastModifiedDate
  @Column(name = "update_time")
  private LocalDateTime updatedTime;

  public Account(String userId, String mailAddress) {
    this.userId = userId;
    this.mailAddress = mailAddress;
    this.isAuthenticated = false;
  }
}