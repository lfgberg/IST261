package sumcalculator;

import java.util.List;

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
    
    public int computeSum(List<Integer> input){
        return model.computeSum(input);
    }
    
    /**
     * Determines if a List of integers contains duplicates
     * @param input List of ints to check
     * @return true if the list contains duplicates
     */
    public boolean containsDuplicates(List<Integer> input){
        for (int i = 0; i < input.size(); i++){
                for (int j = i + 1; j < input.size(); j++){
                    if (input.get(i) == input.get(j)){
                        return true;
                    }
                }
            }
        return false;
    }
    
    /**
     * Determines if a list of integers is within the range of 1-60
     * @param input List of ints to check
     * @return false if one or more of the integers is out of range
     */
    public boolean withinRange(List<Integer> input){
        for (int entry : input){
            if (entry > 60 || entry < 1){
                return false;
            }
        }
        return true;
    }
}
