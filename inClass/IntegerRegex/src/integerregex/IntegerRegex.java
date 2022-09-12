package integerregex;

/**
 * INSTRUCTIONS:
 *
 * Write the same regular expression inside the quotation marks in the two
 * matches methods below so that 
 * 
 * the regular expression you write
 *
 * 1. matches any String that begins with two or more digits, followed
 * immediately by one or more whitespace characters, which are followed 
 * immediately by exactly two digits, which are the last characters in the String.
 *
 * 2. uses only \s, \d, and +, appropriately arranged and escaped
 *
 * Your program must run without errors and print true then false,
 * based on a correct regular expression that you write inside the matches method.
 *
 * Be sure to write the *same* regular expression inside both matches methods.
 * 
 * Do not change any other code that is given in this program.
 *
 * GRADING CRITERIA:
 *
 * 100 points if your program does what is asked for in the instructions
 *
 * 0 points, otherwise
 *
 * RESTRICTIONS: The only allowed resources are NetBeans and your brain.
 *
 *
 */
public class IntegerRegex {

    public static void main(String[] args) {
        String text = "222 \t\r\n  44";
        String moreText = "2\f\n 44 ";
        System.out.println(text.matches("(\\d+)(\\s+)\\d\\d"));
        System.out.println(moreText.matches("(\\d+)(\\s+)\\d\\d"));
    }

}
