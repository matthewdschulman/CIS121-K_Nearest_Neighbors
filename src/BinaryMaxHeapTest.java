import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BinaryMaxHeapTest {
	
	private BinaryMaxHeap<Integer> heap;
	
	@Before
    public void setup()
    {
		heap = new BinaryMaxHeap<Integer>(Integer.class);
    }
	
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
		assertTrue(heap.isEmpty());
		assertEquals(heap.size(), 0);
	}
	
	@Test
	public void testBasicInsert() {
		heap.insert(5);		
		assertFalse(heap.isEmpty());
		assertEquals(1, heap.size());
		heap.insert(4);
		assertEquals(2, heap.size());
		assertEquals((Integer)4, heap.getUnderlyingArray()[2]);
		heap.insert(6);
		assertEquals(3, heap.size());
		assertEquals((Integer)6, heap.getUnderlyingArray()[1]);
		assertEquals((Integer)4, heap.getUnderlyingArray()[2]);
		assertEquals((Integer)5, heap.getUnderlyingArray()[3]);
	}	
	
	@Test
	public void testAdvancedInsert() {
		heap.insert(5);		
		heap.insert(4);
		heap.insert(6);
		heap.insert(1);
		heap.insert(7);
		assertEquals(5, heap.size());
		//printArr(heap.getUnderlyingArray());
		assertEquals((Integer)7, heap.getUnderlyingArray()[1]);
		assertEquals((Integer)6, heap.getUnderlyingArray()[2]);
		assertEquals((Integer)5, heap.getUnderlyingArray()[3]);		
		assertEquals((Integer)1, heap.getUnderlyingArray()[4]);
		assertEquals((Integer)4, heap.getUnderlyingArray()[5]);	
	}	

	@Test
	public void testMax() {
		heap.insert(5);
		assertEquals((Integer) 5, heap.max());
		System.out.println(1/2);
	}

}
