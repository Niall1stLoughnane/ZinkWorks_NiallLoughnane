package com.zinworks.service;

import com.zinworks.exceptions.AtmZeroCashExeption;
import com.zinworks.model.Notes;
import com.zinworks.repository.AtmRepository;
import com.zinworks.utils.LoggingUtils;
import com.zinworks.utils.NotesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtmServiceImpl implements AtmService {

    @Autowired
    private AtmRepository atmRepository;

    @Override
    public double getTotalAllowedDispenseAmount(double amount) throws AtmZeroCashExeption {

        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), Double.toString(amount), "Getting total allowed dispensed amount = initial ["+ amount + "]");

        double balance = atmRepository.getBalance();

        if (balance <0 ) {
            LoggingUtils.logMessage("ERROR", this.getClass().getSimpleName(), Double.toString(balance), "Exception thrown as balance in ATM is 0");
            throw new AtmZeroCashExeption("Not enough money in ATM", System.currentTimeMillis());
        }

        double totalAllowedDispenseAmount;

        if (balance < amount) {
            totalAllowedDispenseAmount = balance;
        } else {
            totalAllowedDispenseAmount = amount;
        }

        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), Double.toString(totalAllowedDispenseAmount), "Total Allowed smount is " + totalAllowedDispenseAmount);

        return totalAllowedDispenseAmount;
    }

    @Override
    public void updateAtm(double amount) {
        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), Double.toString(amount), "Updating ATM with details["+ amount + "]");
        double balance = atmRepository.getBalance() - amount;
        Notes notesDispensed = NotesUtil.getNotes(amount);
        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), Double.toString(balance), "Balance in ATM ["+ balance + "]");
        atmRepository.updateBalanceAndNotes(balance, notesDispensed);
    }

}
