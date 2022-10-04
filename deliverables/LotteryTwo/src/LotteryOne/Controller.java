package LotteryOne;

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
    
    public List<Integer> getResults(){
        return model.getResults();
    }
    
    public List<Integer> getInput(){
        return model.getInput();
    }
    
    /**
     * Finds out if the user entered any winning numbers
     * @return a List of the winning numbers
     */
    public List<Integer> drawLotto(){
        //  draw a new set of numbers to work with
        this.drawResults();
        
        List<Integer> winners = new ArrayList<>();
        
        //  loop through the drawn numbers, add any winners
        for (Integer entry : model.getResults()){
            if (model.getInput().contains(entry)){
                winners.add(entry);
            }
        }
        
        return winners;
    }
    
    /**
     * Draws 6 numbers to be the lottery results
     */
    private void drawResults(){
        List<Integer> results = model.getResults();
        results.clear();
        
        //  draw nums until we reach 6
        while (results.size() != 6){
            
            //  rand int 1-60
            int rand = (int)(Math.random()*60+1);
            
            //  add if not present
            if (!results.contains(rand)){
                results.add(rand);
            }
        }
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
        if (input.matches("((\\d){1,2}\\s+){5}((\\d\\s*){1,2})")){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean validateDrawings(String input){
        if (input.matches("[1-9]|10")){
            return true;
        } else {
            return false;
        }
    }
    
    private List<Integer> parseInput(String input){
        //  split the string into an array of ints
        String[] splitInput = input.split("\\s+");
         List<Integer> parsedInput = new ArrayList<>();
         for (String entry : splitInput){
             parsedInput.add(Integer.parseInt(entry));
         }
         return parsedInput;
    }
    
    public void setInput(String input){
        List<Integer> parsedInput = this.parseInput(input);
        model.setInput(parsedInput);
    }
    
    /**
     * @return a well formed error string based on the previous validation methods 
     */
    public String validateInput(String input){
        //  If the first check is failed, no need to continue
        if (!this.isInFormat(input)){
            return "the input is not exactly just six different one- or two-digit integers separated by one or more spaces";
        }
        
        //  split the string into an array of ints, perform further validation
         List<Integer> parsedInput = this.parseInput(input);
        
        boolean inRange = this.withinRange(parsedInput);
        boolean hasDupes = this.containsDuplicates(parsedInput);
        
        StringBuilder errorMessage = new StringBuilder();
        
        if (!inRange){
            errorMessage.append("the input contains an integer that is out of bounds");
        }
        if (hasDupes){
            errorMessage.append("the input contains duplicate integers.");
        }
        
        return errorMessage.toString();
    }
}
