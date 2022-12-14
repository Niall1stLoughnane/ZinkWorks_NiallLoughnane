/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class is a model class of an account
 **/

package com.zinkworks.model;

import lombok.Data;

import javax.annotation.PostConstruct;

@Data
public class AtmAccount {

    private double id;
    private double balance;
    private Notes notes;

    @PostConstruct
    void initialize() {
        this.id = 1d;
        this.balance = 1500d;
        this.notes = new Notes();
        this.notes.initiailze();
    }

    public void updateBalanceAndNotes(double balance, Notes notesDispensed) {
        this.setBalance(balance);

        this.notes.setQuantity50(this.notes.getQuantity50() - notesDispensed.getQuantity50());
        this.notes.setQuantity20(this.notes.getQuantity20() - notesDispensed.getQuantity20());
        this.notes.setQuantity10(this.notes.getQuantity10() - notesDispensed.getQuantity10());
        this.notes.setQuantity5(this.notes.getQuantity5() - notesDispensed.getQuantity5());
    }

}
