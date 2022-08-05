package com.zinworks.repository;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserAccountRepositoryTest {

    @DisplayName("Test - UserAccountRepositoryTest - testInitialize")
    @Test
    public void testInitialize() throws ZinWorksExeption {
        UserAccountRepository userAccountRepository = new UserAccountRepository();
        userAccountRepository.initialize();

        Account account = userAccountRepository.getAccount("123456789", "1234 800", true);
        assertEquals(200, account.getBalance());
        assertEquals("1234 800", account.getPin());
        assertEquals("123456789", account.getAccountNumber());

        account = userAccountRepository.getAccount("987654321", "4321 1230", true);
        assertEquals(150, account.getBalance());
        assertEquals("4321 1230", account.getPin());
        assertEquals("987654321", account.getAccountNumber());

        try {
            userAccountRepository.getAccount("nonExistentAccountNumber", "pin", true);
        } catch (ZinWorksExeption e) {
            assertEquals("Account Doest exist: nonExistentAccountNumber", e.getMessage());
        }
    }

    @DisplayName("Test - UserAccountRepositoryTest - testUpdateAccount")
    @Test
    public void testUpdateAccount() {
        UserAccountRepository userAccountRepository = new UserAccountRepository();
        userAccountRepository.initialize();
        Account mockAccount = Mockito.mock(Account.class);
        when(mockAccount.getAccountNumber()).thenReturn("123456789");
        when(mockAccount.getPin()).thenReturn("1234 800");

        userAccountRepository.updateAccount(mockAccount);
    }

}
