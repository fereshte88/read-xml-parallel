package com.rad.business.service;

import com.rad.persistence.orm.bank.Bank;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class ReadBankFromXmlService {

    public void  printBank(Bank bank){
        BasicConfigurator.configure();
        final Logger logger = LogManager.getLogger(Bank.class);
        for (int i = 0; i <bank.getRepeated() ; i++) {
            logger.info(bank.getId() +"***"+bank.getName()+"***"+Thread.currentThread().getName());
        }

    }
}
