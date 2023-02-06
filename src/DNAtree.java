// On my honor:
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project
// with anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.

/**
 * DNAtree Class contains the main function
 * that parses the input file containing DNA tree
 * operations, performs those operations and prints
 * the necessary output
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 3/9/2022
 */
public class DNAtree {
    /**
     * 1. Parse input file to obtain list of operations
     * to be performed on the DNA tree.
     * 2. Perform the operations requested.
     *
     * @param args
     *            list of command line arguments
     */
    public static void main(String[] args) {
        // Input file containing the list of operations
        final String inputFile = args[0];

        // Get list of operations
        FileParser fp = new FileParser(inputFile);
        final LList<String> operations = fp.readExpressions();

        // Instatiate the DNA tree
        Tree dnas = new Tree();

        for (operations.moveToStart(); !operations.isAtEnd(); operations
            .next()) {
            // Method call metadata contains name of the method
            // to be called and arguments of that method
            String[] methodCallMeta = operations.getValue().split(" ");

            // Insert a sequence into the tree
            if (methodCallMeta[0].equals("insert")) {
                dnas.insert(methodCallMeta[1]);
            }
            // Remove a sequence from the tree
            else if (methodCallMeta[0].equals("remove")) {
                dnas.remove(methodCallMeta[1]);
            }
            // Searches for sequence in the tree
            else if (methodCallMeta[0].equals("search")) {
                dnas.search(methodCallMeta[1]);
            }
            // Print contents of the tree based on given attribute
            else {
                dnas.print(methodCallMeta.length == 2 ? methodCallMeta[1] : "");
            }
        }
    }
}
