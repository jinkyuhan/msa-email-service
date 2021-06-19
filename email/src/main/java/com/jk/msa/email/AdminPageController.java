package com.jk.msa.email;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/page/admin")
public class AdminPageController {

	@GetMapping("/account")
	public String renderAccountPage() {
		return "account";
	}

	@GetMapping("/mail")
	public String renderMailPage() {
		return "mail";
	}
	
}
