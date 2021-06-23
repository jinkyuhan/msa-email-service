package com.jk.msa.email.mail;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jk.msa.email.account.entity.Account;
import com.jk.msa.email.mail.entity.MailContent;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "mail")
public class Mail {

	@Id
	private String id;

	@ManyToOne()
	@JoinColumn(name = "receiver_id")
	private Account receiver;

	@Embedded
	@Column
	private MailContent content;

	@Column(name = "tag_1")
	private String tag1;

	@Column(name = "tag_2")
	private String tag2;

	@CreatedDate
	@Column(name = "created_time")
	private LocalDateTime createTime;

	public Mail(Account receiver, MailContent content) {
		this.id = UUID.randomUUID().toString();
		this.receiver = receiver;
		this.content = content;
	}

	public SimpleMailMessage toSimpleMailMessage(String senderEmailAddress) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(senderEmailAddress);
		message.setTo(this.getReceiver().getMailAddress());
		message.setSubject(this.getContent().getTitle());
		message.setText(this.getContent().getBody());
		return message;
	}

	public MimeMessagePreparator toMimeMessagePreparator(String senderEmailAddress, boolean isHTML) {
		String receiverMailAddress = this.getReceiver().getMailAddress();
		String mailTitle = this.getContent().getTitle();
		String mailBody = this.getContent().getBody();
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws MessagingException {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				helper.setFrom(senderEmailAddress);
				helper.setTo(receiverMailAddress);
				helper.setSubject(mailTitle);
				helper.setText(mailBody, isHTML);
			}
		};
		return preparator;
	}

}
