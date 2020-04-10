
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author Joan Perez Lozano
 */
public class CaesarBreaker {
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
    
    public void maxIndex(){}
    
    public void decrypt(String encrypted) {
    
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
    
    }
}
