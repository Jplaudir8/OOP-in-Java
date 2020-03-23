
/**
 * Write a description of ParseExportData here.
 * 
 * @author Joan Perez Lozano
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class ParseExportData {
    
    public String countryInfo(CSVParser parser, String country){
        for(CSVRecord r: parser){
            if(r.get("Country").contains(country)){
                return r.get("Country") + ": " + r.get("Exports") + ": " +r.get("Value (dollars)");
            } 
        }
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts(CSVParser parser, 
                                         String exportItem1, 
                                         String exportItem2){
        for(CSVRecord r: parser){
            if(r.get("Exports").contains(exportItem1) && r.get("Exports").contains(exportItem2)){
                System.out.println(r.get("Country"));
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int countExp = 0;
        for(CSVRecord r: parser){
            if(r.get("Exports").contains(exportItem)){
                countExp++;
            }
        }
        return countExp;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        for(CSVRecord r: parser){
            if(r.get("Value (dollars)").length() > amount.length()){
                System.out.println(r.get("Country") + " " + r.get("Value (dollars)"));
            }
        }
    }
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser, "Germany"));
        
        //listExportersTwoProducts(parser, "gold", "diamonds");
        
        //int nExp = numberOfExporters(parser, "gold");
        //System.out.println("There are "+nExp+" exporters of gold");
        
        bigExporters(parser, "$999,999,999");
    }
}
