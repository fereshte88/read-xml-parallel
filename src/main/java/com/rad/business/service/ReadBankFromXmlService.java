package com.rad.business.service;

import com.rad.persistence.orm.bank.Bank;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ReadBankFromXmlService {

    public void  printBank(Bank bank){
        BasicConfigurator.configure();
        final Logger logger = LogManager.getLogger(Bank.class);
        ExecutorService executor = Executors.newFixedThreadPool(bank.getThreadPool());
        for (int i = 0; i <bank.getRepeated() ; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    logger.info(bank.getId() +"***"+bank.getName()+"***"+Thread.currentThread().getName());
                }
            });

        }

    }
}
