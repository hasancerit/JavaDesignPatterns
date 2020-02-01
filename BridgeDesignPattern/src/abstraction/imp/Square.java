/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstraction.imp;

import abstraction.Shape;
import bridge.ColorBridge;

/**
 *
 * @author Hasan
 */
public class Square extends Shape{
    public Square(ColorBridge color) {
        super(color);
    }
    
    @Override
    public String draw() {
        return "Square Drawn." + color.fill();
    }
    
}
