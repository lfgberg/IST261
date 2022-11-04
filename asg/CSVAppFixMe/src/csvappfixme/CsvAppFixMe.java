package csvappfixme;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvValidationException;
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
        List<GeographicRegion> regionList = null;
        try {
            regionList = populateList("RegionsAndAreas.csv");
        } catch (IOException | CsvValidationException ex) {
            Logger.getLogger(CsvAppFixMe.class.getName()).log(Level.SEVERE, null, ex);
        }
        Chooser<GeographicRegion> chooser = new Chooser<>(regionList);
        
        for (int i = 0; i < 10; i++){
            System.out.println(chooser.choose());
        }
    }

    public static List<GeographicRegion> populateList(String fileName) throws IOException, CsvValidationException {
        CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(fileName));
        List<GeographicRegion> result = new ArrayList<>();
        
        for (int i = 0; i < 266; i++){
            Map<String, String> values = reader.readMap();
            result.add(new GeographicRegion(values.get("Country Name"), values.get("2020")));
        }
           
        return result;      
    }

}
