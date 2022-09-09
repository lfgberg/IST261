package sumcalculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Controller {

    private final Model model;
    private final View view;

    public Controller() {
        model = new Model();
        view = new View(this);
    }
     
    public void showView() {
        view.displaySelf();
    }
    
    public int computeSum(String input){
        //  split the string into an array of ints, perform further validation
        String[] splitInput = input.split("\\s+");
         List<Integer> parsedInput = new ArrayList<>();
         for (String entry : splitInput){
             parsedInput.add(Integer.parseInt(entry));
         }
        
        return model.computeSum(parsedInput);
    }
    
    /**
     * Determines if a List of integers contains duplicates
     * @param input List of ints to check
     * @return true if the list contains duplicates
     */
    private boolean containsDuplicates(List<Integer> input){
        Set<Integer> noDupes = new HashSet<>();
       for (int entry : input){
           if (noDupes.contains(entry)){
               return true;
           } else {
               noDupes.add(entry);
           }
       }
        return false;
    }
    
    /**
     * Determines if a list of integers is within the range of 1-60
     * @param input List of ints to check
     * @return false if one or more of the integers is out of range
     */
    private boolean withinRange(List<Integer> input){
        for (int entry : input){
            if (entry > 60 || entry < 1){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Checks if a string conforms to the 6 1-2 digit ints seperated by whitespace
     * @param input
     * @return 
     */
    private boolean isInFormat(String input){
        if (input.matches("((\\d){1,2}\\s+){5}((\\d){1,2})")){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @return a well formed error string based on the previous validation methods 
     */
    public String validateInput(String input){
        //  If the first check is failed, no need to continue
        if (this.isInFormat(input)){
            return "the input is not exactly just six different one- or two-digit integers separated by one or more spaces";
        }
        
        //  split the string into an array of ints, perform further validation
        String[] splitInput = input.split("\\s+");
         List<Integer> parsedInput = new ArrayList<>();
         for (String entry : splitInput){
             parsedInput.add(Integer.parseInt(entry));
         }
        
        boolean inRange = this.withinRange(parsedInput);
        boolean hasDupes = this.containsDuplicates(parsedInput);
        
        if (!inRange && hasDupes){
            return "the input contains an integer that is out of bounds; the input contains duplicate integers.";
        } else if (!inRange){
            return "the input contains an integer that is out of bounds.";
        } else if (hasDupes){
            return "the input contains duplicate integers.";
        } else return "";
    }
}
