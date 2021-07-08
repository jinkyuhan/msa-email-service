package com.jk.msa.email;


import com.jk.msa.email.account.entity.Account;
import com.jk.msa.email.account.service.AccountSearchService;
import com.jk.msa.email.common.SearchOptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/page/admin")
public class AdminPageController {

    @Autowired
    private AccountSearchService accountSearchService;

    @GetMapping("/account")
    public String renderAccountPage(
            Model model,
            @RequestParam(name="page") int pageNum,
            @RequestParam(name="size") int perPage
    ) {
        List<Account> searchedAccounts = accountSearchService.searchWithPagination(
                Optional.empty(),
                PageRequest.of(pageNum, perPage)
        );
        model.addAttribute("accountList", searchedAccounts);
        return "account";
    }

    @GetMapping("/mail")
    public String renderMailPage() {
        return "mail";
    }
}
