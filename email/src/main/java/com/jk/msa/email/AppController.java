package com.jk.msa.email;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  @GetMapping
  public String checkHealth() {
    return "I'm alive";
  }
}
