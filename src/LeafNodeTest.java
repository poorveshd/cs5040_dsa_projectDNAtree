import student.TestCase;

/**
 * LeafNodeTest Class contains test cases for
 * `LeafNode` class.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 3/9/2022
 */
public class LeafNodeTest extends TestCase {
    /**
     * Test for checking if it stores the correct sequence.
     */
    public void testLeafNodeSequence() {
        // Create a leaf node with given sequence
        String sequence = "ACGGTTAAAAGGGT";
        LeafNode ln = new LeafNode(sequence);

        // Verify sequence is stored correctly
        assertTrue(ln.getSequence().equals(sequence));
    }


    /**
     * Test for checking that it's a leaf.
     */
    public void testIsLeaf() {
        // Create a leaf node with given sequence
        String sequence = "ACGGTTAAAAGGGT";
        LeafNode ln = new LeafNode(sequence);

        // Verify sequence is stored correctly
        assertTrue(ln.isLeaf());
    }
}
