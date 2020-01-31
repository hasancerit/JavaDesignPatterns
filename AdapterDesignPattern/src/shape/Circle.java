/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

/**
 *
 * @author Hasan
 */
public class Circle implements Shape{
      @Override
      public void draw() {
      System.out.println("Drawing Circle");
      }
      @Override
      public void resize() {
      System.out.println("Resizing Circle");
      }
      @Override
      public String description() {
      return "Circle object";
      }
      @Override
      public boolean isHide() {
      return false;
      }
}
