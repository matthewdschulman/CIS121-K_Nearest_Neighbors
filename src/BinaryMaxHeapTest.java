import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BinaryMaxHeapTest {
	
	private BinaryMaxHeap<Integer> heapInt;
	
	@Before
    public void setup()
    {
		heapInt = new BinaryMaxHeap<Integer>(Integer.class);
    }
	
	@SuppressWarnings("unused")
	private void printArr(Integer[] underlyingArray) {
		for (int i = 1; i < underlyingArray.length; i++) {
			if (underlyingArray[i] == null) {
				//break
				i = underlyingArray.length;
			}
			System.out.print("|" + underlyingArray[i]);
		}
		System.out.println("|");
	}

	@Test
	public void testEmpty() {
		assertTrue(heapInt.isEmpty());
		assertEquals(heapInt.size(), 0);
	}
	
	@Test
	public void testBasicInsert() {
		heapInt.insert(5);		
		assertFalse(heapInt.isEmpty());
		assertEquals(1, heapInt.size());
		heapInt.insert(4);
		assertEquals(2, heapInt.size());
		assertEquals((Integer)4, heapInt.getUnderlyingArray()[2]);
		heapInt.insert(6);
		assertEquals(3, heapInt.size());
		assertEquals((Integer)6, heapInt.getUnderlyingArray()[1]);
		assertEquals((Integer)4, heapInt.getUnderlyingArray()[2]);
		assertEquals((Integer)5, heapInt.getUnderlyingArray()[3]);
	}	
	
	@Test
	public void testAdvancedInsert() {
		heapInt.insert(5);		
		heapInt.insert(4);
		heapInt.insert(6);
		heapInt.insert(1);
		heapInt.insert(7);
		assertEquals(5, heapInt.size());
		//printArr(heapInt.getUnderlyingArray());
		assertEquals((Integer)7, heapInt.getUnderlyingArray()[1]);
		assertEquals((Integer)6, heapInt.getUnderlyingArray()[2]);
		assertEquals((Integer)5, heapInt.getUnderlyingArray()[3]);		
		assertEquals((Integer)1, heapInt.getUnderlyingArray()[4]);
		assertEquals((Integer)4, heapInt.getUnderlyingArray()[5]);	
	}	
	
	@Test
	public void testInsertWithSameElement() {
		heapInt.insert(5);		
		heapInt.insert(4);
		heapInt.insert(6);
		heapInt.insert(6);
		assertEquals(4, heapInt.size());
		//printArr(heapInt.getUnderlyingArray());
		assertEquals((Integer)6, heapInt.getUnderlyingArray()[1]);
		assertEquals((Integer)6, heapInt.getUnderlyingArray()[2]);
		assertEquals((Integer)5, heapInt.getUnderlyingArray()[3]);		
		assertEquals((Integer)4, heapInt.getUnderlyingArray()[4]);
	}

	@Test
	public void testMax() {
		heapInt.insert(5);
		assertEquals((Integer) 5, heapInt.max());
		System.out.println(1/2);
	}
	
	@Test
	public void testRemoveMax() {
		heapInt.insert(5);	
		assertEquals((Integer)5, heapInt.removeMax());
		assertEquals(0, heapInt.size());
		heapInt.insert(5);		
		heapInt.insert(4);
		heapInt.insert(6);
		heapInt.insert(1);
		heapInt.insert(7);	
		assertEquals((Integer)7, heapInt.removeMax());
		assertEquals(4, heapInt.size());
		assertEquals((Integer)6, heapInt.getUnderlyingArray()[1]);
		assertEquals((Integer)4, heapInt.getUnderlyingArray()[2]);
		assertEquals((Integer)5, heapInt.getUnderlyingArray()[3]);		
		assertEquals((Integer)1, heapInt.getUnderlyingArray()[4]);
	}
	
	@Test
	public void testExceptions() {
		
	}
	
	@Test
	public void testResizing() {
		
	}

}
