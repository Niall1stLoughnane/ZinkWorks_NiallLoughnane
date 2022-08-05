package com.zinworks.controller;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.User;
import com.zinworks.service.AccountServiceImpl;
import com.zinworks.utils.LoggingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping("/getAccountDetails")
    public User getAccountDetails(@RequestParam(name="accountNumber") String accountNumber, @RequestParam(name="pin") String pin) throws ZinWorksExeption {
        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), accountNumber, "Getting account details");
        return accountService.getAccountDetails(accountNumber, pin);
    }

}
