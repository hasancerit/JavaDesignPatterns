package adapters;


import geometricshape.GeometricShape;
import geometricshape.Rhombus;
import geometricshape.Triangle;
import shape.Shape;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hasan
 */                                               //target
public class GeometricShapeObjectAdapter implements Shape{
    
     //Adaptee 
     private GeometricShape adaptee;
      public GeometricShapeObjectAdapter(GeometricShape adaptee) {
            super();
            this.adaptee = adaptee;
      }
      @Override
      public void draw() {
      adaptee.drawShape();
      }
      @Override
      public void resize() {
      System.out.println(description() + " can't be resized. Please create new one with required values.");
      }
      @Override
      public String description() {
            if (adaptee instanceof Triangle) {
            return "Triangle object";
            } else if (adaptee instanceof Rhombus) {
            return "Rhombus object";
            } else {
            return "Unknown object";
            }
      }
      @Override
      public boolean isHide() {
      return false;
      }
}
