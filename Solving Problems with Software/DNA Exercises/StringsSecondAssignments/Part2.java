
/**
 * Write a description of Part2 here.
 * 
 * @author Joan Perez Lozano
 */
public class Part2 {
    public int howMany(String stringa, String stringb) {
        int startIndex = stringb.indexOf(stringa);
        int c = 0;
        
        while(startIndex != -1){
            
            startIndex = stringb.indexOf(stringa, startIndex + stringa.length());
            c++;
            
        }
        
        return c;
    }
    
    public void testHowMany(){
        String stringa = "GAA";
        String stringb = "ATGAACGAATTGAATC";
        int result1 = howMany(stringa, stringb);
        System.out.println(stringa);
        System.out.println(stringb);
        System.out.println("# of ocurrences " + result1);
        
        stringa = "AA";
        stringb = "ATAAAA";
        result1 = howMany(stringa, stringb);
        System.out.println(stringa);
        System.out.println(stringb);
        System.out.println("# of ocurrences " + result1);
    }
}
