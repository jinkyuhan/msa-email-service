package com.jk.msa.email.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.jk.msa.email.account.repository.AccountRepository;
import com.jk.msa.email.common.exception.ByServerException;
import com.jk.msa.email.config.ServiceConfig;
import com.jk.msa.email.mail.dto.SendMailDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailService {

  @Autowired(required = true)
  private MailRepository mailRepository;

  @Autowired
  private AccountRepository accountRepository;

	@Autowired
	private ServiceConfig serviceConfig;

  @Autowired
  private JavaMailSender mailSender;

	public void sendAuthenticationMail(String receiverEmailAddress) {
		sendSimpleMail(
			serviceConfig.getSenderAddress(),
			receiverEmailAddress,
			"제목",
			"본문 코드"
		);
	}

  public int sendMail(SendMailDto sendMailDto) {
    Mail newMail = new Mail();
    mailSender.send((MimeMessage) newMail.getMailMessage());
    return 1;
  }


	private void sendSimpleMail(
		String senderMailAddress,
		String receiverMailAddress,
		String title,
		String body
	) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(senderMailAddress);
			message.setTo(receiverMailAddress);
			message.setSubject(title);
			message.setText(body);
			mailSender.send(message);
		} catch (Exception e) {
			throw new ByServerException(e.getMessage());
		}
	}

	private void sendMimeMail(
		String senderMailAddress,
		String receiverMailAddress,
		String title,
		String body
	) {
		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				@Override
				public void prepare(MimeMessage mimeMessage) throws MessagingException {
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					helper.setTo(receiverMailAddress);
					helper.setFrom(senderMailAddress);
					helper.setSubject(title);
					helper.setText(body, true); // 2번째 arg, html text 인지 아닌지 
				}
			};
			mailSender.send(preparator);
		} catch (Exception e) {
			throw new ByServerException(e.getMessage());
		}
	}

}