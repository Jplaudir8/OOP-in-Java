
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
    
    public int maxIndex(int[] values){
        int maxIdx = 0;
        for(int i = 0; i < values.length; i++){
            if(values[i] > values[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    
    public String decrypt(String encrypted) {
        
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        
        if(maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        
        return cc.encrypt(encrypted, 26 - dkey);
    }
}
