package com.zinkworks.controller;

import com.zinkworks.service.BalanceService;
import com.zinkworks.service.CustomerService;
import com.zinkworks.service.DispenseServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerControllerTest {

    CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @Mock
    private BalanceService balanceService;

    @Mock
    private DispenseServiceImpl dispenseService;

    @Test
    public void test() {
        CustomerController customerController = new CustomerController();

    }
}
