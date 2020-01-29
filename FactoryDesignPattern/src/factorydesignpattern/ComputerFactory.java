/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorydesignpattern;
import imp.PC;
import imp.Server;
import intr.Computer;

/**
 *
 * @author Hasan
 */
public class ComputerFactory {
    public static Computer getComputer(String type,String ram){
		if("PC".equalsIgnoreCase(type)) return new PC(ram);
		else if("Server".equalsIgnoreCase(type)) return new Server(ram);
		
		return null;
    }
}
