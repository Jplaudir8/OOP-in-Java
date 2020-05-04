
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
        String filename = "weblog2_log";
        la.readFile(filename); // Reading file
        //la.printAll();
        
        int numbrIPs = la.countUniqueIPs();
        System.out.println("Unique IP Addresses in " + filename + ": " + numbrIPs);
        
        // int statusCodeCutoff = 400;
        // System.out.println("Printing log entries that have status code greater than " + statusCodeCutoff);
        // la.printAllHigherThanNum(statusCodeCutoff);
        
        String date = "Sep 27";
        System.out.println("Printing log entries that have date: " + date);
        System.out.println("There are " + la.uniqueIPVisitsOnDay(date).size() + " entries for this date");
        for(String le : la.uniqueIPVisitsOnDay(date)) {
            System.out.println(le);
        }
        
        // int low = 400;
        // int high = 499;
        // System.out.println("Unique IPs in the range: " + low + " and " + high + " inclusive, for file "+filename+":");
        // System.out.println(la.countUniqueIPsInRange(low, high));
        
        HashMap<String, Integer> map = la.countVisitsPerIP();
        System.out.println("Most number of visits found by a single IP Address: " + la.mostNumberVisitsByIP(map));
        
        System.out.println("IP addresses with maximum number of occurrences: ");
        System.out.println(la.iPsMostVisits(map));
        
        // System.out.println("IP addresses per day: ");
        HashMap<String, ArrayList<String>> ipsPerDay = la.ipsForDays();
        // for(String day : ipsPerDay.keySet()) {
            // System.out.println(day + ":");
            // for(String ips : ipsPerDay.get(day)) {
                // System.out.println("\t" + ips);
            // }
        // }
        
        String dayMost = la.dayWithMostIPVisits(ipsPerDay);
        System.out.println("Day with the most number of visits: " + dayMost);
        
        String someday = "Sep 30";
        System.out.println("IP's with most visits on " + someday + ":");
        ArrayList<String> ips = la.iPsWithMostVisitsOnDay(ipsPerDay, someday);
        for(String ip : ips) {
            System.out.println(ip);
        }
        
    }
}
