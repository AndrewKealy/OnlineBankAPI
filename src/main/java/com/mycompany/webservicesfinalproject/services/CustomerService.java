package com.mycompany.webservicesfinalproject.services;

import com.mycompany.webservicesfinalproject.databases.Database;
import com.mycompany.webservicesfinalproject.models.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author User
 */

public class CustomerService {
    
//    Database db = new Database();
    private List<Customer> clist = new Database().getCustomerDB();
    
    public List<Customer> getAllCustomers() {
    
        return clist;
    }
  
    public Customer getCustomer(int id) {
        return clist.get(id-1);
    }
    
    
}
