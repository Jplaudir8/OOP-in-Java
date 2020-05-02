
/**
 * Write a description of class Tester here.
 * 
 * Joan Perez Lozano
 */

import java.util.*;

public class Tester {
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log"); // Reading file
        //la.printAll();
        
        // int statusCodeCutoff = 400;
        // System.out.println("Printing log entries that have status code greater than " + statusCodeCutoff);
        // la.printAllHigherThanNum(statusCodeCutoff);
        
        // String date = "Mar 17";
        // System.out.println("Printing log entries that have date: " + date);
        // System.out.println("There are " + la.uniqueIPVisitsOnDay(date).size() + " entries for this date");
        // for(String le : la.uniqueIPVisitsOnDay(date)) {
            // System.out.println(le);
        // }
        
        // int low = 200;
        // int high = 299;
        // System.out.println("Unique IPs in the range: " + low + " and " + high + " inclusive:");
        // System.out.println(la.countUniqueIPsInRange(low, high));
        
        HashMap<String, Integer> map = la.countVisitsPerIP();
        System.out.println("Most number of visits found by a single IP Address: " + la.mostNumberVisitsByIP(map));
        
        
    }
}
