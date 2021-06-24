package com.jk.msa.email.mail;

import com.jk.msa.email.common.exception.ByServerException;
import com.jk.msa.email.config.ServiceConfig;
import com.jk.msa.email.mail.entity.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailLauncher {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private ServiceConfig serviceConfig;

	public void sendSimpleMail(Mail mailToSend) {
		try {
			mailSender.send(mailToSend.toSimpleMailMessage(serviceConfig.getSenderAddress()));
		} catch (Exception e) {
			throw new ByServerException(e.getMessage());
		}
	}

	public void sendMimeMail(Mail mailToSend) {
		try {
			mailSender.send(mailToSend.toSimpleMailMessage(serviceConfig.getSenderAddress()));
		} catch (Exception e) {
			throw new ByServerException(e.getMessage());
		}
	}
}