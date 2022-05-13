package com.mycompany.webservicesfinalproject.models;

import java.util.Date;

/**
 * @author User
 */

public class Transaction {
    private int id;
    private String type;
    private String descript;
    private Date created;
    private double amount;
    
    public Transaction(){
    }
    
    public Transaction(int id, String type, String descript, double amount){
        this.id = id;
        this.type = type;
        this.descript = descript;
        this.created = new Date();
        this.amount = amount;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getDescription() {
        return descript;
    }
    
    public void setDescription(String descript) {
        this.descript = descript;
    }

    public Date getCreated() {
        return created;
    }

    public void setDate(Date created) {
        this.created = created;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
