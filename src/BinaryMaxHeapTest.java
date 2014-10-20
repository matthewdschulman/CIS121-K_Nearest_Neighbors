import static org.junit.Assert.*;

import org.junit.Test;


public class BinaryMaxHeapTest {

	@Test
	public void test() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<Integer>(Integer.class);
		assertTrue(heap.isEmpty());
	}

}
