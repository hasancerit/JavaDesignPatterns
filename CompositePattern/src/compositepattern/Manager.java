/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositepattern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Hasan
 */
public class Manager implements Employee{
        private String info = "";

      private List<Employee> employeeList = null;

      public Manager(String info) {
      this.info = info;
      employeeList = new ArrayList<Employee>();
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
      for (Employee employee :employeeList) {
          buffer.append(" ").append(employee.getInfo());
      }
      return buffer.toString();
      }  
}
