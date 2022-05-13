package com.mycompany.webservicesfinalproject.resources;

import com.mycompany.webservicesfinalproject.models.Account;
import com.mycompany.webservicesfinalproject.services.AccountService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import static org.glassfish.jersey.uri.UriComponent.Type.PATH;

/**
 * @author User
 */

@Path("/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {
    
    AccountService accountService = new AccountService();
    
    @GET
    public List<Account> getAllAccounts(@PathParam("customerID") int id) {      //changed from accountID
        System.out.println("getting all transactions for Customer: "+id);
	return accountService.getCustomerAccounts(id);           //added id here
    }
	
    @GET
    @Path("/{accountID}")
    public Account getAccount(@PathParam("customerID") int cId, @PathParam("accountID") int id) {
    	System.out.println("getting Account By ID..."+id);
	return accountService.getAccountByID(cId, id);
    }
    
    @GET
    @Path("/{accountID}/balance")
    public String getAccountBalance(@PathParam("customerID") int cId, @PathParam("accountID") int id) {
    	System.out.println("getting Account Balance By ID..."+id);
	return accountService.getAccountBalanceByID(cId, id);
    }
    
    
    @Path("/{accountID}/transactions")
    public TransactionResource getTransactionsResource() {
        System.out.println("Getting transactions subresource...");
        return new TransactionResource();
    }
    
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Account postAccount(Account a, @PathParam("customerID") int id){
       return accountService.createAccount(a, id);
    }
}
