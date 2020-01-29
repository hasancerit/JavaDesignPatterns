
import abstractfactory.PCFactory;
import abstractfactory.ServerFactory;
import obj.Computer;



public class AbstractFactoryPattern {
	public static void main(String[] args) {
		testAbstractFactory();
	}

	private static void testAbstractFactory() {
                Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB"));
		Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB"));
		System.out.println("AbstractFactory PC Config::"+pc);
		System.out.println("AbstractFactory Server Config::"+server);
	}
    
}
