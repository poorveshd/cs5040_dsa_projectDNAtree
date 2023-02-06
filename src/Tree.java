/**
 * Tree Class consits of a 5-way DNA tree where
 * each branch corresponds to A,C,G,T and $(prefixes).
 * DNA sequences are stored as leaf nodes.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 3/9/2022
 */
public class Tree {
    /** Number of links inside an internal node */
    private final int numNodes = 5;
    /** Root of the tree */
    private Node root = new FlyweightNode();
    /** Number of nodes visited during a search */
    private int visited = 0;
    /** Matches of a search */
    private LList<String> matches = new LList<String>();

    /**
     * Insert given DNA sequence in the tree.
     * It does not insert the sequence if it is already present.
     *
     * @param sequence
     *            dna sequence to be inserted in the tree
     */
    public void insert(String sequence) {
        // If tree only consists of a single flyweight node
        if (root instanceof FlyweightNode) {
            // Replace it by a leaf node containing the sequence
            root = new LeafNode(sequence);
            System.out.println("sequence " + sequence + " inserted at level 0");
            return;
        }

        // If tree only consists of a single leaf node
        if (root.isLeaf()) {
            String curSequence = ((LeafNode)root).getSequence();
            // If leaf already contains sequence, don't insert
            if (curSequence.equals(sequence)) {
                System.out.println("sequence " + sequence + " already exists");
                return;
            }

            // Replace root by an internal node
            root = new InternalNode(numNodes);
            // If atleast first character matches between
            // existing(leaf node) sequence and given sequence
            if (curSequence.charAt(0) == sequence.charAt(0)) {
                // Split at the root and insert both nodes
                insertSplit((InternalNode)root, curSequence, sequence, 0);
            }
            // If first character doesn't match between
            // existing(leaf node) sequence and given sequence
            else {
                // Get branch number corresponding to first character
                final int curSeqBranch = branch(curSequence.charAt(0));
                final int newSeqBranch = branch(sequence.charAt(0));

                // Insert existing sequence and given sequence as leaf nodes
                // to the root (internal node)
                ((InternalNode)root).setChild(curSeqBranch, (Node)new LeafNode(
                    curSequence));
                ((InternalNode)root).setChild(newSeqBranch, (Node)new LeafNode(
                    sequence));
                System.out.println("sequence " + sequence
                    + " inserted at level 1");
            }
            return;
        }

        // Traverse downwards and insert as soon as a
        // flyweight node is encountered. If a leaf node
        // is encountered, split on that node
        insertTraverse((InternalNode)root, sequence, 0);
    }


    /**
     * Remove a sequence from the tree, if present.
     * Print whether sequence was removed from
     * the tree or it does not exists.
     *
     * @param sequence
     *            dna sequence to be removed from the tree
     */
    public void remove(String sequence) {
        // Remove the node, if it exists and update the root accordingly
        root = remover(sequence, root, 0);
    }


    /**
     * Search exact and/or prefix match for a sequence
     * in the tree. Print whether sequence is found or not.
     *
     * @param sequence
     *            dna sequence to be searched in the tree
     */
    public void search(String sequence) {
        // Reset variables needed to keep track of sequences
        // that are found to be a match
        visited = 0;
        matches.clear();

        // Check whether to look for prefixes along with exact matches
        final boolean exact = sequence.endsWith("$");
        // Remove '$' from the sequence, if present
        if (exact) {
            sequence = sequence.substring(0, sequence.length() - 1);
        }

        // Start searching from root onwards
        searcher(sequence, exact, root, 0);
        // Print number of nodes visited by the searcher method
        System.out.println("# of nodes visited: " + visited);
        // Zero matches
        if (matches.length() == 0) {
            System.out.println("no sequence found");
            return;
        }

        // Print every match
        for (matches.moveToStart(); !matches.isAtEnd(); matches.next()) {
            System.out.println("sequence: " + matches.getValue());
        }
    }


    /**
     * Print tree structure based on the attribute argument.
     *
     * @param attrib
     *            attribute that tells how to print DNA sequences
     *            within the tree
     */
    public void print(String attrib) {
        System.out.println("tree dump:");
        printAny(attrib, root, 0);
    }


