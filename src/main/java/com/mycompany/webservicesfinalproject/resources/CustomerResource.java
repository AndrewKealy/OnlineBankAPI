package com.mycompany.webservicesfinalproject.resources;

import com.mycompany.webservicesfinalproject.models.Customer;
import com.mycompany.webservicesfinalproject.services.CustomerService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author User
 */
@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    
    CustomerService customerService = new CustomerService();
    
    @DELETE
    public void deleteRequest() {
        System.out.println("403 - Forbidden Request - You do not have permission!");
    }
    
    //return list of all customers
    @GET
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }
    
    //return a specific customer with customerID in URL
    @GET
    @Path("/{customerID}")
    public Customer getCustomer(@PathParam("customerID") int id) {
        return customerService.getCustomer(id);
    }

    // Call AccountsResource for specific customerID 
    @Path("/{customerID}/accounts")
    public AccountResource getAccountsResource() {
        System.out.println("Transferring to accounts subresource...");
        return new AccountResource();
    }
    
}
