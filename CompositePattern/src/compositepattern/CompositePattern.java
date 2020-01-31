/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositepattern;

/**
 *
 * @author Hasan
 */
public class CompositePattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Employee developer1 = new Developer("Developer1");
Employee developer2 = new Developer("Developer2");
Employee developer3 = new Developer("Developer3");
Employee manager1 = new Manager("Manager1");
Employee manager2 = new Manager("Manager2");
Employee ceo = new Ceo("CEO");

manager1.addEmployee(developer1);
manager1.addEmployee(developer2);
manager2.addEmployee(developer3);

ceo.addEmployee(manager1);
ceo.addEmployee(manager2);

System.out.println(ceo.getInfo());    }
    
}
