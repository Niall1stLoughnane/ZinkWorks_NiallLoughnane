package com.zinkworks.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NotesTest {

    @DisplayName("Test - NotesTest - testConstructor")
    @Test
    public void testConstructor() {
        Notes notes = new Notes();
        notes.initiailze();

        assertEquals(10, notes.getQuantity50());
        assertEquals(30, notes.getQuantity20());
        assertEquals(30, notes.getQuantity10());
        assertEquals(20, notes.getQuantity5());
    }

    @DisplayName("Test - NotesTest - testData_EqualsAndHashCode")
    @Test
    public void testData_EqualsAndHashCode(){
        Notes notes = new Notes();
        notes.initiailze();

        assertEquals(notes, notes);
        assertEquals(notes.hashCode(), notes.hashCode());

        Notes notes2 = new Notes();
        notes2.initiailze();
        notes2.setQuantity50(11);
        notes2.setQuantity20(22);
        notes2.setQuantity10(22);
        notes2.setQuantity5(22);

        assertNotEquals(notes, notes2);
        assertNotEquals(notes.hashCode(), notes2.hashCode());
    }

    @DisplayName("Test - NotesTest - testData_GettersAndSetters")
    @Test
    public void testData_GettersAndSetters(){
        Notes notes = new Notes();
        notes.initiailze();

        assertEquals(10, notes.getQuantity50());
        assertEquals(30, notes.getQuantity20());
        assertEquals(30, notes.getQuantity10());
        assertEquals(20, notes.getQuantity5());

        notes.setQuantity50(11);
        notes.setQuantity20(44);
        notes.setQuantity10(33);
        notes.setQuantity5(22);

        assertEquals(11, notes.getQuantity50());
        assertEquals(44, notes.getQuantity20());
        assertEquals(33, notes.getQuantity10());
        assertEquals(22, notes.getQuantity5());
    }
}
