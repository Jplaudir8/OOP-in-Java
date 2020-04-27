
/**
 * Write a description of WordsInFiles here.
 * 
 * @author Joan Perez Lozano
 */
import edu.duke.*;
import java.util.*;
import java.io.*;

public class WordsInFiles {
    
    private HashMap <String, ArrayList<String>> wordsMap;
    
    public WordsInFiles() {
        wordsMap = new HashMap <String, ArrayList<String>>();
        
    }
    
    private void addWordsFromFile(File file) {
        FileResource fr = new FileResource(file);
        String filename = file.getName();
        
        for(String word : fr.words()) {
            if(!wordsMap.containsKey(word)){
                ArrayList<String> newList = new ArrayList<String>();
                newList.add(filename);
                wordsMap.put(word, newList);
            } else {
                ArrayList<String> existingList = new ArrayList<String>();
                existingList = wordsMap.get(word);
                existingList.add(filename);
                wordsMap.put(word, existingList);
            }
        }
    }
    
    public void buildWordFileMap() {
        wordsMap.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            addWordsFromFile(f);
        }
        
        for(String key : wordsMap.keySet()){
            System.out.println("key: " + key);
            for(String value : wordsMap.get(key)) {
                System.out.println();
            }
        }
    }
    
    public int maxNumber() {
        int max = 0;
        for(ArrayList list : wordsMap.values()){
            if(list.size() > max) {
                max = list.size();
            }
        }
        return max;
    }
    
    public ArrayList<String> wordsInNumFiles(int number) {
        ArrayList<String> words = new ArrayList<String>();
        for(String word : wordsMap.keySet()) {
            // If the size of the arrayList linked to 's' is equals
            // to number, add it to the list to be retrieved.
            if(wordsMap.get(word).size() == number) {
                words.add(word);
            }
        }
        return words;
    }
    
    public void printFilesLn(String word) {
        if(!wordsMap.containsKey(word)){
            System.out.println("This word does not exist");
        } else {
            System.out.println(word + " appears in the files: ");
            for(String s : wordsMap.get(word)) {
                System.out.println(s);
            }
        }
    }
    
    public void tester() {
        buildWordFileMap();
        System.out.println("The maximum number of files any word is in: " + maxNumber()); 
        
        ArrayList<String> maxWords = wordsInNumFiles(maxNumber());
        System.out.println("Words in the maximum number of files: ");
        for(String s : maxWords){
            System.out.println(s);
            System.out.println("\tLocated in files: ");
            printFilesLn("\t "+s);
        }
        
        System.out.println("****************************");
        System.out.println("Printing complete HashMap: ");
        System.out.println("****************************");
        for(String s : wordsMap.keySet()){
            System.out.println("key: " + s);
            System.out.println("\tArrayList of " + s);
            for(String word : wordsMap.get(s)) {
                printFilesLn("\t" + word);
            }
        }
    }
    
    
    
    
    
    
}
