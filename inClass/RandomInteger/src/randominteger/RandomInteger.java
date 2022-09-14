package randominteger;


/**
 * INSTRUCTIONS: Modify the code below so that the for loop prints to 
 * the console ten random integers (repeats allowed) from 1 through 60.
 * Add whatever code you need to do that.
 * 
 * 
 * GRADING CRITERIA: 
 * 
 * 100 points if your code follows the instructions above.
 * 
 * 0 points, otherwise
 * 
 * RESTRICTIONS: The only allowed resources are NetBeans and your brain.
 * 
 * 
 */
public class RandomInteger {

    public static void main(String[] args) {
        
        for (int i = 0; i < 10; i++) {
            //  rand int 1-60
            int rand = (int)(Math.random()*60+1);
            
            System.out.println(rand);
        }
    }
    
}
