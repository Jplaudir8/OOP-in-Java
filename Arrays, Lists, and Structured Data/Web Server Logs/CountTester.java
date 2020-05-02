
/**
 * Write a description of CountTester here.
 * 
 * @author Joan Perez Lozano
 */
import java.util.*;

public class CountTester {

    
    public void testCounts() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        System.out.println(counts);
    }
    
}
