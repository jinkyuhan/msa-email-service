package com.jk.msa.email.mail.repository;

import java.util.List;

import com.jk.msa.email.mail.entity.Mail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends JpaRepository<Mail, String> {

  public List<Mail> findByReceiverId(String senderId);

  public Page<Mail> findByReceiverId(String senderId, Pageable pageable);

  public List<Mail> findByTitleContaining(String titleQuery);

  public Page<Mail> findByTitleContaining(String titleQuery, Pageable pageable);

  public List<Mail> findByBodyContaining(String bodyQuery);

  public Page<Mail> findByBodyContaining(String bodyQuery, Pageable pageable);

}
