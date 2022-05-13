package com.mycompany.webservicesfinalproject.resources;

import com.mycompany.webservicesfinalproject.models.Account;
import com.mycompany.webservicesfinalproject.models.Transaction;
import com.mycompany.webservicesfinalproject.services.TransactionService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author User
 */

@Path("/transactions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {
    
    private TransactionService transactionService = new TransactionService();
    
    // return list of all transactions on a specific account - customerID, accountID
    @GET
    public List <Transaction> getTransactions(@PathParam("customerID") int cusId, @PathParam("accountID") int accId) {
        System.out.println("get all transactions for account: " + accId);
        return transactionService.getAllTransactions(cusId, accId);
    }
    
    // return a specific transaction (transactionID) on an account - customerID, accountID
    @GET
    @Path("/{transactionID}")
    public Transaction getTransaction(@PathParam("customerID") int cusId, @PathParam("accountID") int accId, @PathParam("transactionID") int transId) {
        System.out.println("get transactions from account ID: " + accId);
        return transactionService.getTransactionByID(cusId, accId, transId);
    }
    
    //lodgement - POST request

    @POST
    @Path("/lodgement")
    @Consumes(MediaType.APPLICATION_JSON)
    public Transaction postLodgement(Transaction t, @PathParam("customerID") int cusId, @PathParam("accountID") int accId) {
        return transactionService.createLodgement(t, cusId, accId);
    }
    
    
    //withdraw - POST request
    
    @POST
    @Path("/withdrawal")
    @Consumes(MediaType.APPLICATION_JSON)
    public Transaction postWihdrawal(Transaction t, @PathParam("customerID") int cusId, @PathParam("accountID") int accId) {
        return transactionService.createWithdrawal(t, cusId, accId);
    }
    
    //tranfer - POST request
    
    @POST
    @Path("/transfer/{destinationAccID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Transaction postTransfer(Transaction t, @PathParam("destinationAccID") int destinationAccId, @PathParam("customerID") int cusId, @PathParam("accountID") int accId) {
        return transactionService.createTransfer(t, destinationAccId, cusId, accId);
    }

}
