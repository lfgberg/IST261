package csvappfixme;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * data in RegionsAndAreas.csv, from 
 * http://api.worldbank.org/v2/en/indicator/AG.LND.TOTL.K2?downloadformat=csv
 * Retrieved 2022-04-22
 * data cleaned to start with header row
 */
public class CsvAppFixMe {

    public static void main(String[] args) {
        List<GeographicRegion> regionList = populateList("RegionsAndAreas.csv");
        //Chooser<GeographicRegion> chooser = new Chooser<>(regionList);
        
        //for (int i = 0; i < 10; i++){
        //    System.out.println(chooser.choose());
        //}
    }

    public static List<GeographicRegion> populateList(String fileName){
        try {
            Map<String, String> values = new CSVReaderHeaderAware(new FileReader(fileName)).readMap();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException | CsvValidationException ex ){
            System.out.println(ex.getMessage());
        }
                
        return new ArrayList<>();       
    }

}
