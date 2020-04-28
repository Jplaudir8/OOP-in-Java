
/**
 * Write a description of GladLibMap here.
 * 
 * @author Joan Perez Lozano
 */

import edu.duke.*;
import java.util.*;

public class GladLib {
    private HashMap<String, ArrayList<String>> myMap;
    private Random myRandom;
    private ArrayList<String> alreadyPickedList;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data_GladLib";
    
    /**
     * OK
     */
    public GladLib(){
        myRandom = new Random();
        alreadyPickedList = new ArrayList<String>();
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
    }
    
    /**
     * OK
     */
    public GladLib(String source){
        initializeFromSource(source);
        myRandom = new Random();
        myMap = new HashMap<String, ArrayList<String>>();
    }
    
    /**
     * OK
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
     * OK
     */
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    /**
     * OK
     */
    private String getSubstitute(String label) {
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        return randomFrom(myMap.get(label));
    }

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

    public void makeStory(){
        alreadyPickedList.clear();
        System.out.println("\n");
        String story = fromTemplate("data_GladLib/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\n" + "Number of words replaced: " + alreadyPickedList.size());
    }
    
    
}