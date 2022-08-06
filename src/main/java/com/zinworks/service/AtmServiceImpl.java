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
    public void updateAtm(double amount) {
        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), Double.toString(amount), "Updating ATM with details["+ amount + "]");
        double balance = atmRepository.getBalance() - amount;
        Notes notesDispensed = NotesUtil.getNotes(amount);
        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), Double.toString(balance), "Balance in ATM ["+ balance + "]");
        atmRepository.updateBalanceAndNotes(balance, notesDispensed);
    }

    @Override
    public Double getBalance() {
        return atmRepository.getBalance();
    }
}
