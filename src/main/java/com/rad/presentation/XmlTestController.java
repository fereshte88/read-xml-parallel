package com.rad.presentation;

import com.rad.business.service.BankService;
import com.rad.business.service.XmlTestService;
import com.rad.persistence.orm.bank.Bank;
import com.rad.persistence.orm.bank.Banks;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class XmlTestController {
    public static void main(String[] args) throws JAXBException, IOException {
        XmlTestService xmlTestService = new XmlTestService();
        final BankService bankService = new BankService();
        xmlTestService.marshal();
        Banks banks = xmlTestService.unmarshall();
        for (final Bank bank : banks.getBanks()) {
            ExecutorService executor = Executors.newFixedThreadPool(bank.getThreadPool());
            executor.submit(new Runnable() {
                public void run() {
                    bankService.printBank(bank);
                }
            });


        }
    }
}
