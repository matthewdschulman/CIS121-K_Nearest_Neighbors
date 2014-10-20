
import java.lang.reflect.Array;
import java.util.Iterator;
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
	int size;
	
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap(Class<E> type) { 
		this.type = type;
		arr = (E[]) Array.newInstance(type, 127);
		size = 0;
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
		if (arr[1] == null) {
			throw new NoSuchElementException();
		} else {
			return arr[1];
		}
     }

	@Override
	/**
     * Insert the given key into the heap.
     * @param k The key to insert.
     * @throws NullPointerException if e is null.
     */
	public void insert(E e) {
		if (arr.length == (size + 1)) {
			//double the length of the array
			resizeArr(arr.length * 2);
		}
		arr[size + 1] = e;			
		int curIndexToConsiderASwitchTo = (size + 1) / 2;
		int curIndexToConsiderASwitchFrom = size + 1;
		while ((curIndexToConsiderASwitchTo > 0) && (Double.parseDouble(e.toString()) > Double.parseDouble(arr[curIndexToConsiderASwitchTo].toString()))) {
			E switching = arr[curIndexToConsiderASwitchTo];
			arr[curIndexToConsiderASwitchTo] = e;
			arr[curIndexToConsiderASwitchFrom] = switching;
			curIndexToConsiderASwitchFrom =  curIndexToConsiderASwitchTo;
			curIndexToConsiderASwitchTo = curIndexToConsiderASwitchTo / 2;
		}
		size ++;
	}

	private void resizeArr(int newSize) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		E[] newElementsArr = (E[]) Array.newInstance(type, newSize);
		for (int i = 1; i <= size; i++) {
			newElementsArr[i] = arr[i];
		}
		arr = newElementsArr;    	
	}

	@Override
	/**
     * @return the size of the binary min-heap (i.e. the number of elements)
     *		in it.
     */
	public int size() {
		return size;
	}

	@Override
	/**
     * This would normally be a violation of abstraction, but this is included
     *      solely so we can test your heap implementation.
     * @return arr
     */
    public E[] getUnderlyingArray() {
    	return arr;
    }
}
