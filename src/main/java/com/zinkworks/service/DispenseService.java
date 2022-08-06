package com.zinkworks.service;

import com.zinkworks.exceptions.ZinWorksExeption;
import com.zinkworks.model.DispensedAmount;

public interface DispenseService {

    public DispensedAmount dispense(Integer accountNumber, Integer pin, double amountRequested) throws ZinWorksExeption;


}
