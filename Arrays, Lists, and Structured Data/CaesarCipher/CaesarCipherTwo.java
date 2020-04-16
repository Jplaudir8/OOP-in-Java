
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author Joan Perez Lozano
 */
public class CaesarCipherTwo {
    
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    
    public CaesarCipherTwo(int key1, int key2) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }
    
    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        CaesarCipherEncapsulated enc1 = new CaesarCipherEncapsulated(mainKey1);
        CaesarCipherEncapsulated enc2 = new CaesarCipherEncapsulated(mainKey2);
        
        for(int i = 0; i < encrypted.length(); i++) {
            String ch = encrypted.charAt(i) + "";
            if(i % 2 == 0) {
                encrypted.setCharAt(i, enc1.encrypt(ch).charAt(0));
            } else {
                encrypted.setCharAt(i, enc2.encrypt(ch).charAt(0));
            }
        }
        return encrypted.toString();
    }
    
    public String decrypt(String input) {
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
        return cc.encrypt(input);
    }
    
    
    
    
    
    
    
    
}
