package com.zinkworks.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

    @DisplayName("Test - IndividualNotesTest - testData_EqualsAndHashCode")
    @Test
    public void testData_EqualsAndHashCode(){
        IndividualNotes individualNotes = new IndividualNotes();

        assertEquals(individualNotes, individualNotes);
        assertEquals(individualNotes.hashCode(), individualNotes.hashCode());

        IndividualNotes individualNotes2 = new IndividualNotes();
        individualNotes2.setQuantiy(1);
        individualNotes2.setLeftOver(2);

        assertNotEquals(individualNotes, individualNotes2);
        assertNotEquals(individualNotes.hashCode(), individualNotes2.hashCode());
    }

    @DisplayName("Test - IndividualNotesTest - testData_GettersAndSetters")
    @Test
    public void testData_GettersAndSetters(){
        IndividualNotes individualNotes = new IndividualNotes();

        assertEquals(0, individualNotes.getQuantiy());
        assertEquals(0, individualNotes.getLeftOver());

        individualNotes.setQuantiy(11);
        individualNotes.setLeftOver(22);

        assertEquals(11, individualNotes.getQuantiy());
        assertEquals(22, individualNotes.getLeftOver());
    }

}
