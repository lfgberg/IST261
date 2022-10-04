/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package setelementchooser;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
    I don't really understand what's expected here becuase the original choice method doesn't use a for loop
    */
    public T choose(){
        // this isnt random.
        Iterator value = choiceList.iterator();
        return (T) value.next();
    }
}
