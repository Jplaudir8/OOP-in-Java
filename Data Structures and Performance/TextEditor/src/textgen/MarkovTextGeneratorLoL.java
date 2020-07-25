package textgen;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		String[] sourceTextSplitted = sourceText.split("[\\s]+"); // Splitting by 1+ spaces.
		starter = sourceTextSplitted[0];
		String prevWord = starter;
		
		for(int i = 1; i < sourceTextSplitted.length; i++) {
			// Checking if prevWord is already a node in wordList
			ListNode lookingNode = findNode(prevWord);
			lookingNode.addNextWord(sourceTextSplitted[i]);
			prevWord = sourceTextSplitted[i];
		}
		// Adding first word to be the next word for last node in the list
		String sourceTextLastWord = sourceTextSplitted[sourceTextSplitted.length-1];
		ListNode lastNode = findNode(sourceTextLastWord);
		lastNode.addNextWord(starter);
	}
	
	/**
	 * Helper method. Check if 'word' exists in list of nodes, 'wordList'
	 * 
	 * @param word word lookup
	 * @return node of word (if found) or newly created node if not existent.
	 */
    private ListNode findNode(String word) {
        for (ListNode node : wordList) {
            if (node.getWord().equals(word)) {
                return node;
            }
        }
        ListNode node = new ListNode(word);
        wordList.add(node);
        return node; 
    }
	
//	/** 
//	 * Generate the number of words requested.
//	 */
//	@Override
//	public String generateText(int numWords) {
//		String currWord = starter;
//		String output = "";
//		
//		output = output + currWord;
//		for (int i = 0; i < numWords; numWords++) {
//			ListNode lookingNode = findNode(currWord);
//			String randomWord = lookingNode.getRandomNextWord(rnGenerator);
//			output += randomWord;
//			currWord = randomWord;
//		}
//		return null;
//	}
    
	/** 
	 * Generate the number of words requested.
	 */	
	@Override
    public String generateText(int numWords) {		
        String currWord = starter;
        String output = "";
        output += currWord;
        
        // Here we iterate until numWords-1. It is -1 because we already added the first word('starter') manually to the output.
        for (int i = 0; i < numWords - 1; i++) {
            ListNode node = findNode(currWord);
            String randomWord = node.getRandomNextWord(rnGenerator); // Returning null here if list is empty.
            output += " " + randomWord;
            currWord = randomWord;
        }     
        return output;
    }
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		// TODO: Implement this method.
	}
	
	// TODO: Add any private helper methods you need here.
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		textString = "hi there hi Leo";
		System.out.println(textString);
		gen.train(textString);
		
		System.out.println(gen);
		
		System.out.println(gen.generateText(4));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		//If the nextWords list is empty, return null. Otherwise return a random element from the list.
	    return nextWords.size() == 0 ? null : nextWords.get(generator.nextInt(nextWords.size()));
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


