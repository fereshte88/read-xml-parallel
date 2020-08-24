package com.rad.persistence.orm.bank;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "bank")
@XmlType(propOrder = {"id","name","repeated"})
public class Bank {

    private Long id;
    private String name;
    private Integer threadPool;
    private Integer repeated;



    public Bank() {
    }

    public Bank(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public Integer getThreadPool() {
        return threadPool;
    }
    @XmlAttribute
    public void setThreadPool(Integer threadPool) {
        this.threadPool = threadPool;
    }

    public Integer getRepeated() {
        return repeated;
    }
    @XmlElement
    public void setRepeated(Integer repeated) {
        this.repeated = repeated;
    }
}
