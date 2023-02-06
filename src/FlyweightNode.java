/**
 * FlyweightNode class that extends Node class.
 * It consits of an empty node that only contains
 * a method that states it's not a leaf node.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 3/9/2022
 */
public class FlyweightNode extends Node {
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
