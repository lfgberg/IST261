/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package setelementchooser;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Liam Geyer
 */
public class Chooser<T> {
    private final Set<T> choiceList;
    
    public Chooser(Collection<T> choices){
        this.choiceList = new HashSet<>(choices);
    }
    

    /*
        The only way that I could think to use an iterator, is to gen a random number,
        and then iterate that many times. It didn't feel efficient to me but it does the job.
    */
    public T choose(){
         Iterator<T> iter = choiceList.iterator();
         int rnd = ThreadLocalRandom.current().nextInt(choiceList.size() - 1);
        
         for (int i = 0; i < rnd; i++){
             iter.next();
         }
         
         return iter.next();
    }
}
