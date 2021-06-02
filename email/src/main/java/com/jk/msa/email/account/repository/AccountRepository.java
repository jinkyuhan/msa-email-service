package com.jk.msa.email.account.repository;

import java.util.List;
import java.util.Optional;

import com.jk.msa.email.account.entity.Account;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD:email/src/main/java/com/jk/msa/email/account/repository/AccountRepository.java
import org.springframework.stereotype.Repository;
=======
>>>>>>> b6392a8f459b5f1778a26f5f31822f0486a20d27:email/src/main/java/com/jk/msa/email/account/AccountRepository.java

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

<<<<<<< HEAD:email/src/main/java/com/jk/msa/email/account/repository/AccountRepository.java
  public <T> List<T> findBy(Class<T> projectionClass);

  public List<Account> findAllByUserId(String userId);
=======
  public Optional<List<Account>> findAllByUserId(String userId);
>>>>>>> b6392a8f459b5f1778a26f5f31822f0486a20d27:email/src/main/java/com/jk/msa/email/account/AccountRepository.java

  public Account findByMailAddress(String emailAddress);
}
