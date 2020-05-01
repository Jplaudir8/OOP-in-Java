
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
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
        la.readFile("short-test_log"); // Reading file
        la.printAll();
        
        int statusCodeCutoff = 200;
        System.out.println("Printing log entries that have status code greater than " + statusCodeCutoff);
        la.printAllHigherThanNum(statusCodeCutoff);
        
        String date = "Sep 14";
        System.out.println("Printing log entries that have date: " + date);
        for(String le : la.uniqueIPVisitsOnDay(date)) {
            System.out.println(le);
        }
        
        int low = 300;
        int high = 399;
        System.out.println("Unique IPs in the range: " + low + " and " + high + " inclusive:");
        System.out.println(la.countUniqueIPsInRange(low, high));
    }
}
