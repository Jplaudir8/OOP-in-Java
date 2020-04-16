
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author Joan Perez Lozano
 */
import edu.duke.*;

public class TestCaesarCipherTwo {
    
    public String halfOfString(String message, int start) {
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < message.length(); i+=2) {
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }
    
    public int[] countLetters(String message) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] counts = new int[26];
        for(int i = 0; i < message.length(); i++){
            char ch = Character.toUpperCase(message.charAt(i));
            int idx = alphabet.indexOf(ch);
            if (idx != -1) {
                counts[idx]++;
            }
        }
        return counts;
    }
    
    public int maxIndex(int[] values){
        int maxIdx = 0;
        for(int i = 0; i < values.length; i++){
            if(values[i] > values[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    
    public void simpleTests() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        // Hardcoding encryption keys
        CaesarCipherTwo cct = new CaesarCipherTwo(17, 3);
        String encrypted = cct.encrypt(message);
        System.out.println("Encrypted message: " + encrypted);
        String decrypted = cct.decrypt(encrypted);
        System.out.println("Decrypted message: " + decrypted);
        
        String breakCC = breakCaesarCipher(encrypted);
        System.out.println("Decrypted with breakCaesarCipher: " + breakCC);
    }
    
    public String breakCaesarCipher(String input) {
        // Extracting every other characters
        String message1 = halfOfString(input,0);
        String message2 = halfOfString(input,1);
        // Determining keys
        CaesarBreaker cb = new CaesarBreaker();
        int key1 = cb.getKey(message1);
        int key2 = cb.getKey(message2);
        // Initializing found keys
        CaesarCipherTwo cct = new CaesarCipherTwo(key1, key2);
        return cct.decrypt(input);
    }

}
