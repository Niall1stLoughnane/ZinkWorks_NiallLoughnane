package com.zinworks.model;

import lombok.Data;

@Data
public class Notes {

    private int quantity50;
    private int quantity20;
    private int quantity10;
    private int quantity5;
    private double value;

    public void initiailze() {
        this.quantity50 = 10;
        this.quantity20 = 30;
        this.quantity10 = 30;
        this.quantity5 = 20;
    }

    public Notes getCurrentNotes() {
        Notes currentNotes = new Notes();
        currentNotes.setQuantity50(this.quantity50);
        currentNotes.setQuantity20(this.quantity20);
        currentNotes.setQuantity10(this.quantity10);
        currentNotes.setQuantity5(this.quantity5);
        return currentNotes;
    }

    public void setCurrentNotes(Notes notes) {
        this.setQuantity50(notes.quantity50);
        this.setQuantity20(notes.quantity20);
        this.setQuantity10(notes.quantity10);
        this.setQuantity5(notes.quantity5);
    }

    public void setValue(double value) {
        this.value = value;
    }
}
