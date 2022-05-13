package com.mycompany.webservicesfinalproject.models;

import java.util.List;

/**
 * @author User
 */

public class Customer {
    private int id;
    private String name;
    private String address;
    private String email;
    private int credentials;
    public List<Account> accountsList;
    
    public Customer(){   
    }
    
    public Customer(int id, String name, String address, String email, int credentials, List<Account> listOfAccounts){
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.credentials = credentials;
        this.accountsList = listOfAccounts;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCredentials() {
        return credentials;
    }

    public void setCredentials(int credentials) {
        this.credentials = credentials;
    }

    public List<Account> getAccounts() {
        return accountsList;
    }

    public void setAccounts(List<Account> accountsList) {
        this.accountsList = accountsList;
    }
    
    
    
    
    
    
}
