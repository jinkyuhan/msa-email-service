package com.jk.msa.email.repository;

import com.jk.msa.email.entity.Mail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends JpaRepository<Mail, String> {
}
