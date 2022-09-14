package sumcalculator;

import java.util.List;

public class Model {

    private int sum;
 
    public Model() {
        sum = 0;
    }

    public int computeSum(List<Integer> input) {
        for (int entry : input){
            sum = sum + entry;
        }
        return sum;
    }

}
