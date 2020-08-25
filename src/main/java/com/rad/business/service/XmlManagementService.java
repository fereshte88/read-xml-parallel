package com.rad.business.service;

import com.rad.persistence.orm.bank.Bank;
import com.rad.persistence.orm.bank.Banks;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.Properties;

public class XmlManagementService {
    public void marshal() throws Exception {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        InputStream input = new FileInputStream(rootPath+"setting.properties");
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
        Banks bankList = new Banks();

        for (int i = 1; i < Integer.valueOf(prop.getProperty("Banklist_Size")) ; i++) {
            Bank bank = new Bank();
            bank.setId((long) (i));
            bank.setName("Bank"+i);
            if(i==Integer.valueOf(prop.getProperty("Threadpool_Size"))){
                bank.setThreadPool(Integer.valueOf(prop.getProperty("Threadpool_Size")));
            }else {
                bank.setThreadPool(1);
            }
            bank.setRepeated(Integer.valueOf(prop.getProperty("Print_Count")));
            bankList.getBanks().add(bank);
        }


        JAXBContext context = JAXBContext.newInstance(Banks.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(bankList, new File("./bank.xml"));
    }

    public Banks unmarshall() throws Exception {
        JAXBContext context = JAXBContext.newInstance(Banks.class);
        FileReader file = new FileReader("./bank.xml");
        if(file.read() == -1){
            throw new Exception("xml file is empty");
        }
        return  (Banks) context.createUnmarshaller().unmarshal(new FileReader("./bank.xml"));
    }
}
