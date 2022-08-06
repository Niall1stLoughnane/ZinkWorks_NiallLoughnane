package com.zinworks.service;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.DispensedAmount;

public interface DispenseService {

    public DispensedAmount dispense(Integer accountNumber, Integer pin, double amountRequested) throws ZinWorksExeption;


}
