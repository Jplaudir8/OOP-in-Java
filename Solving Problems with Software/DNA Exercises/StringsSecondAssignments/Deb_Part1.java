
/**
 * Write a description of Deb_Part1 here.
 * 
 * @author Joan Perez Lozano
 */
public class Deb_Part1 {
   public void findAbc(String input) {
       int index = input.indexOf("abc");
        while (true) {
            if (index == -1) {
                break;
            }
            String found = input.substring(index+1, index+4);
            System.out.println(index+1);
            System.out.println(index+4);
            //System.out.println(found);
            index = input.indexOf("abc", index+4);
       }
   }
   
   public void test() {
       //findAbc("abcd");
       findAbc("abcdabc");
   }
}
