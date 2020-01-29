/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

/**
 *
 * @author Hasan
 */
public class Server implements Computer{
    private String ram;

    public Server(String ram) {
        this.ram = ram;
    }
    
    @Override
    public void getRam() {
        System.out.println("Server:"+this.ram);
    }
}
