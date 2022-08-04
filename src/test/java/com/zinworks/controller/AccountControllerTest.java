package com.zinworks.controller;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.User;
import com.zinworks.service.AccountService;
import com.zinworks.tem.HelloRepository;
import com.zinworks.tem.HelloService;
import com.zinworks.tem.HelloServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AccountControllerTest {

    @Mock
    @InjectMocks // auto inject helloRepository
    private AccountController accountController= new AccountController();

    private AccountService accountService;

    @BeforeEach
    void setMockOutput() throws ZinWorksExeption {
        //when(helloService.get()).thenReturn("Hello Mockito");
        User mockUser = Mockito.mock(User.class);
        when(accountService.getAccountDetails("accuntNumber", "pin")).thenReturn(mockUser);
    }

    @DisplayName("Test Mock helloService + helloRepository")
    @Test
    void testGet() throws ZinWorksExeption {
        assertEquals("Hello Mockito From Responsitory", accountController.getAccount("accountNumber", "pin"));
    }

}
