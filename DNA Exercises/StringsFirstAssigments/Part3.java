
/**
 * Write a description of Part3 here.
 * 
 * @author Joan Perez Lozano 
 */
public class Part3 {
    public boolean twoOcurrences(String stringa, String stringb) {
        int c = 0, startIndex = stringb.indexOf(stringa);

        while(startIndex != -1){
            startIndex = stringb.indexOf(stringa, startIndex + stringa.length() + 1);
            c++;
        }
        
        return c >= 2 ? true : false;
    }
    
    public String lastPart(String stringa, String stringb){
        int startIndex = stringb.indexOf(stringa);
        
        return startIndex != -1 ? stringb.substring(startIndex + stringa.length()) : stringb;
    }
    
    public void test() {
        String stra = "by";
        String strb = "A story by Abby Long";
        System.out.println("String A: " + stra);
        System.out.println("String B: " + strb);
        boolean result = twoOcurrences(stra, strb);
        System.out.println("Result: " + result);
        System.out.println("");
        
        stra = "a";
        strb = "banana";
        System.out.println("String A: " + stra);
        System.out.println("String B: " + strb);
        result = twoOcurrences(stra, strb);
        System.out.println("Result: " + result);
        System.out.println("");

        stra = "atg";
        strb = "ctgtatgta";
        System.out.println("String A: " + stra);
        System.out.println("String B: " + strb);
        result = twoOcurrences(stra, strb);
        System.out.println("Result: " + result);
        System.out.println("");
        
        System.out.println("Last Part Method: ");
        stra = "an";
        strb = "banana";
        String last = lastPart(stra, strb);
        System.out.println("String A: " + stra);
        System.out.println("String B: " + strb);
        System.out.println("Last Part: " + last);
        System.out.println("");
        
        stra = "zoo";
        strb = "forest";
        last = lastPart(stra, strb);
        System.out.println("String A: " + stra);
        System.out.println("String B: " + strb);
        System.out.println("Last Part: " + last);
        
        System.out.println("---------------------");
    }
}