/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hasan
 */

/*
*Client gercek Internet interface'i üzerinden, gercekInternet nesnesine ulasmıs gibi davranıyor.
*ama Internet interface'i üzerinden sinifa ulasir. Bu sinifta kontroller yapılarak, realInternete erisim saglanir. 
*/
public class ProxyInternet implements Internet{
    private Internet internet = new RealInternet(); 
    private static List<String> bannedSites;
      
    static
    { 
        bannedSites = new ArrayList<String>(); 
        bannedSites.add("abc.com"); 
        bannedSites.add("def.com"); 
        bannedSites.add("ijk.com"); 
        bannedSites.add("lnm.com"); 
    } 
      
    @Override
    public void connectTo(String serverhost) throws Exception{ 
        if(bannedSites.contains(serverhost.toLowerCase())) 
        { 
            throw new Exception("Access Denied"); 
        }
        internet.connectTo(serverhost); 
    } 
  
}
