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
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Hasan
 */
public class Ucgen extends JLabel{
        public static double ALAN = 0.5;
        public boolean bas = false;

        public Ucgen() {
        
        }
        
        @Override
        public void setSize(Dimension d) {
            super.setSize(new Dimension(63,56)); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(63,56);
        }

        @Override
        public void setIcon(Icon icon) {
            super.setIcon((new javax.swing.ImageIcon("C:\\Users\\Hasan\\Desktop\\triangle60.png"))); //To change body of generated methods, choose Tools | Templates.
        }
        
         public int angle = 0 ;
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
							RenderingHints.VALUE_ANTIALIAS_ON);
	       AffineTransform aT = g2.getTransform();
	       Shape oldshape = g2.getClip();
	double x = getWidth()/2.0;
	double y = getHeight()/2.0;
	aT.rotate(Math.toRadians(angle), x, y);
	g2.setTransform(aT);
	g2.setClip(oldshape);    
    	super.paintComponent(g);
    }
    }




