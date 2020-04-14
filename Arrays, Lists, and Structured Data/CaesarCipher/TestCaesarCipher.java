
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author Joan Perez Lozano
 */
import edu.duke.*;

public class TestCaesarCipher {
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
        CaesarCipherEncapsulated cc = new CaesarCipherEncapsulated(18);
        String encrypted = cc.encrypt(message);
        System.out.println("The encrypted message is: " + encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("The decrypted message is: " + decrypted);
        
        String breakDecrypted = breakCaesarCipher(encrypted);
        System.out.println("Decrypted string using breakCaesarCipher():\n"+breakDecrypted);
    }

    public String breakCaesarCipher(String input) {
        int[] freqs = countLetters(input); 
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;

        if(maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        CaesarCipherEncapsulated cc = new CaesarCipherEncapsulated(dkey);
        return cc.decrypt(input);
    }
}
