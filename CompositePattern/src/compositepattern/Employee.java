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
public interface Employee {

    public boolean addEmployee(Employee employee);

    public boolean removeEmployee(Employee employee);

    public String getInfo();
}
