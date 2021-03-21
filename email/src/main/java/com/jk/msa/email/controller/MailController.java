package com.jk.msa.email;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/mail")
public class MailController {

  @GetMapping(path = "/")
  public String checkHealth() {
    return "I am mail";
  }
}
