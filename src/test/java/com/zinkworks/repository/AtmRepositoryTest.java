package com.zinkworks.repository;

import com.zinkworks.model.Notes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtmRepositoryTest {

    @DisplayName("Test - AtmRepositoryTest - testInitialize")
    @Test
    public void testInitialize() {
        AtmRepository atmRepository = new AtmRepository();
        atmRepository.initialize();

        assertEquals(1500d, atmRepository.getBalance());
        assertEquals(1, atmRepository.getId());

        Notes notes = atmRepository.getNotes();

        assertEquals(10, notes.getQuantity50());
        assertEquals(30, notes.getQuantity20());
        assertEquals(30, notes.getQuantity10());
        assertEquals(20, notes.getQuantity5());
    }

    @DisplayName("Test - AtmRepositoryTest - testUpdateBalanceAndNotes")
    @Test
    public void testUpdateBalanceAndNotes() {
        AtmRepository atmRepository = new AtmRepository();
        atmRepository.initialize();

        Notes notesDispensed = new Notes();
        notesDispensed.setQuantity50(3);
        notesDispensed.setQuantity20(2);
        notesDispensed.setQuantity10(1);
        notesDispensed.setQuantity5(8);

        atmRepository.updateBalanceAndNotes(300, notesDispensed);

        assertEquals(300d, atmRepository.getBalance());
        Notes notes = atmRepository.getNotes();
        assertEquals(7, notes.getQuantity50());
        assertEquals(28, notes.getQuantity20());
        assertEquals(29, notes.getQuantity10());
        assertEquals(12, notes.getQuantity5());

    }
}
