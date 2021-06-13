package com.jk.msa.email;

import com.jk.msa.email.config.ServiceConfig;
import com.jk.msa.email.config.TableNameConfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailApplicationTests {

	@Autowired
	TableNameConfig tableNameConfig;

	@Autowired
	ServiceConfig serviceConfig;



	@Test
	void contextLoads() {
		System.out.println(serviceConfig.getServiceName());
	}

	@Test
	void configLoadsTest() {
		System.out.println()
	}
}
