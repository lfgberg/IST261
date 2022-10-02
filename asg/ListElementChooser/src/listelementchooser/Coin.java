/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listelementchooser;

/**
 *
 * @author Liam Geyer
 */
public class Coin {
    private final String name;
    private final double value;
    
    public Coin(String name, double value){
        this.name = name;
        this.value = value;
    }
    
    @Override
    public String toString(){
        return String.format("%s: %.2f", name, value);
    }
}
