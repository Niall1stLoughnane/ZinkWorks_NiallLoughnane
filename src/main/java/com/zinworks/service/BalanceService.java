package com.zinworks.service;

import com.zinworks.model.Balance;

public interface BalanceService {

    Balance getBalanceDetails(Integer accountNumber, Integer pin);

}
