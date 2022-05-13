package com.mycompany.webservicesfinalproject.databases;

import com.mycompany.webservicesfinalproject.models.Account;
import com.mycompany.webservicesfinalproject.models.Customer;
import com.mycompany.webservicesfinalproject.models.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 * The database is hardcoded with 5 customers using ArrayLists to
 * store the lists of customers, accounts and transactions
 * @author User
 */

public class Database {

        //List of all customers
        public static List<Customer> customerDB = new ArrayList<>();

        //accountDB1 - list of accounts for customer 1
        //accountDB2 - list of accounts for customer 2 etc.
        public static List<Account> accountDB1 = new ArrayList<>();
        public static List<Account> accountDB2 = new ArrayList<>();
        public static List<Account> accountDB3 = new ArrayList<>();
        public static List<Account> accountDB4 = new ArrayList<>();
        public static List<Account> accountDB5 = new ArrayList<>();

        //transactionDB11 - list of transactions on acc 1 for customer 1
        //transactionDB12 - list of transactions on acc 2 for customer 1
        //transactionDB21 - list of transactions on acc 1 for customer 2 etc.
        public static List<Transaction> transactionDB11 = new ArrayList<>();
        public static List<Transaction> transactionDB12 = new ArrayList<>();
        public static List<Transaction> transactionDB21 = new ArrayList<>();
        public static List<Transaction> transactionDB31 = new ArrayList<>();
        public static List<Transaction> transactionDB32 = new ArrayList<>();
        public static List<Transaction> transactionDB33 = new ArrayList<>();
        public static List<Transaction> transactionDB41 = new ArrayList<>();
        public static List<Transaction> transactionDB42 = new ArrayList<>();
        public static List<Transaction> transactionDB51 = new ArrayList<>();

        //c1 has 2 accounts with 3 transactions each
        //c2 has 1 accounts with 1 transaction
        //c3 has 3 accounts with 4,5 & 2 transactions
        //c4 has 2 accounts with 3 & 2 transactions
        //c5 has 1 account with 2 transactions

        public static boolean init = true;

