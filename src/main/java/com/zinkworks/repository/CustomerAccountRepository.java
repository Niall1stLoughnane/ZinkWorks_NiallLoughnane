/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class this is a repository for interactions with customer accounts
 **/

package com.zinkworks.repository;

import com.zinkworks.model.CustomerAccount;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerAccountRepository {

    private Map<String, CustomerAccount> customerAccountList = new HashMap<>();

    @PostConstruct
    void initialize() {
        customerAccountList.put("123456789_1234", new CustomerAccount("123456789_1234", 1234, 800d, 200d));
        customerAccountList.put("987654321_4321", new CustomerAccount("987654321_4321", 4321, 1230d,   150d));
    }

    public CustomerAccount getCustomerAccount(Integer accountNumber, Integer pin) {
        return this.customerAccountList.get(accountNumber + "_" + pin);
    }

    public void withDrawAmount(CustomerAccount customerAccount, double withDrawAmount) {

        if (customerAccount.getBalance() < withDrawAmount) {
            customerAccount.setOverDraft(withDrawAmount - customerAccount.getBalance());
            customerAccount.setBalance(0d);
        } else {
            customerAccount.setBalance(customerAccount.getBalance() - withDrawAmount);
        }

        this.customerAccountList.put(customerAccount.getAccountNumber(), customerAccount);
    }
}
