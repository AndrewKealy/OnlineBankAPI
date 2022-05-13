package com.mycompany.webservicesfinalproject.services;

import com.mycompany.webservicesfinalproject.databases.Database;
import com.mycompany.webservicesfinalproject.models.Account;
import java.util.List;
import javax.ws.rs.PathParam;

/**
 * @author User
 */

public class AccountService {
       
    
    private List<Account> alist;
    
    //get all accounts by a customer id
    public List<Account> getCustomerAccounts(int id) {
        alist = new Database().getCustomerAccountsDB(id);
        return alist;
    }
    
    //get an account by customer id (cId)and account id (id)
    public Account getAccountByID(int cId, int id) {
        alist = new Database().getCustomerAccountsDB(cId);
        return alist.get(id-1);
    }
    
        //get an account by customer id (cId)and account id (id)
    public String getAccountBalanceByID(int cId, int id) {
        alist = new Database().getCustomerAccountsDB(cId);
        String balance = "Balance for account " + id + " with account number " + alist.get(id-1).getAccNo() + " is  " + alist.get(id-1).getBalance();
        return balance;
    }
    
    public Account createAccount(Account a, int id){
        alist = new Database().getCustomerAccountsDB(id);
        a.setId(alist.size() + 1);
	alist.add(a);
	System.out.println("201 - resource created with path: /accounts/" + String.valueOf(a.getId()));
	return a;
        
    }
}