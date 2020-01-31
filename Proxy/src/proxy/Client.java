/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

/**
 *
 * @author Hasan
 */
public class Client {
    public static void main(String[] args){
        Internet internet = new ProxyInternet(); 
        try
        { 
            internet.connectTo("geeksforgeeks.org"); 
            internet.connectTo("abc.com"); 
        } 
        catch (Exception e) 
        { 
            System.out.println(e.getMessage()); 
        }
    }
}
