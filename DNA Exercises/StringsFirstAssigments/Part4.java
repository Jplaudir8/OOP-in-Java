
/**
 * Write a description of Part4 here.
 * 
 * @author Joan Perez Lozano 
 */
import edu.duke.URLResource;

public class Part4 {
    public static void main (String[] args) {
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        int c = 0;
        String tmp;
        for(String s : ur.words()) {
            tmp = s;
            s = s.toLowerCase();
            int yTubeIndex = s.indexOf("youtube");
            if( yTubeIndex != -1) {
                s = tmp;
                int leftDoubleQ = s.lastIndexOf("\"", yTubeIndex);
                int rightDoubleQ = s.indexOf("\"", yTubeIndex);
                System.out.println(s.substring(leftDoubleQ + 1, rightDoubleQ));
                c++;
            }
            
        }
        if (c == 0) System.out.println("There are no Youtube links in this site");
    }
}
