package com.jk.msa.email.mail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends JpaRepository<Mail, String> {

  // public List<Mail> findAllByOrderByCreateTime();
}
