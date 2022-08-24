package findmax;

import java.util.Arrays;
import java.util.List;


/**
 * INSTRUCTIONS:
 * 
 * Complete the calculateMaximum method by writing an algorithm to calculate
 * the maximum value of a List of Integers.
 * 
 * NOTE: Your algorithm will need to traverse all elements of the list
 * 
 * GRADING CRITERIA: 
 * 
 * 100 points if 
 * 
 *  your algorithm is correct and complete,
 *  it works for both lists given, and
 *  it uses the parameter variable numbers in the calculateMaximum method
 * 
 * 0 points otherwise.
 * 
 * RESTRICTIONS: The only allowed resources are NetBeans and your brain.
 * 
 * 
 */
public class FindMax {

    public static void main(String[] args) {
        
        List<Integer> firstListOfIntegers = Arrays.asList(9, -7, 15, 0, 2, 22, 19, 8, 4, 25);
        
        List<Integer> secondListOfIntegers = Arrays.asList(1, 5, -15, 35, -8, 4, 9, 47, 22, -6, 47);
       
        
        System.out.println("The maximum of " + firstListOfIntegers + " is " +
                calculateMaximum(firstListOfIntegers));
        
        System.out.println("The maximum of " + secondListOfIntegers + " is " +
                calculateMaximum(secondListOfIntegers));
    }
    
    private static int calculateMaximum(List<Integer> numbers) {
        int currentMax = numbers.get(0);
        
        for (int num : numbers){
            if (num > currentMax){
                currentMax = num;
            }
        }
        
        return currentMax;
    }

}
