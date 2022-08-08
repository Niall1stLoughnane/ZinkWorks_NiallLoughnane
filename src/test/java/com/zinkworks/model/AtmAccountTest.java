package com.zinkworks.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AtmAccountTest {



    @DisplayName("Test - AtmAccountTest - testUpdateBalanceAndNotes")
    @Test
    public void testUpdateBalanceAndNotes() {
        AtmAccount atmAccount = new AtmAccount();
        atmAccount.initialize();

        assertEquals(1, atmAccount.getId());
        assertEquals(1500, atmAccount.getBalance());
        assertEquals(10, atmAccount.getNotes().getQuantity50());
        assertEquals(30, atmAccount.getNotes().getQuantity20());
        assertEquals(30, atmAccount.getNotes().getQuantity10());
        assertEquals(20, atmAccount.getNotes().getQuantity5());
        assertEquals(0, atmAccount.getNotes().getValue());

        Notes notes = new Notes();
        notes.setQuantity50(2);
        notes.setQuantity20(3);
        notes.setQuantity10(1);
        notes.setQuantity5(5);

        atmAccount.updateBalanceAndNotes(40, notes);

        assertEquals(1, atmAccount.getId());
        assertEquals(40, atmAccount.getBalance());
        assertEquals(8, atmAccount.getNotes().getQuantity50());
        assertEquals(27, atmAccount.getNotes().getQuantity20());
        assertEquals(29, atmAccount.getNotes().getQuantity10());
        assertEquals(15, atmAccount.getNotes().getQuantity5());
        assertEquals(0, atmAccount.getNotes().getValue());
    }
}
