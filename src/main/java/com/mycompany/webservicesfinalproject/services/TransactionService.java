package com.mycompany.webservicesfinalproject.services;

import com.mycompany.webservicesfinalproject.databases.Database;
import com.mycompany.webservicesfinalproject.models.Account;
import com.mycompany.webservicesfinalproject.models.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class TransactionService {
    
    private List<Transaction> tlist;
    private List<Account> alist;
    
    // get all transactions by an account id
    public List<Transaction> getAllTransactions(int cusId, int accId) {
        tlist = new Database().getAccountTransactionsDB(cusId, accId);
        return tlist;
    }
    
    //get a transaction by customer id, account id & transaction id
    public Transaction getTransactionByID(int cusId, int accId, int transId) {
        tlist = new Database().getAccountTransactionsDB(cusId, accId);
        return tlist.get(transId-1);
    }


//lodgement - POST request
    public Transaction createLodgement(Transaction t, int cusId, int accId) {
        tlist = new Database().getAccountTransactionsDB(cusId, accId);
        
        // Checks if the account has been created without any transactions
        //and creates a new list it if has;
        if(tlist==null)
            tlist = (createTransactionList(tlist, cusId, accId));
        
        t.setId(tlist.size() + 1);
        try {
            updateBalance(t, cusId, accId);
        } catch (InsufficientFundsException e) {
            System.out.println("Insufficient funds exception thrown, which is bizarre because this is a lodgment");
            return null;
        }
        tlist.add(t);
        System.out.println("201 - resource created with path: /transactions/" + String.valueOf(t.getId()));
        return t;

    }
    
    
  //withdraw - POST request
    
    public Transaction createWithdrawal(Transaction t, int cusId, int accId) {
        tlist = new Database().getAccountTransactionsDB(cusId, accId);
         // Checks if the account has been created without any transactions
        //and creates a new list it if has;
        if(tlist==null)
            tlist = (createTransactionList(tlist, cusId, accId));
        t.setId(tlist.size() + 1);
        
        try {
            updateBalance(t, cusId, accId);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            return null;
        }
       
        tlist.add(t);
        System.out.println("201 - resource created with path: /transactions/" + String.valueOf(t.getId()));
        return t;

    }
    // This method accepts a Transaction with a type "debit" and a description "transfer"
    // Once the createWithdrawal method has been successfully called on the account that 
    // is the source of the funds, a transaction is created for the same amount but with 
    // a type "credit". This is then passed to createLodgement method.
    public Transaction createTransfer(Transaction t, int destinationAccId, int cusId, int sourceAccId){
            createWithdrawal(t, cusId, sourceAccId);
            Transaction tForLodgement = t;
            t.setType("credit");
            createLodgement(tForLodgement, cusId, destinationAccId);
            t.setType("debit");
            return t;

    }

    
    
  // Helper method to update the balance of an account that has had a tranaction applied  
 // This method also checks if the account has sufficient funds for a given transaction
    private void updateBalance(Transaction t, int cusId, int accId) throws InsufficientFundsException {
        alist = new Database().getCustomerAccountsDB(cusId);
        Account a = alist.get(accId - 1);
        double currentBalance = a.getBalance();
        if(Math.abs(t.getAmount())>currentBalance && t.getType().equalsIgnoreCase("debit")) {
            throw new InsufficientFundsException("You have insufficient funds for this transaction");
        }
        double transactionAmount = t.getAmount();
        if (t.getType().equalsIgnoreCase("debit")) {
            transactionAmount = (t.getAmount() *(-1));
        } 
        double newBalance = currentBalance + transactionAmount;
        a.setBalance(newBalance);
    }
    


    
// Helper methods creates an empty arrayList for transactions if 
// an account does not already have one
private List createTransactionList(List tlist, int cusId, int accId) {
        tlist = new ArrayList<>();
        alist = new Database().getCustomerAccountsDB(cusId);
        Account a = alist.get(accId - 1);
        a.setTransaction(tlist);
        return tlist;
    }

    
// An exception class in the event there are insufficient funds to withdraw  
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message){
        super(message);
    }
}
}
