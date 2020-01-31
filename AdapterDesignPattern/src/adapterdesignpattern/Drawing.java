/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapterdesignpattern;

import java.util.ArrayList;
import java.util.List;
import shape.Shape;

/**
 *
 * @author Hasan
 */
public class Drawing {
    List<Shape> shapes = new ArrayList<Shape>();
    
    public Drawing() {
        super();
    }
    
    public void addShape(Shape shape) {
        shapes.add(shape);
    
    }
    
    public List<Shape> getShapes() {
        return new ArrayList<Shape>(shapes);
    }
    
    public void draw() {
          if (shapes.isEmpty()) {
              System.out.println("Nothing to draw!");
          } else {
              shapes.stream().forEach(shape -> shape.draw());
          }
    }
    public void resize() {
          if (shapes.isEmpty()) {
             System.out.println("Nothing to resize!");
          } else {
             shapes.stream().forEach(shape -> shape.resize());
          }
    }
}
