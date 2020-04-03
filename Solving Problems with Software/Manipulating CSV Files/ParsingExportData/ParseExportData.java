
/**
 * Write a description of ParseExportData here.
 * 
 * @author Joan Perez Lozano
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class ParseExportData {
    
    // Using variables since column names are prone to change
    private String COUNTRY_COLUMN = "Country";
    private String EXPORTS_COLUMN = "Exports";
    private String VALUE_COLUMN = "Value (dollars)";

    public String countryInfo(CSVParser parser, String country){
        for(CSVRecord r: parser){
            if(r.get(COUNTRY_COLUMN).contains(country)){
                return r.get(COUNTRY_COLUMN) + ": " + r.get(EXPORTS_COLUMN) + ": " +r.get(VALUE_COLUMN);
            } 
        }
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts(CSVParser parser, 
                                         String exportItem1, 
                                         String exportItem2){
        for(CSVRecord r: parser){
            if(r.get(EXPORTS_COLUMN).contains(exportItem1) && r.get(EXPORTS_COLUMN).contains(exportItem2)){
                System.out.println(r.get(COUNTRY_COLUMN));
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int countExp = 0;
        for(CSVRecord r: parser){
            if(r.get(EXPORTS_COLUMN).contains(exportItem)){
                countExp++;
            }
        }
        return countExp;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        for(CSVRecord r: parser){
            if(r.get(VALUE_COLUMN).length() > amount.length()){
                System.out.println(r.get(COUNTRY_COLUMN) + " " + r.get(VALUE_COLUMN));
            }
        }
    }
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser, "Nauru"));
        
        //listExportersTwoProducts(parser, "cotton", "flowers");
        
        //String expName = "cocoa";
        //int nExp = numberOfExporters(parser, expName);
        //System.out.println("There are "+nExp+" exporters of " + expName);
        
        bigExporters(parser, "$999,999,999,999");
    }
}
