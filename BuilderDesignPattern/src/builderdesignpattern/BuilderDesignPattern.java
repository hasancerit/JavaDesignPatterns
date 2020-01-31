package builderdesignpattern;

public class BuilderDesignPattern {
    public static void main(String[] args) {
        Computer comp = new Computer.ComputerBuilder("1000","16").setBluetooth("Bl1").setGraphicsCard("gr1").build();
    }
    
}
