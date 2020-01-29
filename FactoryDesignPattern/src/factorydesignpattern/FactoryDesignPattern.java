/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorydesignpattern;

import intr.Computer;

/**
 *
 * @author Hasan
 */
public class FactoryDesignPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Hangi sınıfın oluaşacağı ile Factory Sınıfı ilgilendi. Bu sınıf hangi sınıf nasıl oluşacak habersiz.
        //Burada interface kullandık. 
        Computer pc = ComputerFactory.getComputer("pc","16");
        Computer server = ComputerFactory.getComputer("server","122");
        
        pc.getRam();
        server.getRam();
    }
    
}
