/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builderdesignpattern;

/**
 *
 * @author Hasan
 */
public class Computer {
    private String HDD;
    private String RAM;
    
    //optional parameters
    private String graphicsCard;
    private String bluetooth;
        
    private Computer(ComputerBuilder builder) {
        System.out.println("Computer Olusuyor..");
	this.HDD=builder.HDD;
	this.RAM=builder.RAM;
	this.graphicsCard=builder.graphicsCard;
	this.bluetooth=builder.bluetooth;
    }
    
    public String getHDD() {
	return HDD;
    }

    public String getRAM() {
	return RAM;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public String getBluetooth() {
        return bluetooth;
    }
    
    public static class ComputerBuilder{
        private String HDD;
        private String RAM;
    
         //optional parameters
        private String graphicsCard;
        private String bluetooth;
        
        public ComputerBuilder(String hdd, String ram){
                        System.out.println("ComputerBuilder Olusuyor..");
			this.HDD=hdd;
			this.RAM=ram;
	}
        
        public ComputerBuilder setGraphicsCard(String graphicsCard) {
			this.graphicsCard = graphicsCard;
			return this;
        }
         public ComputerBuilder setBluetooth(String bluetooth) {
			this.bluetooth = bluetooth;
			return this;
        }
        public Computer build(){
		return new Computer(this);
	}
    }   
}
