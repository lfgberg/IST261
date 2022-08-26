package xlintwarning;

import java.util.ArrayList;
import java.util.List;

/**
 * INSTRUCTIONS:
 * 
 * Complete this program so that it doesn't show the Xlint warning when it is cleaned and built.
 * 
 * GRADING: 
 * 
 * 100 points if program does not show the Xlint warning when it is cleaned and built;
 * 0 points otherwise.
 * 
 * RESTRICTIONS: The only allowed resources are NetBeans, your brain, and the Web.
 * 
 */
public class XlintWarning {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(0);
        System.out.println("The listOfInteger is " + listOfIntegers.toString());
    }  
}
