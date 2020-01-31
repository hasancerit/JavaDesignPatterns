/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objs;

import java.util.Date;

/**
 *
 * @author Hasan
 */
public class IndividualCustomer extends Customer{
    private String firstName;
    private String lastName;
    private Date dob;
     
    public IndividualCustomer(int id, String address, String phone,
            String firstName, String lastName, Date dob) {
        super(id, address, phone);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }
    
    
    
    /*Getter Setter*/
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public Date getDob() {
        return dob;
    }
 
    public void setDob(Date dob) {
        this.dob = dob;
    }
 
    @Override
    public String toString() {
        return "IndividualCustomer [firstName=" + firstName + ", lastName="
                + lastName + ", dob=" + dob + ", id=" + id + ", address="
                + address + ", phone=" + phone + ", authenticated="
                + authenticated + "]";
    }
}
