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
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JLabel;
import optimizasyonprojesi.Algoritma;

/**
 *
 * @author Hasan Cerit
 */
public class Helper {
    public static ArrayList<Kromozom> üret(ArrayList<Kromozom> parents){
        //10 tane kromozom geldi, 20 yapıp yollayacağız.
        ArrayList<Kromozom> childs = new ArrayList<>();
        ArrayList<Integer> doluIndexler = new ArrayList<>();
        
        for(int i = 0 ; i < Algoritma.POPULASYON / 4 ; i++){
                //5 Kere çalışacak
                Kromozom disi = parents.get(i);
                int erkekInd = 5 + (new Random()).nextInt(5);
                while(doluIndexler.contains(erkekInd)){
                    erkekInd = 5 + (new Random()).nextInt(5);
                }

                Kromozom erkek = parents.get(erkekInd);
                doluIndexler.add(erkekInd);

                int point = 40 + (new Random()).nextInt(Algoritma.GEN_SAYISI-80);


                ArrayList<JLabel> disi1bölge = bolgeBulOnce(disi.genler,point);
                ArrayList<JLabel> disi2bölge = bolgeBulSonra(disi.genler, point);

                ArrayList<JLabel> erkek1bölge = bolgeBulOnce(erkek.genler,point);
                ArrayList<JLabel> erkek2bölge = bolgeBulSonra(erkek.genler, point);


                for(JLabel l : erkek2bölge){
                    disi1bölge.add(l); //disi1bolge'ye erkek2bolgeyi ekledik. disi1bolge child1in genleri oldu
                }

                for(JLabel l : disi2bölge){
                    erkek1bölge.add(l); //erkek1bolgeye'ye disi2bolgeyi ekledik. erkek1bolge child2in genleri oldu
                }

                Kromozom yeni1 = new Kromozom();
                yeni1.genler = disi1bölge;

                Kromozom yeni2 = new Kromozom();
                yeni2.genler = erkek1bölge;

                yeni1 = mutasyon(yeni1);
                yeni2 = mutasyon(yeni2);
                
                childs.add(yeni1);
                childs.add(yeni2);
        }
        for(Kromozom k : childs){
            parents.add(k);
        }
        return parents;
    }
    
    private static ArrayList<JLabel> bolgeBulOnce(ArrayList<JLabel> full, int point){
        ArrayList<JLabel> bolge = new ArrayList<>();
        for(int i = 0 ; i < point ; i++){
            bolge.add(full.get(i));
        }
        
        return bolge;
    }
    private static ArrayList<JLabel> bolgeBulSonra(ArrayList<JLabel> full, int point){
        ArrayList<JLabel> bolge = new ArrayList<>();
        for(int i = point ; i < full.size() ; i++){
            bolge.add(full.get(i));
        }
        
        return bolge;
    }
    
    private static Kromozom mutasyon(Kromozom eski){
        for(int i = 0 ; i < 300 ; i++){
            int mutPoint = 10+(new Random()).nextInt(Algoritma.GEN_SAYISI-20);
            eski.genler.set(mutPoint,randomGen());
        }
        return eski;
    }
    
    private static JLabel randomGen(){
        JLabel gen;
        
        int angle = (new Random()).nextInt(1001); //Rastgele aci
        int X = (new Random()).nextInt(500); //Rastgele X
        int Y = (new Random()).nextInt(500); //Rastgele Y
        
        String deger =""+ new Random().nextInt(1000);
        char sonDeger = deger.charAt(deger.length()-1);
        switch (sonDeger) {
            case '1':
            case '6':
                gen = new Circle();
                gen.setSize(60,60);
                break;
            case '3':
            case '9':
                gen = new Ucgen();
                gen.setSize(63,56);
                ((Ucgen)gen).angle = angle;
                break;
            case '2':
            case '5':
            case '7':
                gen = new Kare();
                gen.setSize(60,60);
                ((Kare)gen).angle = angle;
                break;
            default:
                gen = new Dikdörtgen();
                gen.setSize(120,60);
                ((Dikdörtgen)gen).angle = angle;
                break;
        }
        gen.setLocation(X,Y);
        return gen;

    }
}
