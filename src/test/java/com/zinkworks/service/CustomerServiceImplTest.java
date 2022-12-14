package com.zinkworks.service;

import com.zinkworks.enums.RequestType;
import com.zinkworks.exceptions.AccountNotValidatedException;
import com.zinkworks.model.CustomerAccount;
import com.zinkworks.repository.CustomerAccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerAccountRepository mockCustomerAccountRepository;

    @Mock
    private StatisticsService mockStatisticsService;

    @Test
    public void testIsValidCustomer() throws AccountNotValidatedException {
        Mockito.when(mockCustomerAccountRepository.getCustomerAccount(1, 2)).thenReturn(new CustomerAccount("accountNumber", 1,2d, 3d));

        customerService.isValidCustomer(1, 2, RequestType.Balance);

        Mockito.verify(mockCustomerAccountRepository).getCustomerAccount(Mockito.eq(1), Mockito.eq(2));
        Mockito.verifyNoMoreInteractions(mockCustomerAccountRepository, mockStatisticsService);
    }

    @Test
    public void testIsValidCustomerWhenCustomerAccountIsNullGotBillingequest() {
        Mockito.when(mockCustomerAccountRepository.getCustomerAccount(1, 2)).thenReturn(null);

        try{
            customerService.isValidCustomer(1, 2, RequestType.Balance);
        } catch (AccountNotValidatedException e) {
            assertEquals("Invalid Customer with Account Number [1]", e.getMessage());
        }
        Mockito.verify(mockStatisticsService).addBalanceLoginFailure(Mockito.eq(1));
        Mockito.verifyNoMoreInteractions(mockCustomerAccountRepository, mockStatisticsService);
    }

    @Test
    public void testIsValidCustomerWhenCustomerAccountIsNullForWithdrawalRequest() {
        Mockito.when(mockCustomerAccountRepository.getCustomerAccount(1, 2)).thenReturn(null);

        try{
            customerService.isValidCustomer(1, 2, RequestType.Withdrawal);
        } catch (AccountNotValidatedException e) {
            assertEquals("Invalid Customer with Account Number [1]", e.getMessage());
        }
        Mockito.verify(mockStatisticsService).addWithdrawalFailure(Mockito.eq(1d));
        Mockito.verifyNoMoreInteractions(mockCustomerAccountRepository, mockStatisticsService);
    }

}
