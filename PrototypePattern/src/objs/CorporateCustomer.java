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
public class CorporateCustomer extends Customer{
    private String corporateName;
    private double discount;
 
    public CorporateCustomer(int id, String address, String phone,
            String corporateName, double discount) {
        super(id, address, phone);
        this.corporateName = corporateName;
        this.discount = discount;
    }
 
    
    /*Getter Setter*/
       public String getCorporateName() {
        return corporateName;
    }
 
    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }
 
    public double getDiscount() {
        return discount;
    }
 
    public void setDiscount(double discount) {
        this.discount = discount;
    }
 
    @Override
    public String toString() {
        return "CorporateCustomer [corporateName=" + corporateName
                + ", discount=" + discount + ", id=" + id + ", address="
                + address + ", phone=" + phone + ", authenticated="
                + authenticated + "]";
    }
}
