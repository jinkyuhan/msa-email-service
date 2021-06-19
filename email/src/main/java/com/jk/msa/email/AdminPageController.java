package com.jk.msa.email;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/page/admin")
public class AdminPageController {

	@GetMapping
	public String renderIndex() {
		return "index";
	}
	
}
