/**
 * Citation: Implementation of this entire file is taken from the OpenDSA
 * textbook.
 *
 * Link Class that consists of a link and link-specific operations
 * for a generic linked-list.
 * 
 * @author OpenDSA authors
 * @version 3/9/2022
 *
 * @param <E>
 */
public class Link<E> {
    // Value for this link
    private E e;
    // Point to next link in list
    private Link<E> n;

    /**
     * Constructor for `Link`. It initializes the
     * link with given value for next pointer.
     *
     * @param inn
     *            pointer to next link in list
     */
    Link(Link<E> inn) {
        e = null;
        n = inn;
    }


    /**
     * Return the value.
     * 
     * @return element of link
     */
    E element() {
        return e;
    }


    /**
     * Set element value.
     * 
     * @param it
     *            value for this link
     * 
     * @return new value of element
     */
    E setElement(E it) {
        e = it;
        return e;
    }


    /**
     * Return next link.
     * 
     * @return next link
     */
    Link<E> next() {
        return n;
    }


    /**
     * Set next link.
     *
     * @param inn
     *            pointer to next link
     * 
     * @return new next link
     */
    Link<E> setNext(Link<E> inn) {
        n = inn;
        return n;
    }
}
