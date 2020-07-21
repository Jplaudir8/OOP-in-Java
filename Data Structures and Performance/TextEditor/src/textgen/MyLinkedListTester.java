/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import com.sun.glass.ui.Size;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH = 10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		} catch(IndexOutOfBoundsException e) {
		}
		
		try {
			shortList.remove(shortList.size());
			fail("Check out of bounds");
		} catch(IndexOutOfBoundsException e) {
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		// Adding a null value should throw an exception.
		try {
			new MyLinkedList<String>().add(null);
			fail("Cannot add null element to list");
		} catch (NullPointerException e) {
		}
		
		// TEST ADDING TO AN EMPTY LIST
		// test inserted element has been correctly added.
        boolean addingFlag = emptyList.add(5);
		assertEquals("testAddEnd: checking element is at the end of list", (Integer)5, emptyList.get(0));
		assertEquals("testAddEnd: checking element has been successfully added", true, addingFlag);
		assertEquals("testAddEnd: checking size has incremented", 1, emptyList.size());
		
		
		// TEST ADDING TO A NON-EMPTY LIST
		// test inserted element is at the end of the list.
		addingFlag = shortList.add("H");
		// creating array with expected values and comparing it to the actual current elements
		String[] expectedValues = {"A", "B", "H"};
		String[] actualCurrentValues = new String[expectedValues.length];
		// inserting all elements that are in shortList to actualCurrentValues
		for(int i = 0; i < actualCurrentValues.length; i++) {
			actualCurrentValues[i] = shortList.get(i);
		}
		assertArrayEquals("testAddEnd: checking element is at the end of list", expectedValues, actualCurrentValues);
		assertEquals("testAddEnd: checking element has been successfully added", true, addingFlag);
		assertEquals("testAddEnd: checking size has incremented", 3, shortList.size());
	}

	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// Testing current sizes
		assertEquals("testSize: shortList", 2, shortList.size());
		assertEquals("testSize: shortList", 0, emptyList.size());
		assertEquals("testSize: shortList", 10, longerList.size());
		assertEquals("testSize: shortList", 3, list1.size());
		
		// Testing size after adding an element
		shortList.add("X");
		emptyList.add(30);
		longerList.add(999);
		list1.add(222);
		
		assertEquals("testSize: shortList", 3, shortList.size());
		assertEquals("testSize: shortList", 1, emptyList.size());
		assertEquals("testSize: shortList", 11, longerList.size());
		assertEquals("testSize: shortList", 4, list1.size());
	}

	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		// TESTING WITH longerList
		// test adding a null value should throw an exception.
		try {
			longerList.add(1, null);
			fail("Cannot add null element to list");
		} catch (NullPointerException e) {
		}
				
		// test adding an element into a negative index should throw an exception.
		try {
			longerList.add(-1, 28);
			fail("Cannot insert a negative index");
		} catch(IndexOutOfBoundsException e) {
		}
		
		// test adding an element into an index that is out of range should throw an exception.
		try {
			longerList.add(longerList.size() + 1, 18);
			fail("Cannot add element at an index greater than the size of the list");
		} catch(IndexOutOfBoundsException e) {
		}
		
		// TESTING WITH emptyList
		// test adding at the beginning of emptyList
		emptyList.add(0, 20);
		assertEquals("testAddAtIndex: emptyList", (Integer)20, emptyList.get(0));
		assertEquals("testAddAtIndex: size", 1, emptyList.size());
		
		// TESTING WITH shortList
		// test adding at the beginning of the list
		shortList.add(0, "Z");
		assertEquals("testAddAtIndex: shortList", "Z", shortList.get(0));
		assertEquals("testAddAtIndex: shortList", "A", shortList.get(1));
		assertEquals("testAddAtIndex: shortList", "B", shortList.get(2));
		assertEquals("testAddAtIndex: size", 3, shortList.size());
		
		// test adding at the middle of the list
		shortList.add(2, "Y");
		assertEquals("testAddAtIndex: shortList", "Z", shortList.get(0));
		assertEquals("testAddAtIndex: shortList", "A", shortList.get(1));
		assertEquals("testAddAtIndex: shortList", "Y", shortList.get(2));
		assertEquals("testAddAtIndex: shortList", "B", shortList.get(3));
		assertEquals("testAddAtIndex: size", 4, shortList.size());
		
		// test adding at the end of the list
		shortList.add(4, "Y");
	    assertEquals("testAddAtIndex: shortList", "Z", shortList.get(0));
		assertEquals("testAddAtIndex: shortList", "A", shortList.get(1));
		assertEquals("testAddAtIndex: shortList", "Y", shortList.get(2));
		assertEquals("testAddAtIndex: shortList", "B", shortList.get(3));
		assertEquals("testAddAtIndex: shortList", "Y", shortList.get(4));
		assertEquals("testAddAtIndex: middle", 5, shortList.size());
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		// TESTING WITH shortList
		// setting a null value should throw an exception.
		try {
			shortList.set(1, null);
			fail("Cannot set null element to list");
		} catch (NullPointerException e) {
		}
		
		// setting an element into a negative index should throw an exception.
		try {
			shortList.set(-1, "I");
			fail("Cannot insert a negative index");
		} catch(IndexOutOfBoundsException e) {
		}
		
		// setting an element into a negative index should throw an exception.
		try {
			shortList.set(shortList.size(), "K");
			fail("Cannot insert at an index out of list's range");
		} catch(IndexOutOfBoundsException e) {
		}
		
		String oldValue = shortList.set(0, "G");
		assertEquals("testSet", "A", oldValue);
		assertEquals("testSet", "G", shortList.get(0));
	}
	
		
}
