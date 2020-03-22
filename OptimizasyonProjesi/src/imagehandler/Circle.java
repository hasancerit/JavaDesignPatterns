/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagehandler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Hasan
 */
public class Circle extends JLabel{
        public static double ALAN = 0.56;
        
        public boolean bas = false;
        
        public Circle() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(60, 60);
        }

    @Override
    public void setSize(Dimension d) {
        super.setSize(new Dimension(60,60)); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIcon(Icon icon) {
        super.setIcon((new javax.swing.ImageIcon("C:\\Users\\Hasan\\Desktop\\circle60.png"))); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    }




