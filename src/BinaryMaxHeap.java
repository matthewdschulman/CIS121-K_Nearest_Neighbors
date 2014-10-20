
import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * A binary heap, with the maximum at the root.
 * @param <K> A comparable element stored by this heap.
 * @author CIS 121 Staff
 * @version 2.0 - 10/16/12
 */
public class BinaryMaxHeap<E extends Comparable<? super E>> 
		implements BinaryMaxHeapI<E>{
	E[] arr; // SUPER IMPORTANT: do NOT change this to private! Leave as package-private
	Class<E> type;
	
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap(Class<E> type) { 
		this.type = type;
		arr = (E[]) Array.newInstance(type, 127);
		System.out.println(arr.length);
	}

	@Override
	/**
	 * @return true if this heap is empty.
	 */
	public boolean isEmpty() {
		//assume that arr[0] is always null like in lab, and that the heap always
		//starts at arr[1]
		if (arr[1] == null) {
			return true;
		}
		return false;
	}

	@Override
	/**
     * Removes the maximum key in this heap, and returns it.
     * @return The maximum key in this heap.
     * @throws NoSuchElementException If the heap is empty.
     */
	public E removeMax() throws NoSuchElementException {
		// TODO: implement
		return null;
	}

	@Override
	 /**
     * Returns, but does not remove, the maximum key in this heap.
     * @return The maximum key in this heap.
     * @throws NoSuchElementException If the heap is empty.
     */
     public E max() throws NoSuchElementException {
     	// TODO: implement
     	return null;
     }

	@Override
	/**
     * Insert the given key into the heap.
     * @param k The key to insert.
     * @throws NullPointerException if e is null.
     */
	public void insert(E e) {
		// TODO: implement
	}

	@Override
	/**
     * @return the size of the binary min-heap (i.e. the number of elements)
     *		in it.
     */
	public int size() {
		// TODO: implement
		return -1;
	}

	@Override
	/**
     * This would normally be a violation of abstraction, but this is included
     *      solely so we can test your heap implementation.
     * @return arr
     */
    public E[] getUnderlyingArray() {
    	// TODO: implement
    	return null;
    }
}
