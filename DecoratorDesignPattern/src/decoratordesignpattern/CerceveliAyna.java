/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoratordesignpattern;

import decorator.AynaDecorator;

/**
 *Ayna impine yeni bir metod vs. buradan eklenir. AynaDecorator sinifi miras alınır.
 *AynaDecorator abst sinifi icinde olusturulan(comp) ayna nesnesi, Ayna sinifina metod eklenmeyen saf halidir.
 *
 *
 *Ayna'ya ek bir özellik eklemek istediğimizde buraya ekleriz. ve 
 * new ile Bu nesneyi olustururuz.
 * Bu nesne ayni zamanda bir AynaDecorator'dur.AynaDecarotor abst sinifi ayni zamanda EvEsyasi miras aldiği 
 * icin, kendisi de bir EvEsyasidir(Ayna üst sinifi). 
 * dolayısıyla bu siniftan nesne türettigimizde, bir ayna nesnesi daha olusturmus oluruz ve bu nesneye ekledigimiz
 * ek ozellikleri kullanabiliriz.
 */
public class CerceveliAyna extends AynaDecorator{
    /*
    * AynaDecorator abst classından gelen;
    * private EvEsyasi ayna = new Ayna(); 
    */
    
    @Override
    public void produce() {
        System.out.print(getAyna().hashCode()+":");
        getAyna().produce();
        addBorder();       
    }
    
    /*
    * Cerceve ekleme islemini gerceklestirmek
    * için kullanilan metod.
    */
    public void addBorder(){
        //getAyna()... islemler
        System.out.print(this.hashCode()+":");
        System.out.println("Aynaya cerceve eklendi.");
    } 

}
