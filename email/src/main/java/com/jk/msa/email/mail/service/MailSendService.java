package com.jk.msa.email.mail.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

import com.jk.msa.email.account.entity.Account;
import com.jk.msa.email.account.repository.AccountRepository;
import com.jk.msa.email.config.ServiceConfig;
import com.jk.msa.email.mail.dto.SendMailDto;
import com.jk.msa.email.mail.entity.Mail;
import com.jk.msa.email.mail.repository.MailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

@Service
public class MailSendService {

    @Autowired
    private MailRepository mailRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ServiceConfig serviceConfig;

    @Autowired
    private JavaMailSender javaMailSender;

    @Transactional
    public void sendMail(SendMailDto sendMailDto) {
        List<Account> receiverAccounts = accountRepository.findByUserIdIn(sendMailDto.getReceiverUserIds());
        Mail[] mailsToSend = receiverAccounts
                .stream()
                .map((account) -> new Mail(account, sendMailDto.getTitle(), sendMailDto.getBody()))
                .toArray(Mail[]::new);
        this.mailRepository.saveAll(Arrays.asList(mailsToSend));
        this.sendMails(mailsToSend);
    }

    public void sendInstantMail(SendMailDto sendMailDto) {
        List<Account> receiverAccounts = accountRepository.findByUserIdIn(sendMailDto.getReceiverUserIds());
        this.sendMails(receiverAccounts
                .stream()
                .map(receiverAccount -> new Mail(
                        receiverAccount,
                        sendMailDto.getTitle(),
                        sendMailDto.getBody()
                ))
                .toArray(Mail[]:: new)
        );
    }


    private void sendMails(Mail... mailsToSend) throws RuntimeException {

        List<Mail> simpleMails = new ArrayList<Mail>();
        List<Mail> mimeMails = new ArrayList<Mail>();

        for (Mail mailToSend : mailsToSend) {
            if (mailToSend.hasHtmlBody()) { // TODO : Check if mail is mimeMessage
                mimeMails.add(mailToSend);
            } else {
                simpleMails.add(mailToSend);
            }
        }

        javaMailSender.send(
                simpleMails
                        .stream()
                        .map((mail) -> mail.toSimpleMailMessage(serviceConfig.getSenderAddress()))
                        .toArray(SimpleMailMessage[]::new)
        );
        javaMailSender.send(
                mimeMails
                        .stream()
                        .map((mail) -> mail.toMimeMessagePreparator(serviceConfig.getSenderAddress(), mail.hasHtmlBody()))
                        .toArray(MimeMessagePreparator[]::new)
        );
    }
}