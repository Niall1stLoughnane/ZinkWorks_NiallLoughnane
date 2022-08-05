package com.zinworks.controller;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.DispensedAmount;
import com.zinworks.service.DispenseServiceImpl;
import com.zinworks.utils.LoggingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.zip.ZipException;

@RestController
public class DispenseController {

    @Autowired
    private DispenseServiceImpl dispenseService;

    @DeleteMapping("/dispenseAccount")
    public DispensedAmount dispenseAccount(@RequestParam(name="accountNumber") String accountNumber, @RequestParam(name="pin") String pin, @RequestParam(name="amountRequested") double amountRequested) throws ZinWorksExeption, ZipException {
        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), accountNumber, "Dispensing from account");
        return dispenseService.dispense(accountNumber, pin, amountRequested);
    }


}
