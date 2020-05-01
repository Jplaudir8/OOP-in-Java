
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
    
    /**
     * Initialize records ArrayList.
     */
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
     * Compute ArrayList of Strings of unique IP addresses that had access on the given day, using the param 'someday'.
     *
     * @param   someday     Date that will be used to look up for the IP addresses. 
     *                      Example of format to be received in the param: "Sep 14", "Sep 30".
     * @return              ArrayList of IP addresses that accessed the site on that day.
     */
    public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> ipsInDay = new ArrayList<String>();
        for(LogEntry le : records) {
            String dateStr = le.getAccessTime().toString();
            if(dateStr.indexOf(someday) != -1 && !ipsInDay.contains(le.getIpAddress())) {
                ipsInDay.add(le.getIpAddress());
            }
        }
        return ipsInDay;
    }
    
    /**
     * Compute the number of unique IP addresses in records that have a status 
     * code in the range from low to high, inclusive.
     * 
     * @param   low     cutoff
     * @param   high    cutoff
     * 
     * @return          number of IPs that have status code in the range provided.
     */
    public int countUniqueIPsInRange(int low, int high) {
        ArrayList<String> ipsInRange = new ArrayList<String>();
        for(LogEntry le : records) {
            String ipAddress = le.getIpAddress();
            int statusCode = le.getStatusCode();
            if(!ipsInRange.contains(ipAddress) && statusCode >= low && statusCode <= high) {
                ipsInRange.add(ipAddress);
            }
        }
        return ipsInRange.size();
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
