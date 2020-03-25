
/**
 * Write a description of CSVMax here.
 * 
 * @author Joan Perez Lozano
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {
    public CSVRecord hottestHourInFile(CSVParser parser) {
        CSVRecord largestSoFar = null;
        for(CSVRecord currentRow: parser) {
            largestSoFar  = getLargestOfTwo(currentRow, largestSoFar);
        }
        return largestSoFar;
    }

    public CSVRecord hottestInManyDays() {
        
        DirectoryResource dr = new DirectoryResource();
        CSVRecord largestSoFar = null;

        for(File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
        return largestSoFar;
    }

    public CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar) {
        if(largestSoFar == null){
            largestSoFar = currentRow;
        } else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));                
            if (currentTemp > largestTemp){
                largestSoFar = currentRow;
            }
        }
        return largestSoFar;
    }

    public void testHottestDay() {
        FileResource fr = new FileResource("data/2015/weather-2015-01-01.csv");
        CSVParser parser = fr.getCSVParser();
        CSVRecord largest = hottestHourInFile(parser);
        System.out.println("hottest temperature was " + largest.get("TemperatureF") +
                            " at " + largest.get("TimeEST"));
    }

    public void testHottestInManyDays() {
        CSVRecord largest = hottestInManyDays();
        System.out.println("hottest temperature was " + largest.get("TemperatureF") +
        " at " + largest.get("DateUTC"));
    }
}