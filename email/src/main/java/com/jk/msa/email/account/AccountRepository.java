package com.jk.msa.email.account;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

  public Optional<List<Account>> findAllByUserId(String userId);

  public Account findByMailAddress(String emailAddress);
}
