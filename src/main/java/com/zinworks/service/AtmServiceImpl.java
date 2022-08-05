package com.zinworks.service;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.Notes;
import com.zinworks.repository.AtmRepository;
import com.zinworks.utils.NotesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtmServiceImpl implements AtmService {

    @Autowired
    private AtmRepository atmRepository;

    @Override
    public double getTotalAllowedDispenseAmount(double amount) throws ZinWorksExeption {
        double balance = atmRepository.getBalance();

        if (balance <0 ) {
            throw new ZinWorksExeption("Not enough money in ATM");
        }

        if (balance < amount) {
            return balance;
        } else {
            return amount;
        }
    }

    @Override
    public void updateAtm(double amount) {
        double balance = atmRepository.getBalance() - amount;
        Notes notesDispensed = NotesUtil.getNotes(amount);
        atmRepository.updateBalanceAndNotes(balance, notesDispensed);
    }

}
