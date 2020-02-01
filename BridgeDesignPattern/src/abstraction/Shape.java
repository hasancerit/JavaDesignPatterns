/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstraction;

import bridge.ColorBridge;


/**
 *
 * @author Hasan
 */
public abstract class Shape {
    /*
    *Absraction köprüyü içerir. İmpleri de bu köprü interface'i içindeki metodları kullanır.
    *Abstraction'a bu köprü interfacenin impini client gönderir.
    *
    *Diyelim ki client bir red square olusturmak istiyor.
    *Shape redSq = new Square(new Red());
    *Buradaki 'new Red()', ColorBridge imp'idir.
    *oluşacak Square nesnesine bu bridge gönderilir. Square nesnesi bu colorBridge'i kullanır.
    */
    protected ColorBridge color;
    
    public Shape(ColorBridge color){
        this.color = color;
    }
     
    //standard constructors
     
    abstract public String draw();
}
