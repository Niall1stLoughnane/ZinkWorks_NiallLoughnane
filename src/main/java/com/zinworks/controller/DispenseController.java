package com.zinworks.controller;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.DispensedAmount;
import com.zinworks.service.DispenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.zip.ZipException;

@RestController
public class DispenseController {

    @Autowired
    private DispenseService dispenseService;

    @DeleteMapping("/dispenseAccount")
    public DispensedAmount getAccount(@RequestParam(name="accountNumber") String accountNumber, @RequestParam(name="pin") String pin, @RequestParam(name="amountRequested") double amountRequested) throws ZinWorksExeption, ZipException {
        return dispenseService.dispense(accountNumber, pin, amountRequested);
    }



}
