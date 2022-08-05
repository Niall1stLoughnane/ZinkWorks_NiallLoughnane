package com.zinworks.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotesTest {

    @Test
    public void testConstructor() {
        Notes notes = new Notes();
        notes.initiailze();

        assertEquals(10, notes.getQuantity50());
        assertEquals(30, notes.getQuantity20());
        assertEquals(30, notes.getQuantity10());
        assertEquals(20, notes.getQuantity5());
    }
}
