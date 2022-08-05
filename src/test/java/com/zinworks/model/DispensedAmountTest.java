package com.zinworks.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DispensedAmountTest {

    @DisplayName("Test - DispensedAmountTest - testConstructor")
    @Test
    public void testConstructor() {
        DispensedAmount dispensedAmount = new DispensedAmount(935d);

        assertEquals(935d, dispensedAmount.getDispensedAmount());
        assertEquals(18, dispensedAmount.getQuantity50());
        assertEquals(1, dispensedAmount.getQuantity20());
        assertEquals(1, dispensedAmount.getQuantity10());
        assertEquals(1, dispensedAmount.getQuantity5());
    }
}
