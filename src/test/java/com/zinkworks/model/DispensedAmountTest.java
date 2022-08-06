package com.zinkworks.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DispensedAmountTest {

    private CustomerAccount customerAccount = Mockito.mock(CustomerAccount.class)l;

    @DisplayName("Test - DispensedAmountTest - testConstructor")
    @Test
    public void testConstructor() {
        DispensedAmount dispensedAmount = new DispensedAmount(935d, new CustomerAccount(P"accountNumber", 123, 23223, ));

        assertEquals(935d, dispensedAmount.getDispensedAmount());
        assertEquals(18, dispensedAmount.getQuantity50());
        assertEquals(1, dispensedAmount.getQuantity20());
        assertEquals(1, dispensedAmount.getQuantity10());
        assertEquals(1, dispensedAmount.getQuantity5());
    }

    @DisplayName("Test - DispensedAmountTest - testData_EqualsAndHashCode")
    @Test
    public void testData_EqualsAndHashCode(){
        DispensedAmount dispensedAmount = new DispensedAmount(935d);

        assertEquals(dispensedAmount, dispensedAmount);
        assertEquals(dispensedAmount.hashCode(), dispensedAmount.hashCode());

        DispensedAmount dispensedAmount2 = new DispensedAmount(93235d);

        assertNotEquals(dispensedAmount, dispensedAmount2);
        assertNotEquals(dispensedAmount.hashCode(), dispensedAmount2.hashCode());
    }

    @DisplayName("Test - DispensedAmountTest - testData_GettersAndSetters")
    @Test
    public void testData_GettersAndSetters(){
        DispensedAmount dispensedAmount = new DispensedAmount(935d);

        assertEquals(935d, dispensedAmount.getDispensedAmount());
        assertEquals(18, dispensedAmount.getQuantity50());
        assertEquals(1, dispensedAmount.getQuantity20());
        assertEquals(1, dispensedAmount.getQuantity10());
        assertEquals(1, dispensedAmount.getQuantity5());

        dispensedAmount.setDispensedAmount(33);
        dispensedAmount.setQuantity50(12);
        dispensedAmount.setQuantity20(23);
        dispensedAmount.setQuantity10(34);
        dispensedAmount.setQuantity5(45);

        assertEquals(33d, dispensedAmount.getDispensedAmount());
        assertEquals(12, dispensedAmount.getQuantity50());
        assertEquals(23, dispensedAmount.getQuantity20());
        assertEquals(34, dispensedAmount.getQuantity10());
        assertEquals(45, dispensedAmount.getQuantity5());
    }

}
