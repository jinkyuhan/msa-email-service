package com.jk.msa.email.account.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.jk.msa.email.common.utils.DateUtils;

import org.springframework.boot.devtools.autoconfigure.LocalDevToolsAutoConfiguration;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

	@Setter
	@Column(name = "authentication_code", nullable = true)
	private String authenticationCode;
	
	@Setter
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

	@Setter
	@Column(name = "tag")
	private String tag;

	public Account(String userId, String mailAddress) {
		this.id = UUID.randomUUID().toString();
		this.userId = userId;
		this.mailAddress = mailAddress;
	}

	public boolean isAuthenticated() {
		return this.authenticatedSuccessTime != null;
	}

	public boolean isAuthenticatedSince(long since) {
		return this.isAuthenticated()
				&& this.authenticatedSuccessTime
						.isAfter(DateUtils.longTimestampToLocalDateTime(since));
	}

	public boolean validateAuthCode(String authCode) { 
		boolean isValidateAuthCode = 
			this.authenticationCode.equals(authCode)
			&& LocalDateTime.now().isBefore(this.authenticationCodeExpiredTime);
		if (isValidateAuthCode) {
			this.authenticatedSuccessTime = LocalDateTime.now();
		}
		return isValidateAuthCode;
	}

	@PrePersist
	private void createdAt() {
		this.createdTime = LocalDateTime.now();
	}

	@PreUpdate
	private void preUpdate() {
		this.updatedTime = LocalDateTime.now();
	}

}