package com.jk.msa.email.account;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

  public List<Account> findAllByUid(String uid);

  public Account findByMailAddress(String emailAddress);
}
