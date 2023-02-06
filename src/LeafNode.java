/**
 * LeafNode class that extends Node class
 * and contains a DNA sequence as a character array.
 *
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 3/9/2022
 */
public class LeafNode extends Node {
    /** DNA sequence */
    private char[] sequence;

    /**
     * Constructor for `LeafNode`.
     * It stores the given String sequence as a character array.
     *
     * @param sequence
     *            DNA sequence to be stored in the leaf node
     */
    public LeafNode(String sequence) {
        this.sequence = StringOps.stringToCharArr(sequence);
    }


    /**
     * Get the sequence stored in leaf node.
     *
     * @return sequence stored in leaf node as `String`
     */
    public String getSequence() {
        return new String(sequence);
    }


    /**
     * Denote if this node is a leaf node
     *
     * @return boolean value of true denoting this node
     *         is a leaf
     */
    @Override
    public Boolean isLeaf() {
        return true;
    }
}
