
/**
 * Write a description of UniqueIPTester here.
 * 
 * @author Joan Perez Lozano
 */
public class UniqueIPTester {
    public void testUniqIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        int uniqueIPs = la.countUniqueIPs();
        System.out.println("There are " + uniqueIPs + " IP addresses");
    }
}
