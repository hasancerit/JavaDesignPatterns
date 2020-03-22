/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizasyonprojesi;

import algoritma.Helper;
import algoritma.Kromozom;
import algoritma.Sorter;
import imagehandler.Circle;
import imagehandler.Dikdörtgen;
import imagehandler.Kare;
import imagehandler.Ucgen;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
/**
 *
 * @author Hasan Cerit
 */
public class Algoritma extends javax.swing.JFrame {
    private ArrayList<Dikdörtgen> kesilenDikdörtgenler = new ArrayList<>();
    private ArrayList<Circle> kesilenDaireler = new ArrayList<>();
    private ArrayList<Kare> kesilenKareler = new ArrayList<>();
    private ArrayList<Ucgen> kesilenUcgenler = new ArrayList<>();

    JFrame frame = this;
    JLabel secilenKalip;
    Class seciliClass;
    
    //Algoritma değişkenleri 
    public static int POPULASYON = 20; //20 Kromozon var
    public static int GEN_SAYISI = 300;//Her kromozomun 300 tane geni var;
    public ArrayList<Kromozom> kromozomlar = new ArrayList<>(); //POPULASYON kadar olacak yani 20
    public ArrayList<Kromozom> denenecek = new ArrayList<>();
    private ArrayList<Kromozom> bests = new ArrayList<>();
    
    public void baslangicPop(){
        for(int i = 0 ; i < POPULASYON ; i++){
            Kromozom k = new Kromozom();
            k.rastgeleGenlerVer();
            kromozomlar.add(k);
        }
    }
    
