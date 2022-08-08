/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class
 **/

package com.zinkworks.service;

import com.zinkworks.model.Balance;

public interface BalanceService {

    Balance getBalanceDetails(Integer accountNumber, Integer pin);

}
