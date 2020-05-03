
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
     * Compute the number of visits per Ip address to a website.
     * 
     * @return      a HashMap which stored the number of ocurrences.
     */
    public HashMap<String, Integer> countVisitsPerIP(){
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        for(LogEntry le : records){
            String ip = le.getIpAddress();
            if(!counts.containsKey(ip)) {
                counts.put(ip, 1);
            } else {
                counts.put(ip, counts.get(ip) + 1);
            }
        }
        return counts;
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
    
    /**
     * Calculate the maximum number of visits to a website by a single IP
     * 
     * @param   map     HashMap that contains a map of an IP address to the 
     *                  number of visits of an IP address to a site.
     *                  
     * @return          maximum number encountered.
     */
    public int mostNumberVisitsByIP(HashMap<String, Integer> map) {
        int max = 0;
        for(Integer n : map.values()) {
            if(n > max) {
                max = n;
            }
        }
        return max;
    }
    
    /**
     * Calculate ArrayList of Strings of IP addresses that all have the 
     * maximum number of visits to this website.
     * 
     * @param   map     HashMap that contains a map of an IP address to the 
     *                  number of visits of an IP address to a site.
     * @return          ArrayList of Strings with the IP addresses found.
     */
    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> map) {
        int max = mostNumberVisitsByIP(map);
        ArrayList<String> ipsMax = new ArrayList<String>();
        for(String s : map.keySet()) {
            if(map.get(s) == max) {
                ipsMax.add(s);
            }
        }
        return ipsMax;
    }
    
    /**
     * Creates a HashMap that maps days to an ArrayList of IP's that visited
     * the website in their respective days. Repeated IP addresses are allowed.
     * 
     * @return  HashMap of days to their IP addresses.
     */
    public HashMap<String, ArrayList<String>> ipsForDays() {
       HashMap<String, ArrayList<String>> ipsDay = new HashMap<String, ArrayList<String>>();
       for(LogEntry le : records) {
           // Trimming date to the format needed.
           String dateFmt = le.getAccessTime().toString().substring(4, 10);
           if(ipsDay.containsKey(dateFmt)){
               ArrayList<String> ips = ipsDay.get(dateFmt);
               ips.add(le.getIpAddress());
               ipsDay.put(dateFmt, ips);
           } else {
               ArrayList<String> ips = new ArrayList<String>();
               ips.add(le.getIpAddress());
               ipsDay.put(dateFmt, ips);
           }
       }
       return ipsDay;
    }
    
    /**
     * Find the day with the most number of visits, if there is a tie,
     * return any of the days found.
     * 
     * @param   map     HashMap that has Days mapped to an array of ips.
     * @return          day found.
     */
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map) {
        String maxDay = "";
        int numIPs = 0;
        for(String day : map.keySet()) {
            int ipsMap = map.get(day).size();
            if(ipsMap > numIPs) {
                numIPs = ipsMap;
                maxDay = day;
            }
        }
        return maxDay;
    }
    
    public void printAll() {
        for(LogEntry le : records) {
            System.out.println(le); // Automatically calls toString(function)
        }
    }
}
