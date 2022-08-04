package com.zinworks.controller;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.User;
import com.zinworks.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

    @InjectMocks // auto inject helloRepository
    private AccountController accountController= new AccountController();

    @Mock
    private AccountService accountService;

    @BeforeEach
    void setMockOutput() throws ZinWorksExeption {
    }

    @DisplayName("Test getAccountDetails")
    @Test
    void testGet() throws ZinWorksExeption {
        User mockUser = Mockito.mock(User.class);
        when(accountService.getAccountDetails(anyString(), anyString())).thenReturn(mockUser);

        User result = accountController.getAccountDetails("accountNumber", "pin");

        assertEquals(mockUser, result);
        verify(accountService).getAccountDetails(anyString(), anyString());
        verifyNoMoreInteractions(accountService);
        verifyNoInteractions(mockUser);
    }

}
