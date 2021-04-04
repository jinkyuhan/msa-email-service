package com.jk.msa.email.repository;

import java.util.List;

import com.jk.msa.email.entity.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
  
  public List<Account> findAllByUid(String uid);

  public Account findByMailAddress(String emailAddress);
}
