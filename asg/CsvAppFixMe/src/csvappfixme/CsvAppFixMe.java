package csvappfixme;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * data in RegionsAndAreas.csv, from 
 * http://api.worldbank.org/v2/en/indicator/AG.LND.TOTL.K2?downloadformat=csv
 * Retrieved 2022-04-22
 * data cleaned to start with header row
 */
public class CsvAppFixMe {

    public static void main(String[] args) {
        List<GeographicRegion> regionList = populateList("RegionsAndAreas.csv");
        Chooser<GeographicRegion> chooser = new Chooser<>(regionList);
        
        for (int i = 0; i < 10; i++){
            System.out.println(chooser.choose());
        }
    }

    public static List<GeographicRegion> populateList(String fileName) {
        Map<String, String> values = new CSVReaderHeaderAware(new FileReader("yourfile.csv")).readMap();
        return new ArrayList<>();       
    }

}
