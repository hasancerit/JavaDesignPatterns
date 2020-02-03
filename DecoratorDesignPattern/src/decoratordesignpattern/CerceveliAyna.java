/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoratordesignpattern;

import decorator.AynaDecorator;
/**
 *Ayna impinde bir degisiklik(Produce metodunda baska bir ek metod cagirmak gibi) burada yapilir.
 *AynaDecorator abst sinifi icinde olusturulan(comp) ayna nesnesi, Ayna sinifinda degisiklik yapilmayan saf halidir.
 *
 * Produce metoduna ek olarak ekleyecegimiz, addBorder metodunu burada yazdik. 
 * Bu sinifin kendisi ayni zamanda bir EvEsyasi dolayasi ile ayna oldugu icin(AynaDecorator'den) produce metodunu override ettik
 * bu produce metodunun icinde once saf ayna produce metodunu cagirdik.(AynaDecorator'dan comp ile gelen nesne ile)
 * daha sonra ek olarak cagiracagimiz addBorder'ı ekledik.
 */
public class CerceveliAyna extends AynaDecorator{
    /*
    * AynaDecorator abst classından gelen;
    * private EvEsyasi ayna = new Ayna(); 
    */
    
    @Override
    public void produce() {
        getAyna().produce(); //Aynanin saf hali
        addBorder();         //Ek metod
    }

    public void addBorder(){
        //getAyna()... islemler
        System.out.print(this.hashCode()+":");
        System.out.println("Aynaya cerceve eklendi.");
    } 

}
