/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listelementchooser;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Liam Geyer
 */
public class ListElementChooser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Coin> coins = genCoins();
        Chooser<Coin> chooser = new Chooser<>(coins);
        
        for (int i = 0; i < 10; i++){
            System.out.println(chooser.choose());
        }
    }
    
    private static ArrayList<Coin> genCoins(){
        return new ArrayList<>(List.of(new Coin("quarter", .25), new Coin("penny", .01), new Coin("dollar", 1.0),
                new Coin("nickel", .05), new Coin("dime", .10), new Coin("half dollar", .50)));
    }
    
}
