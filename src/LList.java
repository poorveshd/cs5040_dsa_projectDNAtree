
/**
 * Citation: Implementation of this entire file is taken from the OpenDSA
 * textbook. Only the equals() method is written by Gautam Sharma and
 * Poorvesh Dongre.
 *
 * LList Class containing a linked-list implementation.
 * 
 * @author OpenDSA authors
 * @author Gautam Sharma (Implemented equals method)
 * @author Poorvesh Dongre (Implemented equals method)
 * @version 3/9/2022
 *
 * @param <E>
 */
class LList<E> implements List<E> {
    // Pointer to list header
    private Link<E> head;
    // Pointer to last element
    private Link<E> tail;
    // Access to current element
    private Link<E> curr;
    // Size of list
    private int listSize;

    /**
     * Constructor for linked-list.
     */
    LList() {
        clear();
    }


    /**
     * Remove all elements.
     */
    public void clear() {
        curr = new Link<E>(null);
        tail = curr;
        head = new Link<E>(tail);
        listSize = 0;
    }


    /**
     * Check if two objects are equal.
     *
     * @return true if equal and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        // Object is itself
        if (o == this) {
            return true;
        }

        // Object is an instance of some other class
        if (!(o instanceof LList)) {
            return false;
        }

        // Object `o` type-casted to `LList<?>`
        LList<?> other = (LList<?>)o;
        if (length() != other.length()) {
            return false;
        }

        // Compare values of both the lists one node at a time
        for (moveToStart(), other.moveToStart(); !isAtEnd(); next(), other
            .next()) {
            if (!(getValue().equals(other.getValue()))) {
                return false;
            }
        }
        return true;
    }


    /**
     * Append "it" to list.
     * 
     * @param it
     *            value to be inserted
     *
     * @return true if inserted and false otherwise
     */
    public boolean append(E it) {
        tail.setNext(new Link<E>(null));
        tail.setElement(it);
        tail = tail.next();
        listSize++;
        return true;
    }


    /**
     * Set curr at list start.
     */
    public void moveToStart() {
        curr = head.next();
    }


    /**
     * Return true if current position is at end of the list.
     *
     * @return true if "curr" is at end and false otherwise
     */
    public boolean isAtEnd() {
        return curr == tail;
    }


    /**
     * Move curr one step right; no change if now at end.
     */
    public void next() {
        if (curr != tail) {
            curr = curr.next();
        }
    }


    /**
     * Return length of list.
     * 
     * @return length of list
     */
    public int length() {
        return listSize;
    }


    /**
     * Return current element value. Note that null gets
     * returned if curr is at the tail.
     *
     * @return value at curr
     */
    public E getValue() {
        if (curr == tail) {
            return null;
        }

        return curr.element();
    }


    /**
     * Remove and return current element.
     *
     * @return value removed
     */
    public E remove() {
        if (curr == tail) {
            return null;
        }

        // Value of node to which `curr` is pointing
        E it = curr.element();
        curr.setElement(curr.next().element());
        if (curr.next() == tail) {
            tail = curr;
        }

        curr.setNext(curr.next().next());
        listSize--;
        return it;
    }
}
