/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory;

import obj.Computer;
import obj.Server;


/**
 *
 * @author Hasan
 */
public class ServerFactory implements ComputerAbstractFactory{
        private String ram;
	
	public ServerFactory(String ram){
		this.ram=ram;
	}
	
	@Override
	public Computer createComputer() {
		return new Server(ram);
	}
}
