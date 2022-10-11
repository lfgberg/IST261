package LotteryThree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {

    private List<Integer> lotteryNumbers = new ArrayList<>();
    private final List<Integer> drawingResults = new ArrayList<>();
    private int simulations;
    private final Map<Integer, Integer> results = new HashMap<>();
    
    public Map<Integer, Integer> getResults(){
        return this.results;
    }
    
    public void clearResults(){
        results.put(0, 0);
        results.put(1, 0);
        results.put(2, 0);
        results.put(3, 0);
        results.put(4, 0);
        results.put(5, 0);
        results.put(6, 0);
    }
    
    public List<Integer> getDrawingResults(){
        return this.drawingResults;
    }
    
    public List<Integer> getInput(){
        return this.lotteryNumbers;
    }
    
    public void setInput(List<Integer> input){
        this.lotteryNumbers = input;
    }
    
    public void setSimulations(int simulations){
        this.simulations = simulations;
    }
    
    public int getSimulations(){
        return this.simulations;
    }
}
