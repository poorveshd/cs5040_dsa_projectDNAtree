import student.TestCase;

/**
 * LListTest Class contains test cases for
 * `LList` class.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 2/13/2022
 */
public class LListTest extends TestCase {
    /**
     * Test for equality with same class object.
     */
    public void testLListEqualsSameObject() {
        // 1st list for checking equality
        LList<String> lst1 = new LList<String>();
        lst1.append("ABCD");
        lst1.append("WXYZ");
        // 2nd list for checking equality
        LList<String> lst2 = lst1;

        assertTrue(lst1.equals(lst2));
    }


    /**
     * Test for equality with different class object.
     */
    public void testLListEqualsDifferentClass() {
        // 1st list for checking equality
        LList<String> lst1 = new LList<String>();
        // 2nd list for checking equality
        final int lst2 = 0;

        assertFalse(lst1.equals(lst2));
    }


    /**
     * Test for equality with lists of different lengths.
     */
    public void testLListEqualsDifferentLength() {
        // 1st list for checking equality
        LList<Integer> lst1 = new LList<Integer>();
        lst1.append(1);

        // 2nd list for checking equality
        LList<Integer> lst2 = new LList<Integer>();
        lst2.append(1);
        lst2.append(2);

        assertFalse(lst1.equals(lst2));
    }


    /**
     * Test for equality with unequal lists of same length.
     */
    public void testLListEqualsUnequalListsSameLength() {
        // 1st list for checking equality
        LList<Integer> lst1 = new LList<Integer>();
        lst1.append(1);
        lst1.append(2);
        lst1.append(3);

        // 2nd list for checking equality
        LList<Integer> lst2 = new LList<Integer>();
        lst2.append(1);
        lst2.append(9);
        lst2.append(3);

        assertFalse(lst1.equals(lst2));
    }


    /**
     * Test for getting value from an empty list.
     */
    public void testLListGetValueEmpty() {
        // Empty list
        LList<String> lst = new LList<String>();

        assertNull(lst.getValue());
    }


    /**
     * Test for remove on an empty list.
     */
    public void testLListRemoveEmpty() {
        // Empty list
        LList<String> lst = new LList<String>();

        assertNull(lst.remove());
    }


    /**
     * Test for remove on the first element.
     */
    public void testLListRemoveFirst() {
        // List for testing remove operation
        LList<Integer> lst = new LList<Integer>();
        lst.append(1);

        assertTrue(lst.remove().equals(1));
    }


    /**
     * Test for remove on the middle element.
     */
    public void testLListRemoveMiddle() {
        // List for testing remove operation
        LList<Integer> lst = new LList<Integer>();
        lst.append(1);
        lst.append(2);
        lst.append(3);
        lst.append(4);
        lst.next();

        assertTrue(lst.remove().equals(2));
    }


    /**
     * Test for remove on the second last element.
     */
    public void testLListRemoveSecondLast() {
        // List for testing remove operation
        LList<Integer> lst = new LList<Integer>();
        lst.append(1);
        lst.append(2);
        lst.append(3);
        lst.next();

        assertTrue(lst.remove().equals(2));
    }


    /**
     * Test for remove on the last element.
     */
    public void testLListRemoveLast() {
        // List for testing remove operation
        LList<Integer> lst = new LList<Integer>();
        lst.append(1);
        lst.append(2);
        lst.append(3);

        for (lst.moveToStart(); !lst.isAtEnd(); lst.next()) {
        }
        assertNull(lst.remove());
    }


    /**
     * Test for next on empty list.
     */
    public void testLListNextEmpty() {
        // List for testing next operation
        LList<String> lst = new LList<String>();
        lst.next();

        assertNull(lst.getValue());
    }
}
