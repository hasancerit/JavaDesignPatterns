/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapters;

import geometricshape.Triangle;
import shape.Shape;

/**
 *Burada target = Shape (Dönüstürülmek istenen interface)
 *       adaptee = GeoShape (Triangle'in implements ettiği ve döndüştürülecek olan interface)
 *       Client = drawing, target ile calisir. Cliente uyum saglamak icin adapter yazilir.(Cünkü client Shape kullanıyor, GeoShape'i degistirmemiz gerek)
 * 
 */                         // GeoShape(Triangledan imp) --> Shape
public class TriangleAdapter extends Triangle implements Shape{
      public TriangleAdapter() {
         super();
      }
      
      //Shape Metodlarını aldık, ve içlerinden uygun olanlari Triangle(imp geoShape) ile doldurduk
      @Override
      public void draw() {
          this.drawShape();
      }
     
      @Override
      public void resize() {
      System.out.println("Triangle can't be resized. Please create new one with required values.");
      }
      
      @Override
      public String description() {
      return "Triangle object";
      }
      
      @Override
      public boolean isHide() {
      return false;
      }

}
