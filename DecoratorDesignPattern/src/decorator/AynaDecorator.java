/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

import component.Ayna;
import component.EvEsyasi;

/**
 *
 * @author Hasan
 */

/*
* Ayna Implemantasyonuna ek ozellikler eklemek icin, bu decorator sinifini yarattik.
* Ornegin Ayna'ya ek metod eklemek istersek(border), CerceveAyna adlı bir siniff olusturup bu siniftan miras alınır.
*/
public abstract class AynaDecorator implements EvEsyasi{
    /*
    * Bu nesne, Ayna nesnesinin saf hali icin burada,
    *yani üzerine herhangi bir metod,ozellik eklenmemiş hali bu nesne ile saglaniyor.
    */
     private EvEsyasi ayna = new Ayna();
     
     public EvEsyasi getAyna(){
         return ayna;
     }
   
     public void setAyna(EvEsyasi ayna){
         this.ayna = ayna;
     } 

     /*
    @Override
    public abstract void produce();
    */
     
}
