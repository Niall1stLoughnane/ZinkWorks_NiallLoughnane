/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class
 **/

package com.zinkworks.service;

import com.zinkworks.exceptions.ZinWorksException;
import com.zinkworks.model.DispensedAmount;

public interface DispenseService {

    public DispensedAmount dispense(Integer accountNumber, Integer pin, double amountRequested) throws ZinWorksException;


}
