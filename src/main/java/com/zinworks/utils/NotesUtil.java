package com.zinworks.utils;

import com.zinworks.model.Notes;

public class NotesUtil {

    public static Notes getNotes(double amount) {
        Notes notes = new Notes();
        IndividualNotes individualNotes = getNotesIndividual(amount, 50);
        notes.setQuantity50(individualNotes.quantiy);
        individualNotes = getNotesIndividual(individualNotes.leftOver, 20);
        notes.setQuantity20(individualNotes.quantiy);
        individualNotes = getNotesIndividual(individualNotes.leftOver, 10);
        notes.setQuantity10(individualNotes.quantiy);
        individualNotes = getNotesIndividual(individualNotes.leftOver, 5);
        notes.setQuantity5(individualNotes.quantiy);
        return notes;
    }

    private static IndividualNotes getNotesIndividual(double amount, int value) {
        IndividualNotes individualNotes = new IndividualNotes();
        int quantity = ((int)amount / value);
        individualNotes.setQuantiy(quantity);
        individualNotes.setLeftOver(amount - (quantity * value));
        return individualNotes;
    }

    private static class IndividualNotes {

        private int quantiy;
        private double leftOver;

        public int getQuantiy() {
            return quantiy;
        }

        public void setQuantiy(int quantiy) {
            this.quantiy = quantiy;
        }

        public double getLeftOver() {
            return leftOver;
        }

        public void setLeftOver(double leftOver) {
            this.leftOver = leftOver;
        }
    }
}
