package com.mycompany.webservicesfinalproject.models;

import java.util.List;

/**
 * @author User
 */

public class Account {
    private int id;
    private int sortCode;
    private int accNo;
    private double balance;
    public List<Transaction> transactions;
    
    public Account(){
    }
    
    public Account(int id, int sortCode, int accNo, double balance, List<Transaction> transactions){
        this.id = id;
        this.sortCode = sortCode;
        this.accNo = accNo;
        this.balance = balance;
        this.transactions = transactions;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getSort() {
        return sortCode;
    }

    public void setSort(int sortCode) {
        this.sortCode = sortCode;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransaction() {
        return transactions;
    }

    public void setTransaction(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    
    
    
    
}
