
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

/**
 * Write a description of BabyBirths here.
 * 
 * @author Joan Perez Lozano
 */

public class BabyBirths {
    public void printNames() {
        FileResource fr = new FileResource();
        
        // Sending false to getCSVParser() means there is no header row.
        for(CSVRecord rec: fr.getCSVParser(false)){ 
            int numBorn = Integer.parseInt(rec.get(2));
            if(numBorn <= 100){
                System.out.println("Name " + rec.get(0) + 
                                " Gender " + rec.get(1) + 
                                    " Num Born " + rec.get(2));
            }
        }
        
    }
    
    public void totalBirths(FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int boyNames = 0;
        int girlNames = 0;
        int totalNames = 0;
        
        for(CSVRecord rec: fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if(rec.get(1).equals("M")) {
                totalBoys += numBorn;
                boyNames++;
            } else {
                totalGirls += numBorn;
                girlNames++;
            }
        }
        
        totalNames = boyNames + girlNames;
        
        System.out.println("total births = " + totalBirths);
        System.out.println("total girls = " + totalGirls);
        System.out.println("total boys = " + totalBoys);
        System.out.println("There are " + totalNames + " different names in total.");
        System.out.println("There are " + girlNames + " different girl names in total.");
        System.out.println("There are " + boyNames + " different boy names in total.");
    }
    
    public void testTotalBirths() {
        FileResource fr = new FileResource("data/us_babynames_test/yob2012short.csv");
        totalBirths(fr);
    }
    
    public int getRank(int year, String name, String gender) {
        int rank = 0;
        
        FileResource fr = new FileResource("data/us_babynames_by_year/yob"+year+".csv");
        CSVParser parser = fr.getCSVParser(false);
        
        for(CSVRecord r: parser) {
            if(r.get(1).equals(gender)) {
                rank++;
                if(r.get(0).equals(name)){
                    return rank;
                } 
            }
        }
        return -1;
    }
    
    public String getName(int year, int rank, String gender) {
        
        FileResource fr = new FileResource("data/us_babynames_by_year/yob"+year+".csv");
        CSVParser parser = fr.getCSVParser(false);
        if(rank >= 1 ) {
            for(CSVRecord r: parser) {
                if(r.get(1).equals(gender)) {
                    if(rank == 1) {
                        return r.get(0);
                    }
                    rank--;
                }
            }
        }
        return "NO NAME";
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        int rank = getRank(year, name, gender);
        String nameFound = getName(newYear, rank, gender);
        
        System.out.println(name + " born in " + year + " would be " + 
                            nameFound + " if she was born in " + newYear);
    }
    
    public int yearOfHighestRank(String name, String gender) {
        int lowestRankSoFar = 0;
        int bestYear = -1;
        
        DirectoryResource dr = new DirectoryResource();
        
        for (File f: dr.selectedFiles()) {
            String filename = f.getName().toLowerCase();
            int indexPos = filename.indexOf("yob");
            String yearStr = "";
            int year = 0;
            // Here we obtain the year based on the filename
            if(indexPos != -1 && indexPos+7 < filename.length()) {
                yearStr = filename.substring(indexPos + 3, indexPos + 7);
                year = Integer.parseInt(yearStr);
            }
            
            int currentRank = getRank(year, name, gender);
            System.out.println(year+" "+name+" "+gender);
            if (currentRank != -1){
                if(lowestRankSoFar == 0 || currentRank < lowestRankSoFar) {
                    lowestRankSoFar = currentRank;
                    bestYear = year;
                }
            }
            
        }
        return bestYear;
    }
    
    public double getAverageRank(String name, String gender) {
        int count = 0;
        int sumRanks = 0;
        
        DirectoryResource dr = new DirectoryResource();
        
        for (File f: dr.selectedFiles()) {
            String filename = f.getName().toLowerCase();
            int indexPos = filename.indexOf("yob");
            String yearStr = "";
            int year = 0;
            // Here we obtain the year based on the filename
            if(indexPos != -1 && indexPos+7 < filename.length()) {
                yearStr = filename.substring(indexPos + 3, indexPos + 7);
                year = Integer.parseInt(yearStr);
            }
            
            int currentRank = getRank(year, name, gender);
            
            if (currentRank != -1){
                sumRanks += currentRank;
                count++;
            }
        }
        return (double)sumRanks/count;
    }
    
    public int getTotalBirthsRankedHigher (int year, String name, String gender) {
        int sumBirths = 0;
        int nameRank = getRank(year, name, gender);
        FileResource fr = new FileResource("data/us_babynames_test/yob"+year+"short.csv");
        CSVParser parser = fr.getCSVParser(false);

        for(CSVRecord r: parser) {
            int currentRank = getRank(year, r.get(0), r.get(1));
            if(!r.get(0).equals(name) && r.get(1).equals(gender) && currentRank <= nameRank){
                sumBirths += Integer.parseInt(r.get(2));
            }
        }
        
        return sumBirths;
    }
    
    
    
    
    
    
    
    
}
    
    
    
    
   
