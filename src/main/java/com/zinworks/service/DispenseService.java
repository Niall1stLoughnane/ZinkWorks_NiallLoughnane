package com.zinworks.service;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.DispensedAmount;

public interface DispenseService {

    public DispensedAmount dispense(String accountNumber, String pin, double amountRequested) throws ZinWorksExeption;


}
