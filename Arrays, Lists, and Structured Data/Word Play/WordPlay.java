
/**
 * Write a description of WordPlay here.
 * 
 * @author Joan Perez Lozano
 */
public class WordPlay {
    public boolean isVowel(char ch) {
        Character.toLowerCase(ch);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }
    
    public void testIsVowel() {
        char letter = 'b';
        boolean result = isVowel(letter);
        System.out.print("Is the letter \"" + letter + "\" a vowel? : ");
        System.out.println(result);
    }
    
    public String replaceVowels(String phrase, char ch) {
        StringBuilder sb = new StringBuilder(phrase);
        for(int i = 0; i < sb.length(); i++) {
            char letter = sb.charAt(i);
            if(isVowel(letter)) sb.setCharAt(i, ch);
        }
        return sb.toString();
    }
    
    public void testReplaceVowels() {
        String phrase = "Hello World";
        char ch = '*';
        System.out.println("Character used: " + ch);
        System.out.println("Phrase: " + phrase);
        System.out.println("Result: " + replaceVowels(phrase, ch));
    }
    
    public String emphasize(String phrase, Character ch) {
        StringBuilder sb = new StringBuilder(phrase);
        for(int i = 0; i < sb.length(); i++) {
            char letter = Character.toLowerCase(sb.charAt(i));
            if(letter == Character.toLowerCase(ch)) {
                // If position is even (adding 1 to be based on number location)
                if((i+1) % 2 == 0) {
                    sb.setCharAt(i, '+');
                } else {
                    sb.setCharAt(i, '*');
                }
            }
        }
        return sb.toString();
    }
    
    public void testEmphasize() {
        String phrase = "dna ctgaaactga";
        char ch = 'a';
        System.out.println("Character used: " + ch);
        System.out.println("Phrase: " + phrase);
        System.out.println("Result: " + emphasize(phrase, ch));
        
        phrase = "Mary Bella Abracadabra";
        ch = 'a';
        System.out.println("Character used: " + ch);
        System.out.println("Phrase: " + phrase);
        System.out.println("Result: " + emphasize(phrase, ch));
    }
    
}