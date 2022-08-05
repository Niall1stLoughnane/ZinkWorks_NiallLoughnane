package com.zinworks.validation;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserAccountValidatorTest {

    @DisplayName("Test - UserAccountValidatorTest - testUserAccountValidatorWhenPinSame")
    @Test
    public void testUserAccountValidatorWhenPinSame() throws ZinWorksExeption {
        Account mockAccount = Mockito.mock(Account.class);
        when(mockAccount.getPin()).thenReturn("pinSame");

        UserAccountValidator.vaidateAccount(mockAccount, "pinSame");

        verify(mockAccount).getPin();
    }

    @DisplayName("Test - UserAccountValidatorTest - testUserAccountValidatorWhenPinDifferent")
    @Test
    public void testUserAccountValidatorWhenPinDifferent() throws ZinWorksExeption {
        Account mockAccount = Mockito.mock(Account.class);
        when(mockAccount.getPin()).thenReturn("pinDifferent");

        try {
            UserAccountValidator.vaidateAccount(mockAccount, "pinSame");
        } catch (ZinWorksExeption e) {
            assertEquals("account not validated", e.getMessage());
        }

        verify(mockAccount).getPin();
    }
}
