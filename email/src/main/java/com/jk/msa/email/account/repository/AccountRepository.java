package com.jk.msa.email.account.repository;

import java.util.List;
import java.util.Optional;

import com.jk.msa.email.account.entity.Account;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

  public List<Account> findByUserId(String userId);

  public List<Account> findByUserIdContaining(String userIdQuery);

  public Page<Account> findByUserIdContaining(String userIdQuery, Pageable pageable);

  public List<Account> findByMailAddress(String emailAddress);

  public List<Account> findByMailAddressContaining(String emailAddressQuery);

  public Page<Account> findByMailAddressContaining(String emailAddressQuery, Pageable pageable);

  public Optional<Account> findByUserIdAndMailAddress(String userId, String emailAddress);
}
