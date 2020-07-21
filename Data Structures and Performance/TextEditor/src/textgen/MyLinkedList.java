package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	private LLNode<E> head;
	private LLNode<E> tail;
	private int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// Throw error if trying to add a null element.
		if (element == null) 
			throw new NullPointerException("Cannot insert a null value");
		
		// Creating new node
		LLNode<E> newNode = new LLNode<E>(element);
		
		// Moving pointers to add new element
		newNode.next = tail;
		newNode.prev = tail.prev;
		newNode.prev.next = newNode;
		newNode.next.prev = newNode;
		
		// Now we update the size of the list
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// Throw error if trying to retrieve an index that is out of bounds
		if(index < 0 || index >= size || size == 0) 
			throw new IndexOutOfBoundsException("Cannot retrieve at an index out of range");
		
		LLNode<E> currentNode = head.next;
		for(int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		return currentNode.data;
	}	
	
	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// Throw error if trying to add a null element
		if(element == null) {
			throw new NullPointerException("Cannot insert a null value");
		}
		
		// Throw error if trying to add an element at an index that is out of bounds
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Cannot insert at an index out of range");
		}
		
		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> currentNode = head;
		
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		
		newNode.next = currentNode.next;
		newNode.prev = currentNode;
		newNode.next.prev = newNode;
		currentNode.next = newNode;
		
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// Throw error if trying to remove an element that is out of bounds.
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Cannot remove at an index out of bounds");
		}
		
		LLNode<E> removingNode = head.next;
		for(int i = 0; i < index; i++) {
			removingNode = removingNode.next;
		}
		
		// Storing element to be removed before moving pointers
		E removedElement = removingNode.data;
		removingNode.prev.next = removingNode.next;
		removingNode.next.prev = removingNode.prev;
		removingNode.next = null;
		removingNode.prev = null;
		
		size--;
		
		return removedElement;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
