
/**
 * Write a description of GladLibMap here.
 * 
 * @author Joan Perez Lozano
 */

import edu.duke.*;
import java.util.*;

public class GladLib {
    /**
     * These fields or instance variables will be used to store 
     * a HashMap(myMap) with all the categories mapped to their
     * respective list of words; hold a variable of type Random 
     * to help generate random numbers; and an ArrayList(already
     * pickedList) to store all the words that have already been 
     * picked from 'myMap'.
     */
    private HashMap<String, ArrayList<String>> myMap;
    private Random myRandom;
    private ArrayList<String> alreadyPickedList;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data_GladLib";
    
    /**
     * Initialize instance variables.
     */
    public GladLib(){
        myRandom = new Random();
        alreadyPickedList = new ArrayList<String>();
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
    }
    
    /**
     * Initialize instance variables
     * 
     * @param  source   filepath or url of the source to be used.
     */
    public GladLib(String source){
        initializeFromSource(source);
        myRandom = new Random();
        myMap = new HashMap<String, ArrayList<String>>();
    }
    
    /**
     * Helper method to initialize the lists with their respective
     * categories and lists.
     */
    private void initializeFromSource(String source) {
        String[] labels = {"adjective", "noun", "color", 
                                "country", "name", "animal", 
                                "timeframe", "verb", "fruit"}; 
        
        for(String label : labels){
            ArrayList<String> list = readIt(source + "/" + label+ ".txt");
            myMap.put(label, list);
        }
    }
    
    /**
     * Helper method to generate a random item.
     */
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    /**
     * Compute the substitute word based on the lists.
     * 
     * @param   label    name of the label. e.g. verb
     * @return           the new word calculated randomly.
     */
    private String getSubstitute(String label) {
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        return randomFrom(myMap.get(label));
    }

    /**
     * Substitute the label by a word from the list of words.
     * 
     * @param  w    label.
     * @return      the replacing word.
     */
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        int idx = alreadyPickedList.indexOf(sub);
        if(idx == -1) {
            alreadyPickedList.add(sub);
        } else {
            sub = getSubstitute(w.substring(first+1,last));
        }
        return prefix+sub+suffix;
    }
    
    /**
     * Helper method to print out the story in a more effective way
     * for the reader.
     */
    private void printOut(String s, int lineWidth){
        
        int charsWritten = 0;
        
        for(String w : s.split("\\s+")){
            
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    /**
     * Create story based on template provided
     * 
     * @return  strand of characters that conform the whole story with
     * labels replaced.
     */
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    /**
     * Read the source provided by iterating over every line of the file.
     * 
     * @param  source   filepath or url of the source to access the files.
     * @return          ArrayList of words that have been found.
     */
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    /**
     * Print out the total number of words that were possible 
     * to pick from.
     * 
     * @return  total number of words in the HashMap.
     */
    private int totalWordsInMap() {
        int counter = 0;
        for(ArrayList<String> s : myMap.values()){
            counter += s.size();
        }
        return counter;
    }
    
    /**
     * Compute the total number of words in the ArrayLists of the 
     * categories that were used for a particular GladLib.
     *
     * @return  the total number of words from these categories
     */
    public int totalWordsConsidered() { 
        int sum = 0;
        for(String category : myMap.keySet()){
            for (String word : myMap.get(category)){
                if(alreadyPickedList.contains(word)) {
                    sum += myMap.get(category).size();
                }
            }
        }
        return sum;
    }
    
    /**
     * Create story based on template provided.
     */
    public void makeStory(){
        alreadyPickedList.clear();
        System.out.println("\n");
        String story = fromTemplate("data_GladLib/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\n" + "Number of words replaced: " + alreadyPickedList.size());
    }
}