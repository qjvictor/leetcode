package design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation 
 * -- it essentially peek() at the element that will be returned by the next call to next().

Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

Call next() gets you 1, the first element in the list.

Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.


 Follow up: How would you extend your design to be generic and work with all types, not just integer?
 * @author VictorQian
 *
 */
public class PeekingIterator implements Iterator<Integer> {

	Iterator<Integer> it = null;
	Integer peekedElement = null;

	public PeekingIterator(Iterator<Integer> iterator) {
		it = iterator;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (peekedElement == null) {
			if (it.hasNext()) {
				peekedElement = it.next();
			}
		}
		return peekedElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (peekedElement != null) {
			Integer ret = new Integer(peekedElement);
			peekedElement = null;
			return ret;
		} else {
			return it.next();
		}
	}

	@Override
	public boolean hasNext() {
		return peekedElement != null || it.hasNext();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
	}
}	