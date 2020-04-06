
/**
 * Write a description of CaesarCipher here.
 * 
 * @author Joan Perez Lozano
 */

public class CaesarCipher {
    
    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Computing the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        
        System.out.println(alphabet);
        System.out.println(shiftedAlphabet);
        
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            
            if(idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }
        
        return encrypted.toString();
    }
    
    
}
