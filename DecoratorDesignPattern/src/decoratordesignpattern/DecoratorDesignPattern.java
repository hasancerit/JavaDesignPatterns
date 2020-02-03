package decoratordesignpattern;

import component.EvEsyasi;

public class DecoratorDesignPattern {
    public static void main(String[] args) {
        
/*
 * new ile Bu CerceveliAyna nesnesi olustururuz.
 * CerceveliAyna nesnesi ayni zamanda bir AynaDecorator'dur.AynaDecarotor abst sinifi ayni zamanda EvEsyasi miras aldiği 
 * icin, kendisi de bir EvEsyasidir(Ayna üst sinifi). 
 * dolayısıyla bu siniftan nesne türettigimizde, bir ayna nesnesi daha olusturmus oluruz ve bu nesneye ekledigimiz
 * ek ozellikler de bu nesne ile dönmüs olur
*/
        
        EvEsyasi ayna = new CerceveliAyna();
        ayna.produce();
        
    }    
}
