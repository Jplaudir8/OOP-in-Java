
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
    
    /**
     * OK
     */
    private void addWordsFromFile(File file) {
        String filename = file.getName();
        FileResource fr = new FileResource(file);
        
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
    
    /**
     * OK
     */
    public void buildWordFileMap() {
        wordsMap.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            addWordsFromFile(f);
        }
    }
    
    /**
     * OK
     */
    public int maxNumber() {
        int max = 0;
        for(ArrayList list : wordsMap.values()){
            if(list.size() > max) {
                max = list.size();
            }
        }
        return max;
    }
    
    /**
     * OK
     */
    private ArrayList<String> wordsInNumFiles(int number) {
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
            for(String s : wordsMap.get(word)) {
                System.out.println("\t" + s);
            }
        }
    }
    
    public void tester() {
        buildWordFileMap();
        
        System.out.println("****************************");
        System.out.println("Printing complete HashMap: ");
        System.out.println("****************************");
        // Printing the whole array
        for(String key : wordsMap.keySet()){
            System.out.println("key: " + key);
            System.out.println("\tin Filenames: ");
            for(String value : wordsMap.get(key)) {
                System.out.println("\t"+value);
            }
        }
        
        System.out.println("The maximum number of files any word is in: " 
                                                        + maxNumber()); 
        
        ArrayList<String> maxWords = wordsInNumFiles(maxNumber());
        
        System.out.println("Number of words that occur in 7 files: " + wordsInNumFiles(7).size());
        
        System.out.println("Number of words that occur in 5 files: " + wordsInNumFiles(5).size()); 
        
        System.out.println("Number of words that occur in 4 files: " + wordsInNumFiles(4).size()); 
        
        System.out.println("The word \"tree\" appears in files: ");
        printFilesLn("tree");
        
        System.out.println("The word \"laid\" appears in files: ");
        printFilesLn("laid");
        
        System.out.println("The word \"sad\" appears in files: ");
        printFilesLn("sad");
        
        System.out.println("The word \"red\" appears in files: ");
        printFilesLn("red");
        // System.out.println("Words in the maximum number of files: ");
        // for(String s : maxWords){
            // System.out.println(s);
            // System.out.println("\tIn file(s): ");
            // printFilesLn(s);
        // }
    }

}
