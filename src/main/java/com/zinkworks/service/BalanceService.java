package com.zinkworks.service;

import com.zinkworks.model.Balance;

public interface BalanceService {

    Balance getBalanceDetails(Integer accountNumber, Integer pin);

}
