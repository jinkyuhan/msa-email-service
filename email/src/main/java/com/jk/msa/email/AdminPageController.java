package com.jk.msa.email;

import com.jk.msa.email.mail.entity.Mail;
import com.jk.msa.email.mail.service.MailSearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
