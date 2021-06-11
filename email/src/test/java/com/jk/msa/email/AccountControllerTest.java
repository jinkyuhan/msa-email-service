package com.jk.msa.email;

import com.jk.msa.email.account.AccountController;
import com.jk.msa.email.account.entity.Account;
import com.jk.msa.email.common.CommonResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountControllerTest {

	@Autowired
	private AccountController accountController;
	
	@Test
	public void testGetAccountsByEmail() {
		CommonResponse<Account> response = accountController.getAccountByEmail("hjg0911@naver.com");
	}
}
