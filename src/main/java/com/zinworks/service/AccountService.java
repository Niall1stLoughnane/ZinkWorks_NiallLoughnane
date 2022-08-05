package com.zinworks.service;

import com.zinworks.exceptions.ZinWorksExeption;
import com.zinworks.model.User;

public interface AccountService {

    User getAccountDetails(String accountNumber, String pin) throws ZinWorksExeption;

}
