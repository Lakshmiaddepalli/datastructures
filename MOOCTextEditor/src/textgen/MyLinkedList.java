package textgen;

import java.util.AbstractList;

/**
 * A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E>
 *            The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		this.size = 0;
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * 
	 * @param element
	 *            The element to add
	 */
	public boolean add(E element) {
		// TODO: Implement this method
		if (element != null) {
			LLNode<E> test = new LLNode<E>(element);
			// test.next = head.next;
			// test.prev = test.next.prev;
			// head.next = test;
			// test.next.prev = test;
			test.prev = tail.prev;
			test.next = test.prev.next;
			tail.prev = test;
			test.prev.next = test;
			this.size += 1;
			return true;
		} else {
			throw new NullPointerException("element cannot be null");
		}

	}

	/**
	 * Get the element at position index
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */

	public E get(int index) {

		// TODO: Implement this method.
		System.out.println(index);
		if (index < 0)
			throw new IndexOutOfBoundsException("Index out of bounds!!");

		else {

			LLNode<E> current = head.next;
			System.out.println(current);
			LLNode<E> current1 = tail.prev;
			System.out.println(current1);
			if (current == tail) {
				if (current1 == head)
					throw new IndexOutOfBoundsException("Index out of bounds!!");
			}

			for (int i = 0; i < index; i++) {

				if (current.next == tail) {

					throw new IndexOutOfBoundsException("Index out of bounds!!");
				}
				System.out.println(current.data);
				current = current.next;
				System.out.println(current);
				System.out.println(current.data);
				System.out.println("!!!!" + current.next);
				// return current.data;
			}
			System.out.println(current.data);
			System.out.println(current.next);
			return current.data;
		}

	}

	/**
	 * Add an element to the list at the specified index
	 * 
	 * @param The
	 *            index where the element should be added
	 * @param element
	 *            The element to add
	 */
	public void add(int index, E element) {
		// TODO: Implement this method
		if (element != null) {
			if (index < 0 || this.size() < index)
				throw new IndexOutOfBoundsException("Index out of bounds!!");
			else {
				LLNode<E> test = new LLNode<E>(element);
				LLNode<E> current = head;
			//	System.out.println("w" + current.data);
			//	LLNode<E> current1 = tail.prev;
			//	System.out.println(current1);
				for (int i = 0; i < index; i++)
				{
					current = current.next;
					 
				}
				System.out.println("y" + current.data);
				 test.next = current.next;
				 test.prev = test.next.prev;
				 current.next = test;
				 test.next.prev = test;
				 this.size += 1;
				
				 
				
				
			}
		} else
			throw new NullPointerException("element cannot be null");
	}

	/** Return the size of the list */
	public int size() {
		int count = 0;
		LLNode<E> current = head.next;
		while (current.next != null) {
			count++;
			current = current.next;
		}
	//	if (count > 0)
			return count;
		
	}

	/**
	 * Remove a node at the specified index and return its data element.
	 * 
	 * @param index
	 *            The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException
	 *             If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) {
		// TODO: Implement this method
		if (index < 0 || this.size() < index || this.size() == 0)
			throw new IndexOutOfBoundsException("Index out of bounds!!");
		else
		{
			LLNode<E> current = head.next;
			System.out.println("t" + current.data);
			LLNode<E> current1 = tail.prev;
			System.out.println(current1);
			for (int i = 0; i < index; i++)
			{
				current = current.next;
				 
			}
			System.out.println("r" + current.data);
			current.prev.next = current.next;
			current.next.prev=current.prev;
			current.next = null;
			current.prev = null;
			 this.size -= 1;
		return current.data;
		}
	}

	/**
	 * Set an index position in the list to a new element
	 * 
	 * @param index
	 *            The index of the element to change
	 * @param element
	 *            The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */
	public E set(int index, E element) {
		// TODO: Implement this method
		if (element != null) {
			if (index < 0 || this.size() < index)
				throw new IndexOutOfBoundsException("Index out of bounds!!");
			else {
				LLNode<E> test = new LLNode<E>(element);
				LLNode<E> current = head.next;
				System.out.println("lol" + current.data);
				LLNode<E> current1 = tail.prev;
				System.out.println(current1);
				for (int i = 0; i < index; i++)
				{
					current = current.next;
					 
				}
				System.out.println("lol1" + current.data);
				 test.next = current.next;
				 test.prev = current.prev;
				 current.next.prev = test;
				 current.prev.next = test;
				 current.next = null;
				 current.prev = null;
				 return current.data;
			}
		} else
			throw new NullPointerException("element cannot be null");

		
	}
}

class LLNode<E> {
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	public LLNode() {
		this.data = null;
		this.prev = null;
		this.next = null;
	}

}
