/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizasyonprojesi;

import imagehandler.Circle;
import imagehandler.Dikdörtgen;
import imagehandler.Kare;
import imagehandler.TempPanel;
import imagehandler.Ucgen;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author Hasan Cerit
 */
public class Manuel extends javax.swing.JFrame {
    private ArrayList<Dikdörtgen> kesilenDikdörtgenler = new ArrayList<>();
    private ArrayList<Circle> kesilenDaireler = new ArrayList<>();
    private ArrayList<Kare> kesilenKareler = new ArrayList<>();
    private ArrayList<Ucgen> kesilenUcgenler = new ArrayList<>();
    
    private JLabel secilenKalip;
    private Class seciliClass;
    private JPanel tempPanel1;
    private boolean seciliMi = false;
    
    JFrame frame = this;
    
    
    public Manuel() {
        tempPanel1 = new TempPanel();
        tempPanel1.setLocation(6, 6);
        tempPanel1.setSize(600,700);
        tempPanel1.setBackground(new Color(0,0,0,0));
        super.add(tempPanel1);
        
        initComponents();
        
        kare1.addMouseListener(ml);
        circle1.addMouseListener(ml);
        ucgen1.addMouseListener(ml);
        dikdörtgen1.addMouseListener(ml);
        
        kumas.addMouseListener(mlkumas);
        
        tekrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kesilenDikdörtgenler.clear();
                kesilenDaireler.clear();
                kesilenKareler.clear();
                kesilenUcgenler.clear();
                kumas.removeAll();
                removeLog();
                kumas.repaint();
            }
        });
        
        //Açı ayarı için
        frame.setFocusable(true);
        frame.addKeyListener(new KeyListener() {
               @Override
               public void keyTyped(KeyEvent e) {}

                @Override
                public void keyPressed(KeyEvent e) {
                    System.out.println("key");
                    if(seciliMi){
                        int key = e.getKeyCode();

                        if (key == KeyEvent.VK_H) {
                            System.out.println("h");
                            secilenKalip.repaint();
                            if(seciliClass.toString().equals("class imagehandler.Dikdörtgen")){
                                ((Dikdörtgen) secilenKalip).angle +=5;
                            }else if(seciliClass.toString().equals("class imagehandler.Kare")){
                                ((Kare) secilenKalip).angle +=5;
                            }else if(seciliClass.toString().equals("class imagehandler.Ucgen")){
                                ((Ucgen) secilenKalip).angle +=5;
                            }
                        }
                        if (key == KeyEvent.VK_G) {
                            secilenKalip.repaint();
                            if(seciliClass.toString().equals("class imagehandler.Dikdörtgen")){
                                ((Dikdörtgen) secilenKalip).angle -=5;
                            }else if(seciliClass.toString().equals("class imagehandler.Kare")){
                                ((Kare) secilenKalip).angle -=5;
                            }else if(seciliClass.toString().equals("class imagehandler.Ucgen")){
                                ((Ucgen) secilenKalip).angle -=5;
                            }                }
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }
                });
     }
    
    
    //Kalıplara tıklanıldığında
    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            seciliClass = e.getSource().getClass();
            String source = e.getSource().getClass().toString();
            Point mousePos = e.getLocationOnScreen();
            switch (source) {
                case "class imagehandler.Kare":
                    System.out.println("Kare Pressed");
                    if(!seciliMi){
                        seciliMi=true;
                        secilenKalip = new Kare();
                        secilenKalip.setSize(60,60);
                        tempPanel1.add(secilenKalip);
                        timer.start();
                    }
                    break;
                 case "class imagehandler.Dikdörtgen":
                        if(!seciliMi){
                        seciliMi=true;
                        secilenKalip = new Dikdörtgen();
                        secilenKalip.setSize(120,60);
                        tempPanel1.add(secilenKalip);
                        timer.start();
                    }
                    break;
                case "class imagehandler.Circle":
                    if(!seciliMi){
                        seciliMi=true;
                        secilenKalip = new Circle();
                        secilenKalip.setSize(60,60);
                        tempPanel1.add(secilenKalip);
                        timer.start();
                    }
                    break;
                default:
                    System.out.println("Ucgen Tıklandı");
                    if(!seciliMi){
                        seciliMi=true;
                        secilenKalip = new Ucgen();
                        secilenKalip.setSize(63,56);
                        tempPanel1.add(secilenKalip);
                        timer.start();
                    }
                    break;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
                    
        }
    };
    
    //Kalıp Seçildiğinde Mouse ile Birlikte hareket etmesi için
    Point timerPos;
    Timer timer = new Timer(70, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(seciliMi){
                Point p = MouseInfo.getPointerInfo().getLocation();
                p = new Point(p.x - frame.getLocation().x-40, p.y - frame.getLocation().y-60);
                if(seciliClass.toString().equals("class imagehandler.Dikdörtgen")){
                    System.out.println("p");
                    p = new Point(p.x - frame.getLocation().x-30, p.y - frame.getLocation().y);
                }
                secilenKalip.setLocation(p);
                tempPanel1.repaint();
                secilenKalip.repaint();
                timerPos = p;
            }
        }
    });
    
    //Seçili Kalıp işaretlenmek için tıklanıldığında
    MouseListener mlkumas = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(seciliMi){
                System.out.println(secilenKalip.getBounds().toString());
                if(!kesisme()){//Kesişim Kontrolü ve panel'a tam sığıp sığmadığı kontrolü
                    kumas.add(secilenKalip);
                    tempPanel1.remove(secilenKalip);
                    seciliMi = false;
                    timer.stop();
                    if(seciliClass.toString().equals("class imagehandler.Dikdörtgen")){
                         kesilenDikdörtgenler.add((Dikdörtgen)secilenKalip);
                    }else if(seciliClass.toString().equals("class imagehandler.Kare")){
                         kesilenKareler.add((Kare)secilenKalip);                        
                    }else if(seciliClass.toString().equals("class imagehandler.Ucgen")){
                          kesilenUcgenler.add((Ucgen)secilenKalip);                       
                    }else{
                         kesilenDaireler.add((Circle)secilenKalip);
                    }
                     
                    updateLog();
                }
            }        
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(seciliMi){
                System.out.println(secilenKalip.getBounds().toString());
                if(!kesisme()){//Kesişim Kontrolü ve panel'a tam sığıp sığmadığı kontrolü
                    kumas.add(secilenKalip);
                    tempPanel1.remove(secilenKalip);
                    seciliMi = false;
                    timer.stop();
                    if(seciliClass.toString().equals("class imagehandler.Dikdörtgen")){
                         kesilenDikdörtgenler.add((Dikdörtgen)secilenKalip);
                    }else if(seciliClass.toString().equals("class imagehandler.Kare")){
                         kesilenKareler.add((Kare)secilenKalip);                        
                    }else if(seciliClass.toString().equals("class imagehandler.Ucgen")){
                          kesilenUcgenler.add((Ucgen)secilenKalip);                       
                    }else{
                         kesilenDaireler.add((Circle)secilenKalip);
                    }
                     
                    updateLog();
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
                    
        }
    };
    
    //Kesişiyor mu kontrolü
    public boolean kesisme(){
        for(Kare k: kesilenKareler){
            if(intersects(secilenKalip,k)){
                System.out.println("Kesişme Var");
                return true;
            }
        }
        for(Circle k: kesilenDaireler){
            if(intersects(secilenKalip,k)){
                System.out.println("Kesişme Var");
                return true;
            }
        }
         for(Ucgen k: kesilenUcgenler){
            if(intersects(secilenKalip,k)){
                System.out.println("Kesişme Var");
                return true;
            }
        }
         for(Dikdörtgen k: kesilenDikdörtgenler){
            if(intersects(secilenKalip,k)){
                System.out.println("Kesişme Var");
                return true;
            }
        } 
        
         System.out.println("Kesişme Bulunamadı");
         return false;
    }
    
    public boolean intersects(JLabel testa, JLabel testb){
        Area areaA = new Area(testa.getBounds());
        Area areaB = new Area(testb.getBounds());

    return areaA.intersects(areaB.getBounds2D());
}
    
    //Bilgi Ekranını sıfırlar
    public void removeLog(){
        diktLog.setText("0");
        ucgenLog.setText("0");
        kareLog.setText("0");
        daireLog.setText("0");

            kullanılanLog.setText(String.format("0.00"));
         kalanLog.setText(String.format("100.00"));
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
        ucgen1 = new imagehandler.Ucgen();
        kare1 = new imagehandler.Kare();
        circle1 = new imagehandler.Circle();
        dikdörtgen1 = new imagehandler.Dikdörtgen();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        kareLog = new javax.swing.JLabel();
        ucgenLog = new javax.swing.JLabel();
        diktLog = new javax.swing.JLabel();
        daireLog = new javax.swing.JLabel();
        kullanılanLog = new javax.swing.JLabel();
        kalanLog = new javax.swing.JLabel();
        tekrar = new javax.swing.JButton();

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

        ucgen1.setText("ucgen1");

        kare1.setText("kare2");

        circle1.setText("circle2");

        dikdörtgen1.setText("dikdörtgen2");

        jLabel1.setText("Bilgi Ekranı");

        jLabel2.setText("Kare Sayısı:");

        jLabel3.setText("Üçgen Sayısı:");

        jLabel4.setText("Dikdörtgen Sayısı:");

        jLabel5.setText("Daire Sayısı:");

        jLabel6.setText("Şimdiye Kadar;");

        jLabel7.setText("Kullanılan Alan(m2):");

        jLabel8.setText("Kalan Alan(m2):");

        kareLog.setText("0");

        ucgenLog.setText("0");

        diktLog.setText("0");

        daireLog.setText("0");

        kullanılanLog.setText("0.00");

        kalanLog.setText("100.00");

        tekrar.setText("Tekrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(kumas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(circle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dikdörtgen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kare1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ucgen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tekrar)))
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
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kullanılanLog))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kalanLog)))))
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
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(kullanılanLog))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(kalanLog))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ucgen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kare1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(circle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dikdörtgen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tekrar))
                .addContainerGap(18, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(Manuel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manuel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manuel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manuel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manuel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private imagehandler.Circle circle1;
    private javax.swing.JLabel daireLog;
    private imagehandler.Dikdörtgen dikdörtgen1;
    private javax.swing.JLabel diktLog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel kalanLog;
    private imagehandler.Kare kare1;
    private javax.swing.JLabel kareLog;
    private javax.swing.JLabel kullanılanLog;
    private javax.swing.JPanel kumas;
    private imagehandler.Ucgen square1;
    private javax.swing.JButton tekrar;
    private imagehandler.Ucgen ucgen1;
    private javax.swing.JLabel ucgenLog;
    // End of variables declaration//GEN-END:variables
}
