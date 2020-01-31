/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapters;

import geometricshape.Rhombus;
import shape.Shape;

/**
 *
 * @author Hasan
 */
public class RhombusAdapter extends Rhombus implements Shape {
     public RhombusAdapter() {
      super();
      }
      @Override
      public void draw() {
      this.drawShape();
      }
      @Override
      public void resize() {
      System.out.println("Rhombus can't be resized. Please create new one with required values.");
      }
      @Override
      public String description() {
      return "Rhombus object";
      }
      @Override
      public boolean isHide() {
      return false;
      }
}
