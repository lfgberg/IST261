package LotteryOne;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<Integer> input, results;
 
    public Model() {
        this.input = new ArrayList<>();
        this.results = new ArrayList<>();
    }
    
    public List<Integer> getResults(){
        return this.results;
    }
    
    public List<Integer> getInput(){
        return this.input;
    }
    
    public void setInput(List<Integer> input){
        this.input = input;
    }
}
