package com.rad.business.service;

import com.rad.persistence.orm.bank.Bank;

import java.util.logging.Logger;


public class BankService {

    public void  printBank(Bank bank){
        final Logger logger = Logger.getLogger(String.valueOf(Bank.class));
        for (int i = 0; i <bank.getRepeated() ; i++) {
            logger.info(bank.getId() +"***"+bank.getName()+"***"+Thread.currentThread().getName());
        }

    }
}
