/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometricshape;

/**
 *
 * @author Hasan
 */
public class Rhombus implements GeometricShape{
     private final double a;
    private final double b;
    public Rhombus() {
        this(1.0d, 1.0d);
    }
    public Rhombus(double a, double b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public double area() {
        double s = a * b;
        return s;
    }
    @Override
    public double perimeter() {
        return 2 * (a + b);
    }
    @Override
    public void drawShape() {
    System.out.println("Drawing Rhombus with area: " + area() + " and perimeter: " + perimeter());
    }
}
