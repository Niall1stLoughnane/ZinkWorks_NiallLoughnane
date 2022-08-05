package com.zinworks.utils;

import com.zinworks.model.Notes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotesUtilTest {

    @DisplayName("Test - NotesUtilTest - testNotesUtil")
    @Test
    public void testNotesUtil() {
        Notes notes = NotesUtil.getNotes(235);
        assertEquals(4, notes.getQuantity50());
        assertEquals(1, notes.getQuantity20());
        assertEquals(1, notes.getQuantity10());
        assertEquals(1, notes.getQuantity5());
    }

}
