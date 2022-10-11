/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listgettimer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lfgab
 */
public class ListGetTimer {

    final int CONSTANT = 1000000;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        List<Integer> linked = new LinkedList<>();
        
        for (int i = 0; i < 10000; i++){
            int rand = getRand();
            array.add(rand);
            linked.add(rand);
        }
        
        long startTime = System.nanoTime();
        array.get(getRand());
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        
        startTime = System.nanoTime();
        linked.get(getRand());
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
    
    public static int getRand(){
        return (int) (Math.random()*9999) + 1;
    }
    
}
