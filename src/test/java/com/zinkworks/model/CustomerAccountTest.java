package com.zinkworks.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CustomerAccountTest {

    @DisplayName("Test - DispensedAmountTest - testConstructor")
    @Test
    public void testConstructor() {
        CustomerAccount customerAccount = new CustomerAccount("n", 1, 2d, 3d);

        assertEquals(2  , customerAccount.getBalance());
        assertEquals("n", customerAccount.getAccountNumber());
        assertEquals(3, customerAccount.getOverDraft());
        assertEquals(1, customerAccount.getPin());
    }

    @DisplayName("Test - DispensedAmountTest - testData_EqualsAndHashCode")
    @Test
    public void testData_EqualsAndHashCode(){
        CustomerAccount customerAccount = new CustomerAccount("n", 1, 2d, 3d);

        assertEquals(customerAccount, customerAccount);
        assertEquals(customerAccount.hashCode(), customerAccount.hashCode());

        CustomerAccount customerAccount2 = new CustomerAccount("s", 21, 24d, 13d);

        assertNotEquals(customerAccount, customerAccount2);
        assertNotEquals(customerAccount.hashCode(), customerAccount2.hashCode());
    }

    @DisplayName("Test - DispensedAmountTest - testData_GettersAndSetters")
    @Test
    public void testData_GettersAndSetters(){
        CustomerAccount customerAccount = new CustomerAccount("n", 1, 2d, 3d);

        assertEquals(2  , customerAccount.getBalance());
        assertEquals("n", customerAccount.getAccountNumber());
        assertEquals(3, customerAccount.getOverDraft());
        assertEquals(1, customerAccount.getPin());

        customerAccount.setBalance(323d);
        customerAccount.setAccountNumber("9");
        customerAccount.setPin(232);
        customerAccount.setOverDraft(243d);

        assertEquals(323  , customerAccount.getBalance());
        assertEquals("9", customerAccount.getAccountNumber());
        assertEquals(243, customerAccount.getOverDraft());
        assertEquals(232, customerAccount.getPin());
    }


}
