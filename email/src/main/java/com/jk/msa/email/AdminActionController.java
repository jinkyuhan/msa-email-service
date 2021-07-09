package com.jk.msa.email;

import com.jk.msa.email.account.dto.AuthPrepareDto;
import com.jk.msa.email.account.service.AccountAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin/action")
public class AdminActionController {

    @Autowired
    private AccountAuthService accountAuthService;

    @PostMapping("/account/send-auth")
    public String sendAuthMailAction(@ModelAttribute AuthPrepareDto formData) {
        System.out.println(formData.getUserId());
        System.out.println(formData.getEmailAddress());
        return "";
    }

}
