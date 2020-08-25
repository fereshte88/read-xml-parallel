package com.rad.presentation;

import com.rad.business.service.ReadBankFromXmlService;
import com.rad.business.service.XmlManagementService;
import com.rad.persistence.orm.bank.Banks;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadBankFromXmlController {
    public static void main(String[] args) throws Exception {
        XmlManagementService xmlManagementService = new XmlManagementService();
        final ReadBankFromXmlService readBankFromXmlService = new ReadBankFromXmlService();
      // xmlManagementService.marshal();
        Banks banks = xmlManagementService.unmarshall();
        if(Objects.isNull(banks)){
            throw new Exception("xml file is empty");
        }
        banks.getBanks().parallelStream().forEach(bank -> {ExecutorService executor = Executors.newFixedThreadPool(bank.getThreadPool());
                                                                                     executor.submit(new Runnable() {
                                                                                        public void run() {
                                                                                            readBankFromXmlService.printBank(bank);
                                                                                        }
                                                                                    });
                                                                                });

    }
}
