package com.zinworks.service;

import com.zinworks.exceptions.ZinWorksExeption;

public interface AtmService {

    public double getTotalAllowedDispenseAmount(double amount) throws ZinWorksExeption;

    public void updateAtm(double amount);
}
