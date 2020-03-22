/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritma;

import imagehandler.Circle;
import imagehandler.Dikdörtgen;
import imagehandler.Kare;
import imagehandler.Ucgen;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.TransferHandler;
import optimizasyonprojesi.Algoritma;

/**
 *
 * @author Hasan Cerit
 */
public class Kromozom{
    private int gensayisi = Algoritma.GEN_SAYISI;
    public double kalanAlan;
    public double kullanılanAlan;
    public ArrayList<JLabel> genler; //gensaiyisi kadar, yani 100 tane olacak
    
    public Kromozom(){
        genler = new ArrayList<>();
    }
    
    public void rastgeleGenlerVer(){
        for(int i = 0 ; i < gensayisi ; i++){
            JLabel gen = null;

            int angle = (new Random()).nextInt(1001); //Rastgele aci
            int X = (new Random()).nextInt(500); //Rastgele X
            int Y = (new Random()).nextInt(500); //Rastgele Y

            String rastgeleSayi =""+ ((new Random()).nextInt()); //Hangi şekil ?
            char sonHane = rastgeleSayi.charAt(rastgeleSayi.length()-1);
            if(sonHane == '0' || sonHane == '6'){
                gen = new Circle();
                gen.setSize(60,60);
            }else if(sonHane == '2' || sonHane == '5'){
                gen = new Ucgen();
                gen.setSize(63,56);
                ((Ucgen)gen).angle = angle;
            }else if(sonHane == '4' || sonHane == '9' || sonHane == '1'){
                gen = new Dikdörtgen();
                gen.setSize(120,60);
                ((Dikdörtgen)gen).angle = angle;
            }else if(sonHane == '3' || sonHane == '7' || sonHane == '8'){
                gen = new Kare();
                gen.setSize(60,60);
                ((Kare)gen).angle = angle;
            }
            gen.setLocation(X, Y);
            genler.add(gen);
        }
    }   

}
