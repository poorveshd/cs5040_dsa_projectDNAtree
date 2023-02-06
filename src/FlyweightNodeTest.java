import student.TestCase;

/**
 * FlyweightNodeTest Class contains test cases for
 * `FlyweightNode` class.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 3/9/2022
 */
public class FlyweightNodeTest extends TestCase {
    /**
     * Test for checking that it's not a leaf.
     */
    public void testIsLeaf() {
        // Create a flyweight node
        FlyweightNode fn = new FlyweightNode();

        // Verify it's not a leaf node
        assertFalse(fn.isLeaf());
    }
}
