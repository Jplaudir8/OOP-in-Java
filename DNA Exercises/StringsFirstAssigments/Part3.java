
/**
 * Write a description of Part3 here.
 * 
 * @author Joan Perez Lozano 
 */
public class Part3 {
    public boolean twoOcurrences(String stringa, String stringb) {
        int c = 0;
        int startIndex = 0;
        
        for(int i = 0; i < stringb.length(); i++){
            if(stringb.indexOf(stringa, startIndex) != -1){
                startIndex = stringb.indexOf(stringa, startIndex + 1);
                c = c + 1;
            }
        }
        if (c >= 2){
            return true;
        } else {
            return false;
        }
        //return c >= 2 ? true : false;
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
        System.out.println("---------------------");
    }
}