    public Algoritma(){
        initComponents();
        baslangicPop();
        denenecek = kromozomlar;
        yerlestir();
        sirala();
        ele();
        eniyi();
        sonraki.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               for(int i = 0 ; i < 5 ; i++){
                    ArrayList<Kromozom> denencekTemp = (ArrayList<Kromozom>) denenecek.clone();
                    denenecek.clear();
                    denenecek = Helper.üret(denencekTemp);
                    sifirla();
                    yerlestir();
                    sirala();
                    ele();
                    eniyi();
                    kumas.repaint();                   
               }
               
            }
        });
        t.start();
     }
    
    public void yerlestir(){ //Popülasyonda bulunan kromozomların her biri kumaşı keser.
        for(int u = 0 ; u < denenecek.size() ; u++){
            Kromozom k = denenecek.get(u);
            ArrayList<JLabel> kaldirilicakGenler = new ArrayList<>();
            for(int l = 0 ; l < GEN_SAYISI ; l++){
                JLabel j = k.genler.get(l);
                secilenKalip = j;
                if(!kesisme2(j)){
                    kumas.add(secilenKalip);
                    if(j.getClass().toString().equals("class imagehandler.Kare")){
                        ((Kare) j).bas = true;
                        kesilenKareler.add((Kare) j);
                    }else if(j.getClass().toString().equals("class imagehandler.Dikdörtgen")){
                        ((Dikdörtgen) j).bas = true;
                        kesilenDikdörtgenler.add((Dikdörtgen) j);
                    }else if(j.getClass().toString().equals("class imagehandler.Circle")){
                        ((Circle) j).bas = true;
                        kesilenDaireler.add((Circle)j); 
                    }else{
                        ((Ucgen) j).bas = true;
                        kesilenUcgenler.add((Ucgen)j); 
                    } 
                }else{
                    kaldirilicakGenler.add(j);
                }
            }
            secilenKalip = null;
            
            for(JLabel j : kaldirilicakGenler){
                    if(j.getClass().toString().equals("class imagehandler.Kare")){
                        ((Kare) j).bas = false;
                       // kesilenKareler.remove((Kare) j);
                    }else if(j.getClass().toString().equals("class imagehandler.Dikdörtgen")){
                        ((Dikdörtgen) j).bas = false;
                       // kesilenDikdörtgenler.remove((Dikdörtgen) j);
                    }else if(j.getClass().toString().equals("class imagehandler.Circle")){
                        ((Circle) j).bas = false;
                       // kesilenDaireler.remove((Circle) j);
                    }else{                        
                        ((Ucgen) j).bas = false;
                       // kesilenUcgenler.remove((Ucgen) j);
                    }
                //k.genler.remove(j);
            }
            
            Kromozom sonK = kesismeTekrar(k);
            denenecek.set(u, sonK);
            
            kumas.removeAll();
            kumas.repaint();
            formul(sonK);
            
            kesilenDaireler.clear();
            kesilenDikdörtgenler.clear();
            kesilenKareler.clear();
            kesilenUcgenler.clear();
        }
    }
    
    public Kromozom kesismeTekrar(Kromozom k){
        ArrayList<JLabel> kaldirilacaklar = new ArrayList<>();
        for(int i = 0 ; i < k.genler.size() ; i++){
            for(int j = i+1; j < k.genler.size() ; j++){
                if(intersects(k.genler.get(i), k.genler.get(j))){ //kesişiyorsa ve önceden çıkarılmadıysa (bas == false)
                    JLabel g1 = k.genler.get(i);
                    JLabel g2 = k.genler.get(j);
                    
                    Class g1class = g1.getClass();
                    Class g2class = g2.getClass();
                    
                    boolean g1bool;
                    boolean g2bool;
                    
                    if(g1class.toString().equals("class imagehandler.Kare")) g1bool = ((Kare)g1).bas;
                    else if(g1class.toString().equals("class imagehandler.Dikdörtgen")) g1bool = ((Dikdörtgen)g1).bas;
                    else if(g1class.toString().equals("class imagehandler.Circle")) g1bool = ((Circle)g1).bas;
                    else  g1bool = ((Ucgen)g1).bas;
                    
                    if(g2class.toString().equals("class imagehandler.Kare")) g2bool = ((Kare)g2).bas;
                    else if(g2class.toString().equals("class imagehandler.Dikdörtgen")) g2bool = ((Dikdörtgen)g2).bas;
                    else if(g2class.toString().equals("class imagehandler.Circle")) g2bool = ((Circle)g2).bas;
                    else  g2bool = ((Ucgen)g2).bas;
                    
                    if(g1bool && g2bool){
                            kumas.remove(g1);
                            frame.remove(g1);
                            kaldirilacaklar.add(g1);
                            break; 
                    }

                }
            }
        }
        
        for(JLabel gen : kaldirilacaklar){
                    if(gen.getClass().toString().equals("class imagehandler.Kare")){
                        ((Kare) gen).bas = false;
                        kesilenKareler.remove((Kare) gen);
                    }else if(gen.getClass().toString().equals("class imagehandler.Dikdörtgen")){
                        ((Dikdörtgen) gen).bas = false;
                        kesilenDikdörtgenler.remove((Dikdörtgen) gen);
                    }else if(gen.getClass().toString().equals("class imagehandler.Circle")){
                        ((Circle) gen).bas = false;
                        kesilenDaireler.remove((Circle) gen);
                    }else{
                        ((Ucgen) gen).bas = false;
                        kesilenUcgenler.remove((Ucgen) gen);
                    }
        }
        return k;
    }
    
    public void formul(Kromozom k){
         //Kullanılan Alan ve Kalan alan
         double kareAlan = Kare.ALAN * kesilenKareler.size();
         double daireAlan = Circle.ALAN * kesilenDaireler.size();
         double ucgenAlan = Ucgen.ALAN * kesilenUcgenler.size();
         double diktAlan = Dikdörtgen.ALAN * kesilenDikdörtgenler.size();
         
         double kullanılanAlan = kareAlan + daireAlan + ucgenAlan + diktAlan;
         double kalanAlan = 100.0 - kullanılanAlan;
         
         k.kalanAlan = kalanAlan;
         k.kullanılanAlan = kullanılanAlan;
    }
    
    public void sirala(){
       denenecek.sort(new Sorter());
    }
    
    public void ele(){
        for(int i = 0 ; i < denenecek.size() / 2 ; i++){
           denenecek.remove(denenecek.size()-1);
        }
    }
            
    public void eniyi(){
        Kromozom best = denenecek.get(0);
        bests.add(best);
        nesilBas(String.format("%.2f", best.kalanAlan));
        for(JLabel j : best.genler){
            if(j.getClass().toString().equals("class imagehandler.Kare")){
                if(((Kare)j).bas){
                    kumas.add(j);
                    kesilenKareler.add((Kare) j);
                    seciliClass = Kare.class;
                    updateLog();
                }
            }else if(j.getClass().toString().equals("class imagehandler.Dikdörtgen")){
                if(((Dikdörtgen)j).bas){
                    kumas.add(j);
                    kesilenDikdörtgenler.add((Dikdörtgen) j);
                    seciliClass = Dikdörtgen.class;
                    updateLog();
                }
            }else if(j.getClass().toString().equals("class imagehandler.Circle")){
                if(((Circle)j).bas){
                    kumas.add(j);
                    kesilenDaireler.add((Circle) j);
                    seciliClass = Circle.class;
                    updateLog();
                }
            }else{
                if(((Ucgen)j).bas){
                    kumas.add(j);
                    kesilenUcgenler.add((Ucgen) j);
                    seciliClass = Ucgen.class;
                    updateLog();
                }
            }
        }
        kumas.repaint();
    }
    
    //Kesişiyor mu kontrolü
    public boolean kesisme2(JLabel secilenKalip){
        for(Kare k: kesilenKareler){
            if(intersects(secilenKalip,k)){
                return true;
            }
        }
        for(Circle k: kesilenDaireler){
            if(intersects(secilenKalip,k)){
                return true;
            }
        }
         for(Ucgen k: kesilenUcgenler){
            if(intersects(secilenKalip,k)){
                return true;
            }
        }
         for(Dikdörtgen k: kesilenDikdörtgenler){
            if(intersects(secilenKalip,k)){
                return true;
            }
        } 
        
         return false;
    }
    
    //Kesişiyor mu kontrolü
    public boolean kesisme(){
        for(Kare k: kesilenKareler){
            if(intersects(secilenKalip,k)){
                return true;
            }
        }
        for(Circle k: kesilenDaireler){
            if(intersects(secilenKalip,k)){
                return true;
            }
        }
         for(Ucgen k: kesilenUcgenler){
            if(intersects(secilenKalip,k)){
                return true;
            }
        }
         for(Dikdörtgen k: kesilenDikdörtgenler){
            if(intersects(secilenKalip,k)){
                return true;
            }
        } 
        
         return false;
    }
    
    public boolean intersects(JLabel testa, JLabel testb){
       Rectangle yourLine = new Rectangle(testa.getX(), testa.getY(), testa.getWidth()+3, testa.getHeight()+3);
       Rectangle ellipse = new Rectangle(testb.getX(), testb.getY(), testb.getWidth()+3, testb.getHeight()+3);
       return yourLine.intersects(ellipse);
}
    
    
    
    Timer t = new Timer(70, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            kumas.repaint();
            frame.repaint();
        }
    });
    
    int nesil = 1 ;
    public void nesilBas(String alan){
        nesilLabel.setText(nesilLabel.getText()+nesil+".Nesil:"+alan+"-");
        nesil+=1;
        System.out.println(nesil+".Nesil:"+alan);
    }
    
    //Bilgi Ekranı Güncellemesi
    public void updateLog(){
         if(seciliClass.toString().equals("class imagehandler.Dikdörtgen")){
            int pre =  Integer.valueOf(diktLog.getText());
            pre++;
            diktLog.setText(""+pre);
         }else if(seciliClass.toString().equals("class imagehandler.Kare")){
            int pre =  Integer.valueOf(kareLog.getText());
            pre++;
            kareLog.setText(""+pre);
         }else if(seciliClass.toString().equals("class imagehandler.Ucgen")){
             int pre =  Integer.valueOf(ucgenLog.getText());
            pre++;
            ucgenLog.setText(""+pre);
         }else{
            int pre =  Integer.valueOf(daireLog.getText());
            pre++;
            daireLog.setText(""+pre);
         }
         
         //Kullanılan Alan ve Kalan alan
         double kareAlan = Kare.ALAN * kesilenKareler.size();
         double daireAlan = Circle.ALAN * kesilenDaireler.size();
         double ucgenAlan = Ucgen.ALAN * kesilenUcgenler.size();
         double diktAlan = Dikdörtgen.ALAN * kesilenDikdörtgenler.size();
         
         double kullanılanAlan = kareAlan + daireAlan + ucgenAlan + diktAlan;
         double kalanAlan = 100.0 - kullanılanAlan;
         
         
         kullanılanLog.setText(String.format("%.2f", kullanılanAlan));
         kalanLog.setText(String.format("%.2f", kalanAlan));
    }
    
    public void removeLog(){
        diktLog.setText("0");
        ucgenLog.setText("0");
        kareLog.setText("0");
        daireLog.setText("0");

         kullanılanLog.setText(String.format("0.00"));
         kalanLog.setText(String.format("100.00"));
    }
    
    public void sifirla(){
        removeLog();
        kesilenDikdörtgenler.clear();
        kesilenDaireler.clear();
        kesilenKareler.clear();
        kesilenUcgenler.clear();
        secilenKalip = null;
        seciliClass = null;
        kromozomlar = null;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        square1 = new imagehandler.Ucgen();
        kumas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        kareLog = new javax.swing.JLabel();
        ucgenLog = new javax.swing.JLabel();
        diktLog = new javax.swing.JLabel();
        daireLog = new javax.swing.JLabel();
        kullanılanLog = new javax.swing.JLabel();
        kalanLog = new javax.swing.JLabel();
        sonraki = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        nesilLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout square1Layout = new javax.swing.GroupLayout(square1);
        square1.setLayout(square1Layout);
        square1Layout.setHorizontalGroup(
            square1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        square1Layout.setVerticalGroup(
            square1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(null);
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 700));

        kumas.setBackground(new java.awt.Color(255, 255, 255));
        kumas.setPreferredSize(new java.awt.Dimension(600, 600));
        kumas.setLayout(null);

        jLabel1.setText("Bilgi Ekranı");

        jLabel2.setText("Kare Sayısı:");

        jLabel3.setText("Üçgen Sayısı:");

        jLabel4.setText("Dikdörtgen Sayısı:");

        jLabel5.setText("Daire Sayısı:");

        jLabel7.setText("Kullanılan Alan(m2):");

        jLabel8.setText("Kalan Alan(m2):");

        kareLog.setText("0");

        ucgenLog.setText("0");

        diktLog.setText("0");

        daireLog.setText("0");

        kullanılanLog.setText("0.00");

        kalanLog.setText("100.00");

        sonraki.setText("Sonraki Nesil");

        jLabel9.setText("Nesillerdeki En İyiler:");

        nesilLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(kumas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(sonraki)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ucgenLog))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kareLog))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(diktLog))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(daireLog))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kullanılanLog))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kalanLog))
                            .addComponent(jLabel9)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nesilLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kumas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(kareLog))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ucgenLog))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(diktLog))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(daireLog))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(kullanılanLog))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(kalanLog))
                        .addGap(43, 43, 43)
                        .addComponent(jLabel9)
                        .addGap(1, 1, 1)
                        .addComponent(nesilLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sonraki)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Algoritma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Algoritma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Algoritma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Algoritma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Algoritma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel daireLog;
    private javax.swing.JLabel diktLog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel kalanLog;
    private javax.swing.JLabel kareLog;
    private javax.swing.JLabel kullanılanLog;
    private javax.swing.JPanel kumas;
    private javax.swing.JLabel nesilLabel;
    private javax.swing.JButton sonraki;
    private imagehandler.Ucgen square1;
    private javax.swing.JLabel ucgenLog;
    // End of variables declaration//GEN-END:variables
}
