/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototypepattern;

import java.util.Date;
import objs.CorporateCustomer;
import objs.IndividualCustomer;

/**
 *
 * @author Hasan
 */
public class PrototypePattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IndividualCustomer unAuthenticatedHasanCustomerPrototype = new IndividualCustomer(1,
                "Isparta", "5073214",
                "Hasan", "Cerit", new Date());
        System.out.println(unAuthenticatedHasanCustomerPrototype);
        
        IndividualCustomer authenticatedBatuCoskun = (IndividualCustomer) unAuthenticatedHasanCustomerPrototype.clone();
        authenticatedBatuCoskun.setId(2);
        authenticatedBatuCoskun.setFirstName("Batuhan");
        authenticatedBatuCoskun.setAuthenticated(true);
        System.out.println(authenticatedBatuCoskun);
         
        
        /**/
        CorporateCustomer unAuthenticatedGECustomerPrototype = new CorporateCustomer(100, "İzmir", "dasfddas", "TR", 0.25);
        System.out.println(unAuthenticatedGECustomerPrototype);
 
    }
    
}
