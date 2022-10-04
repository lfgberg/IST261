/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package setelementchooser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Liam Geyer
 */
public class SetElementChooser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Set<Coin> coins = genCoins();
        Chooser chooser = new Chooser(coins);
        
        for (int i = 0; i < 10; i++){
            System.out.println(chooser.choose());
        }
    }
    
    private static Set<Coin> genCoins(){
        return new HashSet(List.of(new Coin("quarter", .25), new Coin("penny", .01), new Coin("dollar", 1.0),
                new Coin("nickel", .05), new Coin("dime", .10), new Coin("half dollar", .50)));
    }
    
}
