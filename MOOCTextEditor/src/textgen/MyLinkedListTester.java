/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

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
			shortList.get(2);
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
		
		String ans = shortList.remove(1);
		assertEquals("Remove: check ans is correct ", "B", ans);
		assertEquals("Remove: check element 0 is correct ", "A", shortList.get(0));
		assertEquals("Remove: check size is correct ", 1, shortList.size());
		try{
		String ans1 = shortList.remove(4);
		fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("Index Out Of Bounds!!!");
		}
		try{
			String ans1 = shortList.remove(-4);
			fail("Check out of bounds");
			}
			catch(IndexOutOfBoundsException e){
				System.out.println("Index Out Of Bounds!!!");
			}
		try{

			int ans1 = emptyList.remove(0);
			fail("Check out of bounds");
			}
			catch(IndexOutOfBoundsException e){
				System.out.println("Index Out Of Bounds!!!");
			}
		// TODO: Add more tests here
	}
	
	
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		shortList.add("C");
		int size = shortList.size();
		System.out.println(size);
		assertEquals("Check Last", "C", shortList.get((size-1)));
		
		try{
			list1.add(2, null);
			fail("Null Pointer");
		}
	    catch(NullPointerException e){
	    	System.out.println("Null Pointer Exception");
	    }
		
		
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		
		// TODO: implement this test
		assertEquals("size  ", 0 , emptyList.size());
		assertEquals("size", 2, shortList.size());
		assertEquals("size ", 3, list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
	shortList.add(1, "D");	
	int size = shortList.size();
	System.out.println("fdsf" + size);
	for(String i: shortList)
		System.out.println("hi" + i);
	assertEquals("Check first", "A", shortList.get(0));
	assertEquals("Check last", "B", shortList.get((size-1)));
	assertEquals("Check second", "D", shortList.get(1));
	shortList.add(1,"C");
	assertEquals("Check second", "C", shortList.get(1));
	assertEquals("Check first", "A", shortList.get(0));
	assertEquals("Check last", "B", shortList.get(3));
	assertEquals("Check second", "D", shortList.get(2));
	list1.add(0,02);
	assertEquals("Check second", (Integer)65, list1.get(1));
	assertEquals("Check first", (Integer)02, list1.get(0));
	assertEquals("Check fourth", (Integer)21, list1.get(2));
	assertEquals("Check last", (Integer)42, list1.get(3));
	MyLinkedList<Integer> lst = new MyLinkedList<Integer>();
	System.out.println(lst.size());
	lst.add(0, 1);
	System.out.println(lst.size());
	try{
		list1.add(2, null);
		fail("Null Pointer");
	}
    catch(NullPointerException e){
    	System.out.println("Null Pointer Exception");
    }
	
	try{
		shortList.add(6,"F");
		shortList.add(-9,"G");
		fail("Check out of bounds");
	}
	catch(IndexOutOfBoundsException e){}
	
	try{
		shortList.add(100,"r");
		fail("Check out of bounds");
	}
	catch(IndexOutOfBoundsException e){}
	
	try{
		shortList.add(-900,"g");
		fail("Check out of bounds");
	}
	catch(IndexOutOfBoundsException e){}
	}
	
	
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		
		shortList.set(1, "C");
		assertEquals("Check second", "C", shortList.get(1));
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check size", 2 ,shortList.size());
		
		list1.set(1, 45);
		assertEquals("Check second", (Integer)45, list1.get(1));
		assertEquals("Check first", (Integer)65, list1.get(0));
		assertEquals("Check first", (Integer)42, list1.get(2));
		assertEquals("Check size", 3 ,list1.size());
		
		try{
			list1.set(4, 66);
			fail("Check out of bounds");
		}
	    catch(IndexOutOfBoundsException e){
	    	System.out.println("Index out of bounds!");
	    }
		
		
		try{
			list1.set(-20, 22);
			fail("Check out of bounds");
		}
	    catch(IndexOutOfBoundsException e){
	    	System.out.println("Index out of bounds!");
	    }
		
		try{
			list1.set(100, 44);
			fail("Check out of bounds");
		}
	    catch(IndexOutOfBoundsException e){
	    	System.out.println("Index out of bounds!");
	    }
		try{
			list1.set(2, null);
			fail("Null Pointer");
		}
	    catch(NullPointerException e){
	    	System.out.println("Null Pointer Exception");
	    }
	}
	
	
	// TODO: Optionally add more test methods.
	
}
