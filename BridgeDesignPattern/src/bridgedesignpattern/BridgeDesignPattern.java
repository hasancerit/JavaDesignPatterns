package bridgedesignpattern;

import abstraction.Shape;
import abstraction.imp.Square;
import bridge.Red;

public class BridgeDesignPattern {
    public static void main(String[] args) {
        
        Shape square = new Square(new Red());
       
        System.out.println(
                ""+square.draw().equalsIgnoreCase("Square Drawn.Red")
                        );
    }
    
}
