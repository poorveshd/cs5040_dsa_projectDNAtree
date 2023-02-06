/**
 * InternalNode class that extends Node class
 * and contains children nodes that split the
 * internal nodes in 5 ways, each correponding
 * to a character from (A,C,G,T) except the last
 * child, which corresponds to prefix of any of the
 * sequences stored with the children corresponding
 * to (A,C,G,T).
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 3/9/2022
 */
public class InternalNode extends Node {
    /** Number of children nodes */
    private int numNodes;
    /**
     * Children of the internal node
     * Index 0...3 correspond to A,C,G,T sequentially
     * Index 4 corresponds to prefix of any sequence
     * stored on index 0...3
     */
    private Node[] children;

    /**
     * Constructor that initializes all the children
     * nodes with a flyweight node that is empty.
     *
     * @param numNodes
     *            number of children that an internal node
     *            is supposed to have
     */
    public InternalNode(int numNodes) {
        this.numNodes = numNodes;
        // Create an array of nodes
        // Nodes correspond to A,C,G,T,$
        children = new Node[numNodes];
        // Initially, all children should be flyweight nodes
        for (int i = 0; i < numNodes; i++) {
            children[i] = new FlyweightNode();
        }
    }


    /**
     * Get child node at given index from `children`.
     *
     * @param idx
     *            index of child in `children`
     *
     * @return node that corresponds to index idx in `children`
     */
    public Node getChild(int idx) {
        return idx < numNodes ? children[idx] : null;
    }


    /**
     * Set child node at given index from `children`.
     *
     * @param idx
     *            index of child in `children`
     * @param node
     *            node to be added at index `idx` in `children`
     */
    public void setChild(int idx, Node node) {
        // Index bounds check
        if (idx < numNodes) {
            children[idx] = node;
        }
    }


    /**
     * Get number of children of the internal node.
     *
     * @return number of children that internal node has
     */
    public int getNumChildren() {
        return numNodes;
    }


    /**
     * Get number of non-empty children of the internal node.
     *
     * @return number of children that internal node has
     */
    public int numNonEmptyChildren() {
        // Count number of non empty(flyweight) children that parent
        // node points to
        int nonEmptyChildren = 0;
        for (int i = 0; i < numNodes; i++) {
            // Child is non-empty node i.e either a leaf node or
            // an internal node
            if (!(children[i] instanceof FlyweightNode)) {
                nonEmptyChildren++;
            }
        }
        return nonEmptyChildren;
    }


    /**
     * Get index of first occurrence of a non-empty child.
     *
     * @return index of first non-empty child; -1 if not found.
     */
    public int idxFirstNonEmptyChild() {
        for (int i = 0; i < numNodes; i++) {
            // Return index if a non-empty child is found
            if (!(children[i] instanceof FlyweightNode)) {
                return i;
            }
        }
        // Return -1 if there are no non-empty children
        return -1;
    }


    /**
     * Denote if this node is a leaf
     *
     * @return boolean value of false denoting this node
     *         is not a leaf
     */
    @Override
    public Boolean isLeaf() {
        return false;
    }
}
