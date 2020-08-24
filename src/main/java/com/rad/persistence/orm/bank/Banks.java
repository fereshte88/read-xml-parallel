package com.rad.persistence.orm.bank;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "banks")
@XmlAccessorType(XmlAccessType.FIELD)
public class Banks {

    @XmlElement(name = "bank")
    private List<Bank> banks = new ArrayList<Bank>();

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }
}
