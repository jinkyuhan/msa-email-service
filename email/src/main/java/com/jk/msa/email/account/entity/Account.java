package com.jk.msa.email.account.entity;

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

@Entity
@Table(name = "account")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account {

  @Id
  private String id;

  @Column(name = "mail_address", unique = true, nullable = true)
  private String mailAddress;

  @Column(name = "user_id", nullable = true)
  private String userId;

	@Column(name = "authentication_code", nullable = true)
	private String authenticationCode;
	
	@Column(name = "authentication_code_expired_time", nullable = true) 
	private LocalDateTime authenticationCodeExpiredTime;

  @Column(name = "authenticated_time", nullable = true)
  private LocalDateTime authenticatedSuccessTime;

  @CreatedDate
  @Column(name = "create_time")
  private LocalDateTime createdTime;

  @LastModifiedDate
  @Column(name = "update_time")
  private LocalDateTime updatedTime;

  public Account(String userId, String mailAddress) {
    this.userId = userId;
    this.mailAddress = mailAddress;
  }
}