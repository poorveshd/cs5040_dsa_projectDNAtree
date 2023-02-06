import java.util.NoSuchElementException;

/**
 * Citation: Implementation of this entire file is taken from the OpenDSA
 * textbook.
 *
 * List class ADT. Generalize the element type using Java Generics.
 * 
 * @author OpenDSA authors
 * @version 3/9/2022
 *
 * @param <E>
 */
public interface List<E> {
    /**
     * Remove all elements.
     */
    public void clear();


    /**
     * Append "it" at the end of the list.
     * The client must ensure that the list's capacity is not exceeded.
     * 
     * @param it
     *            value of link
     * 
     * @return true if inserted and false otherwise
     */
    public boolean append(E it);


    /**
     * Set the current position to the start of the list.
     */
    public void moveToStart();


    /**
     * Return true if current position is at end of the list.
     * 
     * @return true if at end and false otherwise
     */
    public boolean isAtEnd();


    /**
     * Move the current position one step right, no change if already at end.
     */
    public void next();


    /**
     * Return the number of elements in the list.
     * 
     * @return length of list
     */
    public int length();


    /**
     * Return the current element.
     * 
     * @return value of link to which curr is pointing
     */
    public E getValue() throws NoSuchElementException;


    /**
     * Remove and return current element.
     * 
     * @return value of removed link
     */
    public E remove() throws NoSuchElementException;
}