        // Constructor for the class
        public Database () {
            if (init) {
                //create some transactions and them to the DB for each account
                //Transaction(int id, String type, String descript, double amount)

                Transaction t1 = new Transaction(1, "debit", "withdrawal", 1000.00);
                Transaction t2 = new Transaction(2, "debit", "withdrawal", 400.00);
                Transaction t3 = new Transaction(3, "credit", "transfer", 150.00);

                transactionDB11.add(t1);
                transactionDB11.add(t2);
                transactionDB11.add(t3);

                Transaction t4 = new Transaction(1, "credit", "lodgement", 1000.00);
                Transaction t5 = new Transaction(2, "credit", "lodgement", 2000.00);
                Transaction t6 = new Transaction(3, "credit", "lodgement", 3000.00);

                transactionDB12.add(t4);
                transactionDB12.add(t5);
                transactionDB12.add(t6);

                Transaction t7 = new Transaction(1, "debit", "transfer", 9000.00);

                transactionDB21.add(t7);

                Transaction t8 = new Transaction(1, "debit", "withdrawal", 150.00);
                Transaction t9 = new Transaction(1, "debit", "withdrawal", 100.00);
                Transaction t10 = new Transaction(1, "debit", "withdrawal", 200.00);
                Transaction t11 = new Transaction(1, "debit", "withdrawal", 100.00);

                transactionDB31.add(t8);
                transactionDB31.add(t9);
                transactionDB31.add(t10);
                transactionDB31.add(t11);

                Transaction t12 = new Transaction(1, "credit", "transfer", 1000.00);
                Transaction t13 = new Transaction(1, "debit", "withdrawal", 500.00);
                Transaction t14 = new Transaction(1, "credit", "transfer", 2500.00);
                Transaction t15 = new Transaction(1, "credit", "transfer", 2500.00);
                Transaction t16 = new Transaction(1, "credit", "transfer", 5000.00);

                transactionDB32.add(t12);
                transactionDB32.add(t13);
                transactionDB32.add(t14);
                transactionDB32.add(t15);
                transactionDB32.add(t16);

                Transaction t17 = new Transaction(1, "credit", "transfer", 50000.00);
                Transaction t18 = new Transaction(1, "credit", "transfer", 25000.00);

                transactionDB33.add(t17);
                transactionDB33.add(t18);

                Transaction t19 = new Transaction(1, "credit", "lodgement", 600.00);
                Transaction t20 = new Transaction(1, "credit", "lodgement", 600.00);
                Transaction t21 = new Transaction(1, "debit", "withdrawal", 200.00);

                transactionDB41.add(t19);
                transactionDB41.add(t20);
                transactionDB41.add(t21);

                Transaction t22 = new Transaction(1, "credit", "lodgement", 1000.00);
                Transaction t23 = new Transaction(1, "credit", "transfer", 550.00);

                transactionDB42.add(t22);
                transactionDB42.add(t23);

                Transaction t24 = new Transaction(1, "debit", "withdrawal", 100.00);
                Transaction t25 = new Transaction(1, "debit", "withdrawal", 50.00);

                transactionDB51.add(t24);
                transactionDB51.add(t25);

                //create up some accounts and add them to the account Db for each customer
                //Account(int id, int sortCode, int accNo, double balance,
                //                              List<Transaction> transactions)

                Account a1 = new Account(1, 904512, 39482033, 5300.00, transactionDB11);
                Account a2 = new Account(2, 904512, 39486231, 12000.00, transactionDB12);

                accountDB1.add(a1);
                accountDB1.add(a2);

                Account a3 = new Account(1, 902355, 39784334, 15800.00, transactionDB21);

                accountDB2.add(a3);

                Account a4 = new Account(1, 908646, 39356193, 2000.00, transactionDB31);
                Account a5 = new Account(1, 908646, 39826841, 44350.00, transactionDB32);
                Account a6 = new Account(1, 908646, 39201425, 150000.00, transactionDB33);

                accountDB2.add(a3);
                accountDB2.add(a3);
                accountDB2.add(a3);

                Account a7 = new Account(1, 904512, 39557331, 120.00, transactionDB41);
                Account a8 = new Account(1, 904512, 39903261, 1250.00, transactionDB42);

                accountDB2.add(a3);
                accountDB2.add(a3);

                Account a9 = new Account(1, 904334, 39676245, 50.00, transactionDB51);

                accountDB2.add(a3);

                //create some customers and
                //Customer(int id, String name, String address,
                //          String email, int credentials, List<Account> accounts)

                Customer c1 = new Customer(1, "Joe Murphy", "10 Main Street", "jpmurphy@gmail.com", 439823, accountDB1);
                Customer c2 = new Customer(2, "Ann Kelly", "25 The Willows", "ann25kelly@eir.ie", 531100, accountDB2);
                Customer c3 = new Customer(3, "Mary Brown", "13 Railway Street", "mwbrown@ezinearticles.ie", 677843, accountDB3);
                Customer c4 = new Customer(4, "Edward Thomas", "55 The Plaza", "ethomas10@usnews.com", 513742, accountDB4);
                Customer c5 = new Customer(5, "Lisa Black", "152 Oakwood", "lisablack22@opensource.org", 992410, accountDB5);

                customerDB.add(c1);
                customerDB.add(c2);
                customerDB.add(c3);
                customerDB.add(c4);
                customerDB.add(c5);

                init = false;
            }
        } //End of Constructor

    //method to return the full list of customers
    public List<Customer> getCustomerDB() {
        return customerDB;
    }

    //method to return a list of accounts for a specific customer - cusId
    public List<Account> getCustomerAccountsDB(int cusId) {
        return customerDB.get(cusId-1).accountsList;
    }

    //method to return a list of transactions for a specific account - accId
    public List<Transaction> getAccountTransactionsDB(int cusId, int accId) {
        return customerDB.get(cusId-1).accountsList.get(accId-1).transactions;
    }
}
