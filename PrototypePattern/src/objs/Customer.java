/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objs;

/**
 *
 * @author Hasan
 */
public abstract class Customer implements Cloneable{
    protected int id;
    protected String address;
    protected String phone;
    boolean authenticated;
 
    public Customer(int id, String address, String phone) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        authenticated = false;
    }
 
    
    
    /* Getter Setter*/
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    public String getPhone() {
        return phone;
    }
 
    public void setPhone(String phone) {
        this.phone = phone;
    }
 
    public boolean isAuthenticated() {
        return authenticated;
    }
 
    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
     
    @Override
    public String toString() {
        return "Customer [id=" + id + ", address=" + address + ", phone="
                + phone + ", authenticated=" + authenticated + "]";
    }
 
    @Override
    public Customer clone() {
        Customer customer = null;
        try {
            customer = (Customer) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Problem when cloning the object: " + e.getMessage());
            e.printStackTrace();
        }
        return customer;
    }
}
