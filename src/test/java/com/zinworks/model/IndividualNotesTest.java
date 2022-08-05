package com.zinworks.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndividualNotesTest {

    @DisplayName("Test - IndividualNotesTest - testConstructor")
    @Test
    public void testConstructor() {
        IndividualNotes individualNotes = new IndividualNotes();

        assertEquals(0, individualNotes.getQuantiy());
        assertEquals(0, individualNotes.getLeftOver());

        individualNotes.setQuantiy(16);
        individualNotes.setLeftOver(6);

        assertEquals(16, individualNotes.getQuantiy());
        assertEquals(6, individualNotes.getLeftOver());
    }
}