    /**
     * Insert given DNA sequence in the tree by traversing
     * the tree.
     * 1. If flyweight node is encountered, replace it.
     * 2. If leaf node is encountered, split on the node.
     * 3. Otherwise in case of internal node, navigate downwards.
     *
     * @param parent
     *            internal node from where to insert given sequence
     *            or navigate through
     * @param sequence
     *            dna sequence to be inserted into the tree
     * @param level
     *            level of `parent` in the tree
     */
    private void insertTraverse(
        InternalNode parent,
        String sequence,
        int level) {
        // Decide branch for element at index `level` of sequence
        final int branch = branch(level < sequence.length()
            ? sequence.charAt(level)
            : '$');

        // Branch contains flyweight node
        if (parent.getChild(branch) instanceof FlyweightNode) {
            // Replace flyweight node with leaf node containing sequence
            parent.setChild(branch, (Node)new LeafNode(sequence));
            System.out.println("sequence " + sequence + " inserted at level "
                + (level + 1));
            return;
        }

        // Branch contains leaf node
        if (parent.getChild(branch).isLeaf()) {
            // Get sequence within the existing leaf node
            String curSequence = ((LeafNode)parent.getChild(branch))
                .getSequence();

            // Sequence in leaf node is equal to given sequence
            if (curSequence.equals(sequence)) {
                // Don't insert sequence
                System.out.println("sequence " + sequence + " already exists");
            }
            // Split on the leaf node
            // Navigate downwards until there is an element mismatch between
            // the existing sequence and the given sequence; and insert them
            // both on the same level
            else {
                // Replace existing leaf node with internal node
                parent.setChild(branch, (Node)new InternalNode(numNodes));

                parent = (InternalNode)parent.getChild(branch);
                insertSplit(parent, curSequence, sequence, level + 1);
            }
            return;
        }

        // Traverse downwards and insert as soon as a
        // flyweight node is encountered. If a leaf node
        // is encountered, split on that node
        insertTraverse((InternalNode)parent.getChild(branch), sequence, level
            + 1);
    }


    /**
     * Split on the given parent node.
     * 1. While sequence element at index `level` is same for
     * both sequence1 and sequence2, navigate downloads by
     * choosing the corresponding branches of each element.
     * 2. Otherwise, insert both sequences under `parent` i.e.
     * on `level + 1`.
     *
     * @param parent
     *            internal node from where to insert given sequence
     *            or navigate through
     * @param sequence1
     *            dna sequence to be inserted into the tree
     * @param sequence2
     *            dna sequence to be inserted into the tree
     * @param level
     *            level of `parent` in the tree
     */
    private void insertSplit(
        InternalNode parent,
        String sequence1,
        String sequence2,
        int level) {

        // Get characters within bounds, otherwise use '$'
        final char element1 = level < sequence1.length()
            ? sequence1.charAt(level)
            : '$';
        final char element2 = level < sequence2.length()
            ? sequence2.charAt(level)
            : '$';

        // Element at index `level` in sequence1 is not equal
        // to the same corresponding element in sequence2
        if (element1 != element2) {
            // Insert both the sequences under parent
            parent.setChild(branch(element1), (Node)new LeafNode(sequence1));
            parent.setChild(branch(element2), (Node)new LeafNode(sequence2));

            System.out.println("sequence " + sequence2 + " inserted at level "
                + (level + 1));
            return;
        }

        // Element at index `level` in sequence1 is equal
        // to the same corresponding element in sequence2

        // Add an internal node under parent
        parent.setChild(branch(element1), (Node)new InternalNode(numNodes));

        // Change parent's handle to point to the branch
        // corresponding to the element at index `level + 1` in sequence1
        parent = (InternalNode)parent.getChild(branch(element1));
        // Split on parent and repeat the above algorithm until
        // there is an element mismatch between both the sequences
        insertSplit(parent, sequence1, sequence2, level + 1);
    }


    /**
     * Remove a sequence from the tree, if present.
     * Print whether sequence was removed from
     * the tree or it does not exists.
     *
     * @param sequence
     *            dna sequence to be removed from the tree
     * @param node
     *            current node to check for sequence
     * @param level
     *            level of current node in the tree
     *
     * @return updated value of node after merging with siblings
     */
    private Node remover(String sequence, Node node, int level) {
        // In-case of flyweight node, print "does not exist"
        // and keep it untouched
        if (node instanceof FlyweightNode) {
            System.out.println("sequence " + sequence + " does not exist");
            return node;
        }

        // In-case of leaf node, check it's sequence
        // 1. If sequence matches, replace by flyweight node and print "removed"
        // 2. Otherwise, print "does not exist" and leave the node untouched
        if (node.isLeaf()) {
            if (((LeafNode)node).getSequence().equals(sequence)) {
                System.out.println("sequence " + sequence + " removed");
                return new FlyweightNode();
            }
            System.out.println("sequence " + sequence + " does not exist");
            return node;
        }

        // In-case of internal node, apply `remover` to target branch
        InternalNode parent = (InternalNode)node;
        // Decide branch based on char at index `level` in sequence
        final int branch = branch(level < sequence.length()
            ? sequence.charAt(level)
            : '$');
        parent.setChild(branch, remover(sequence, parent.getChild(branch), level
            + 1));

        // Number of non-empty nodes that parent points to
        final int nonEmptyChildren = parent.numNonEmptyChildren();
        // One non-empty child remaining: merge if the child is a leaf node
        if (nonEmptyChildren == 1) {
            // Index of non-empty child
            final int idx = parent.idxFirstNonEmptyChild();
            // If non-empty child is leaf, return child; otherwise return `node`
            return parent.getChild(idx).isLeaf() ? parent.getChild(idx) : node;
        }
        // More than 1 non-empty children remaining: don't merge
        return node;
    }


