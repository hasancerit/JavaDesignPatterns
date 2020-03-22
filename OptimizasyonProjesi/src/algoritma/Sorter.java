/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritma;

import java.util.Comparator;

/**
 *
 * @author Hasan Cerit
 */
public class Sorter implements Comparator<Kromozom>{

    @Override
    public int compare(Kromozom o1, Kromozom o2) {
        Double kalan1 = o1.kalanAlan;
        Double kalan2 = o2.kalanAlan;
        return kalan1.compareTo(kalan2);
    }
    
}
