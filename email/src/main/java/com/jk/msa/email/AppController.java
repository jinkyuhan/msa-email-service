package com.jk.msa.email;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class AppController {

  @GetMapping(value = "/health-check")
  public String checkHealth() {
    return "I'm alive";
  }

	@GetMapping(value = "/api-docs")
	public RedirectView redirectApiDocs() {
		return new RedirectView("swagger-ui.html");
	}
}
