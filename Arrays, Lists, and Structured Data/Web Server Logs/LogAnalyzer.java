
/**
 * Write a description of LogAnalyzer here.
 * 
 * @author Joan Perez Lozano
 */
import java.util.*;
import edu.duke.*;

public class LogAnalyzer {
    /**
     * This instance variable will store records of log entries.
     */
    private ArrayList<LogEntry> records;
    
    public LogAnalyzer() {
        records = new ArrayList<LogEntry>();
    }
    
    /**
     * Read log file and add each line to 'records'.
     */
    public void readFile(String filename) {
        FileResource fr = new FileResource("data/" + filename);
        for(String line : fr.lines()){
            LogEntry le = WebLogParser.parseEntry(line);
            records.add(le);
        }
    }
    
    /**
     * Compute the number of unique IP addresses based on the elements
     * that have been inserted into 'records'.
     * 
     * @return  The number of unique IP addresses
     */
    public int countUniqueIPs() {
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for(LogEntry le : records) {
            String ipAddr = le.getIpAddress();
            if(!uniqueIPs.contains(ipAddr)) {
                uniqueIPs.add(ipAddr);
            }
        }
        return uniqueIPs.size();
    }
    
    /**
     * Print all log entries that have a status code greater than 'num' param.
     * 
     * @param   num     the cutoff number that will be used to print.
     */
    public void printAllHigherThanNum(int num) {
        for(LogEntry le : records) {
            int statusCode = le.getStatusCode();
            if(statusCode > num) {
                System.out.println(le);
            }
        }
    }
    
    public void printAll() {
        for(LogEntry le : records) {
            System.out.println(le); // Automatically calls toString(function)
        }
    }
}
