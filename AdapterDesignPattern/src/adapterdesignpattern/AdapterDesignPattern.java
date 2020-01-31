/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapterdesignpattern;

import adapters.*;
import geometricshape.Rhombus;
import geometricshape.Triangle;
import shape.*;

/**
 *
 * @author Hasan
 */
public class AdapterDesignPattern {
public static void main(String[] args) {
    
      /*  Drawing drawing = new Drawing();
        drawing.addShape(new Rectangle());
        drawing.addShape(new Circle());
        drawing.addShape(new TriangleAdapter());
        drawing.addShape(new RhombusAdapter());
        System.out.println("Drawing...");
        drawing.draw();
        System.out.println("Resizing...");
        drawing.resize();*/
        
        
        
            System.out.println("Creating drawing of shapes...");
            Drawing drawing = new Drawing();
            drawing.addShape(new Rectangle());
            drawing.addShape(new Circle());
            drawing.addShape(new GeometricShapeObjectAdapter(new Triangle()));
            drawing.addShape(new GeometricShapeObjectAdapter(new Rhombus()));
            System.out.println("Drawing...");
            drawing.draw();
            System.out.println("Resizing...");
            drawing.resize();
}
}