    /**
     * Search for exact and/or prefix match in a sequence
     * in the tree. Print whether sequence is found or not.
     * Search only exact matches if exact flag is set.
     *
     * @param sequence
     *            dna sequence to be searched in the tree
     * @param exact
     *            true if only exact matches are required
     *            and not prefix matches
     * @param node
     *            current node to be searched into
     * @param level
     *            level of current node
     */
    private void searcher(
        String sequence,
        boolean exact,
        Node node,
        int level) {
        visited++;
        // In-case of flyweight node, simply return
        if (node instanceof FlyweightNode) {
            return;
        }
        // In-case of leaf node, match based on `exact` flag
        if (node.isLeaf()) {
            // Current sequence in the leaf node
            String cur = ((LeafNode)node).getSequence();
            // 1. If exact flag is set,check only for exact match with sequence
            // 2. Otherwise, check if current sequence starts with sequence
            // Append the match to the list, if found
            if (exact ? cur.equals(sequence) : cur.startsWith(sequence)) {
                matches.append(cur);
            }
            return;
        }

        // In-case of internal node, get target branch
        InternalNode parent = ((InternalNode)node);
        final int branch = branch(level < sequence.length()
            ? sequence.charAt(level)
            : '$');

        // If `level` is within bounds of sequence length, recursively search
        // branch corresponding to index `level` in children nodes of `parent`
        if (level < sequence.length()) {
            searcher(sequence, exact, parent.getChild(branch), level + 1);
            return;
        }

        // If only exact match is needed, recursively search the '$' node
        if (exact) {
            searcher(sequence, exact, parent.getChild(numNodes - 1), level + 1);
            return;
        }

        // If prefixes are also to be search or `level` is greater than or
        // equal to length of sequence, search recursively through all
        // the children
        for (int i = 0; i < numNodes; i++) {
            searcher(sequence, exact, parent.getChild(i), level + 1);
        }
    }


    /**
     * Print tree structure recursively with/without frequencies and
     * lengths of DNA sequences in the tree based on the attribute argument.
     *
     * @param attrib
     *            attribute that tells how to print DNA sequences
     *            within the tree
     * @param node
     *            node that is to be printed
     * @param level
     *            level of the given node in the tree
     */
    private void printAny(String attrib, Node node, int level) {
        // Generate indentation string based on level
        String indentation = "";
        for (int i = 0; i < level; i++) {
            indentation += "  ";
        }

        // In case of leaf node, print the sequence along with the
        // require attribute
        if (node.isLeaf()) {
            String sequence = ((LeafNode)node).getSequence();
            System.out.println(indentation + sequence + suffix(attrib,
                sequence));
            return;
        }

        // In case of flyweight node, print "E"
        if (node instanceof FlyweightNode) {
            System.out.println(indentation + "E");
            return;
        }

        // In case of internal node, print "I"
        // and recursively print it's children nodes
        System.out.println(indentation + "I");
        for (int i = 0; i < numNodes; i++) {
            printAny(attrib, ((InternalNode)node).getChild(i), level + 1);
        }
    }


    /**
     * Generate suffix to be appended at the end of any
     * DNA sequence while printing the tree.
     *
     * @param attrib
     *            attribute that tells what suffix is to be generated
     * @param sequence
     *            dna sequence for which suffix is to be generated
     *
     * @return suffix that was generated based on given attribute
     */
    private String suffix(String attrib, String sequence) {
        // Length(of sequence) attribute is required
        if (attrib.equals("lengths")) {
            // Return string contain length of given sequence
            return " " + Integer.toString(sequence.length());
        }
        // Statistics(within sequence) attribute is required
        if (attrib.equals("stats")) {
            final int total = sequence.length();

            // Calculate frequencies of each element with
            // the given dna sequence
            int[] freq = { 0, 0, 0, 0 };
            for (char element : sequence.toCharArray()) {
                freq[branch(element)]++;
            }
            // Return the frequences of elements within the sequence
            return String.format(" A:%.2f C:%.2f G:%.2f T:%.2f", (float)freq[0]
                / total * 100, (float)freq[1] / total * 100, (float)freq[2]
                    / total * 100, (float)freq[3] / total * 100);
        }
        // Return an empty string if nothing is required
        return "";
    }


    /**
     * Location(branch) within an internal node's array of children
     * nodes that corresponds to the given character of DNA sequence.
     *
     * @param element
     *            character within a sequence for which branch is to be chosen
     *
     * @return index within `children` array of an internal node
     */
    private int branch(final char element) {
        switch (element) {
            // Node A is at index 0
            case 'A':
                return 0;
            // Node C is at index 1
            case 'C':
                return 1;
            // Node G is at index 2
            case 'G':
                return 2;
            // Node T is at index 3
            case 'T':
                return 3;
            // Node $ is at index 4
            default:
                return 4;
        }
    }
}
