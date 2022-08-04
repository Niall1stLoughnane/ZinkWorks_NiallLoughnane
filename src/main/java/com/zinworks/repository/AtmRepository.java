package com.zinworks.repository;

import com.zinworks.model.Notes;
import com.zinworks.utils.NotesUtil;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
@Data
public class AtmRepository {

    private double id;
    private double balance;
    private Notes notes;

    @PostConstruct
    public void initialize() {
        this.id = 1d;
        this.balance = 1500d;
        this.notes = new Notes();
        this.notes.initiailze();
    }

    public void updateBalanceAndNotes(double balance, Notes notesDispensed) {
        this.setBalance(balance);

        Notes notes = NotesUtil.getNotes(balance);
        this.notes.setQuantity50(this.notes.getQuantity50() - notesDispensed.getQuantity50());
        this.notes.setQuantity20(this.notes.getQuantity20() - notesDispensed.getQuantity20());
        this.notes.setQuantity10(this.notes.getQuantity10() - notesDispensed.getQuantity10());
        this.notes.setQuantity5(this.notes.getQuantity5() - notesDispensed.getQuantity5());

    }
}
