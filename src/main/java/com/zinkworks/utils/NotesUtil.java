/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class is a utility class for processing notes
 **/

package com.zinkworks.utils;

import com.zinkworks.model.IndividualNotes;
import com.zinkworks.model.Notes;

public final class NotesUtil {

    private NotesUtil(){}

    public static Notes getNotes(double amount) {
        Notes notes = new Notes();
        IndividualNotes individualNotes = new IndividualNotes();
        individualNotes = getNotesIndividual(amount, 50, individualNotes);
        notes.setQuantity50(individualNotes.getQuantiy());
        individualNotes = getNotesIndividual(individualNotes.getLeftOver(), 20, individualNotes);
        notes.setQuantity20(individualNotes.getQuantiy());
        individualNotes = getNotesIndividual(individualNotes.getLeftOver(), 10, individualNotes);
        notes.setQuantity10(individualNotes.getQuantiy());
        individualNotes = getNotesIndividual(individualNotes.getLeftOver(), 5, individualNotes);
        notes.setQuantity5(individualNotes.getQuantiy());
        return notes;
    }

    private static IndividualNotes getNotesIndividual(double amount, int value, IndividualNotes individualNotes) {
        int quantity = ((int)amount / value);
        individualNotes.setQuantiy(quantity);
        individualNotes.setLeftOver(amount - (quantity * value));
        return individualNotes;
    }

}
