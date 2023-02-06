import student.TestCase;

/**
 * InternalNodeTest Class contains test cases for
 * `InternalNode` class.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 3/9/2022
 */
public class InternalNodeTest extends TestCase {
    /**
     * Test for verifying that all the children are
     * instances of `FlyweightNode` after instantiating
     * an internal node.
     */
    public void testInternalNodeChildren() {
        // Create an internal node with 5 children
        final int numNodes = 5;
        InternalNode in = new InternalNode(numNodes);

        // Verify number of children
        assertEquals(in.getNumChildren(), numNodes);
        // Verify each child is a flyweight node
        for (int i = 0; i < numNodes; i++) {
            assertTrue(in.getChild(i) instanceof FlyweightNode);
        }
    }


    /**
     * Test for verifying if `getChild` method can handle
     * an input index in `children` array that is out of
     * bounds.
     */
    public void testInternalNodeGetChildOutOfBounds() {
        // Create an internal node with 5 children
        final int numNodes = 5;
        InternalNode in = new InternalNode(numNodes);

        // Verify null is returned if index of child
        // in `children` array is out of bounds
        assertNull(in.getChild(5));
    }


    /**
     * Test for verifying if `setChild` method can handle
     * an input index in `children` array that is out of
     * bounds.
     */
    public void testInternalNodeSetChildOutOfBounds() {
        // Create an internal node with 5 children
        final int numNodes = 5;
        InternalNode in = new InternalNode(numNodes);

        // Get current values of `children` array
        Node[] children = new Node[5];
        for (int i = 0; i < in.getNumChildren(); i++) {
            children[i] = in.getChild(i);
        }

        // Try to set an 'out of bounds' location
        // to point to the given leaf node
        in.setChild(5, new LeafNode("ACGT"));

        // Verify all values of children inside the
        // internal node are unchanged
        for (int i = 0; i < in.getNumChildren(); i++) {
            assertEquals(children[i], in.getChild(i));
        }
    }


    /**
     * Test for verifying if `idxFirstNonEmptyChild` method
     * can handle an input index in `children` array that
     * is out of bounds.
     */
    public void testInternalNodeIdxFirstNonEmptyChildOutOfBounds() {
        // Expected result
        final int expectedResult = -1;

        // Create an internal node with 5 children
        final int numNodes = 5;
        InternalNode in = new InternalNode(numNodes);

        // Verify if appropriate result is obtained
        assertEquals(in.idxFirstNonEmptyChild(), expectedResult);
    }


    /**
     * Test for checking that it's not a leaf.
     */
    public void testIsLeaf() {
        // Create an internal node with 5 children
        final int numNodes = 5;
        InternalNode in = new InternalNode(numNodes);

        // Verify it's not a leaf node
        assertFalse(in.isLeaf());
    }
}
