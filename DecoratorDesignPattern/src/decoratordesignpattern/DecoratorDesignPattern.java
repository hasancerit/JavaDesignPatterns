package decoratordesignpattern;

import component.EvEsyasi;

public class DecoratorDesignPattern {
    public static void main(String[] args) {
        EvEsyasi ayna = new CerceveliAyna();
        System.out.println("Olusan:"+ayna.hashCode());
        ayna.produce(); 
    }    
}
