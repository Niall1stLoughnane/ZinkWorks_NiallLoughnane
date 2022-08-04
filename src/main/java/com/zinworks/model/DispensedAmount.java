package com.zinworks.model;

import com.zinworks.utils.NotesUtil;
import lombok.Data;

@Data
public class DispensedAmount {

    private double dispensedAmount;
    private int quantity50;
    private int quantity20;
    private int quantity10;
    private int quantity5;

    public DispensedAmount(double dispensedAmount) {
        Notes notesDispensed = NotesUtil.getNotes(dispensedAmount);

        this.dispensedAmount = dispensedAmount;
        this.quantity50 = notesDispensed.getQuantity50();
        this.quantity20 = notesDispensed.getQuantity20();
        this.quantity10 = notesDispensed.getQuantity10();
        this.quantity5 = notesDispensed.getQuantity5();
    }

}
