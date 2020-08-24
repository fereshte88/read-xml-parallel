package com.rad.business.service;

import com.rad.persistence.orm.bank.Bank;
import com.rad.persistence.orm.bank.Banks;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class XmlTestService {
    public void marshal() throws JAXBException, IOException {
        Banks bankList = new Banks();

        for (int i = 1; i < 36 ; i++) {
            Bank bank = new Bank();
            bank.setId(Long.valueOf(i));
            bank.setName("Bank"+i);
            if(i==5){
                bank.setThreadPool(5);
            }else {
                bank.setThreadPool(1);
            }
            bank.setRepeated(100);
            bankList.getBanks().add(bank);
        }


        JAXBContext context = JAXBContext.newInstance(Banks.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(bankList, new File("./bank.xml"));
    }

    public Banks unmarshall() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Banks.class);
        Banks banks = (Banks) context.createUnmarshaller().unmarshal(new FileReader("./bank.xml"));

        return banks;
    }
}
