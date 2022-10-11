package csvappfixme;

import java.util.ArrayList;
import java.util.List;


/**
 * data in RegionsAndAreas.csv, from 
 * http://api.worldbank.org/v2/en/indicator/AG.LND.TOTL.K2?downloadformat=csv
 * Retrieved 2022-04-22
 * data cleaned to start with header row
 */
public class CsvAppFixMe {

    public static void main(String[] args) {
        List<GeographicRegion> regionList = null;
    }

    public static List<GeographicRegion> populateList(String fileName) {
        return new ArrayList<>();       
    }

}
