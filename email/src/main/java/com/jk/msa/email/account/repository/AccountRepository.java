package com.jk.msa.email.account.repository;

import java.util.List;
import java.util.Optional;

import com.jk.msa.email.account.entity.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

  public Optional<List<Account>> findAllByUserId(String userId);

  public Optional<Account> findByMailAddress(String emailAddress);
}
