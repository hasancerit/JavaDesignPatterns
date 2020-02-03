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
* Diyelim ki Ayna Implemantasyonunun produce metodunda ek olarak baska bir metod cagirmak istedik.
* Bunun icin bu decorator sinifini yarattik.
* Ornegin produce metodunda ek oalrak border metodunu cagirmak istersek, CerceveAyna adlı bir sinif olusturup bu siniftan miras alırız.
*/
public abstract class AynaDecorator implements EvEsyasi{
    /*
    * Bu nesne, Ayna nesnesinin saf hali icin burada,
    * produce metodunun saf hali icin bunu kullanacagiz.
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
