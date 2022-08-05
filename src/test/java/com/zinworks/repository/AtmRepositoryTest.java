package com.zinworks.repository;

import com.zinworks.model.Notes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtmRepositoryTest {

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
}
