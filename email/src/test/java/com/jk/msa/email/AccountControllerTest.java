package com.jk.msa.email;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.jk.msa.email.account.AccountController;
import com.jk.msa.email.account.dto.IsAuthResultDto;
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
		// CommonResponse<Account> response = accountController.getAccountByEmail("hjg0911@naver.com");
	}

	@Test
	public void testCheckAuthentication() {
		CommonResponse<IsAuthResultDto> response = accountController.isAuthenticatedAccount(
			"testUserId", 
			"hjg0911@naver.com", 
			String.valueOf(Timestamp.valueOf(LocalDateTime.now()).getTime())
		);
		assertEquals(null, response);
	}
}
