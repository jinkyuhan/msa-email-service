package com.jk.msa.email.account;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, String> {

  @Query("SELECT user_id FROM  WHERE  ")
  public List<String> findAllUserId();

  public List<Account> findAllByUserId(String userId);

  public Account findByMailAddress(String emailAddress);
}
