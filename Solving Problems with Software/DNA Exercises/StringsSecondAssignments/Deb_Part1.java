
/**
 * Write a description of Deb_Part1 here.
 * 
 * @author Joan Perez Lozano
 */
public class Deb_Part1 {
   public void findAbc(String input){
       int index = input.indexOf("abc");
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           //System.out.println("Index 1: " + index);
           
           String found = input.substring(index + 1, index + 4);
           System.out.println("Index 2: " + index);
           System.out.println(found);
           
           index = input.indexOf("abc", index + 3);
           System.out.println("Index 3: " + index);
       }
   }

   public void test(){
       //findAbc("abcd");
       findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
   }
}
