/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositepattern;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hasan
 */
public class Ceo implements Employee{
    private String info = "";

    private List<Employee> employeeList = null;

    public Ceo(String info) {
    this.info = info;
    employeeList = new ArrayList<>();
    }

    @Override
    public boolean addEmployee(Employee employee) {
    return employeeList.add(employee);
    }

    @Override
    public boolean removeEmployee(Employee employee) {
    return employeeList.remove(employee);
    }

    @Override
    public String getInfo() {
    StringBuffer buffer = new StringBuffer();
    buffer.append(info).append(": ");
    for (Employee employee : employeeList) {
        buffer.append(" ").append(employee.getInfo());
    }
    return buffer.toString();
    }
}
