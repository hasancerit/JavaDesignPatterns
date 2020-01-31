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
public class Developer implements Employee{
    private String info = "";

public Developer(String info) {
this.info = info;
}

@Override
public boolean addEmployee(Employee employee) {
return false;
}

@Override
public boolean removeEmployee(Employee employee) {
return false;
}

@Override
public String getInfo() {
return info;
}
}
