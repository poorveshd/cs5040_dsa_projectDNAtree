import student.TestCase;

/**
 * TreeTest Class contains test cases for
 * `Tree` class (DNA tree).
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 3/9/2022
 */
public class TreeTest extends TestCase {
    /**
     * Test for simple single insert into the tree.
     */
    public void testTreeSimpleSingleInsert() {
        // Expected output
        final String expectedResult = "sequence ACGT inserted at level 0\n";

        // Insert approapriate elements into the tree
        Tree tr = new Tree();
        tr.insert("ACGT");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for simple double insert into the tree
     * that inserts a same element twice.
     */
    public void testTreeSimpleDoubleInsert() {
        // Expected output
        String expectedResult = String.join("",
            "sequence ACGT inserted at level 0\n",
            "sequence ACGT already exists\n");

        // Insert approapriate elements into the tree
        Tree tr = new Tree();
        tr.insert("ACGT");
        tr.insert("ACGT");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for complex inserts into the tree.
     */
    public void testTreeComplexInsert() {
        // Expected output
        String expectedResult = String.join("",
            "sequence AGGT inserted at level 0\n"
                + "sequence AAAA inserted at level 2\n"
                + "sequence GGGG inserted at level 1\n"
                + "sequence GA inserted at level 2\n"
                + "sequence GACT inserted at level 3\n"
                + "sequence AAAA already exists\n"
                + "sequence AAA inserted at level 4\n");

        // Insert approapriate elements into the tree
        Tree tr = new Tree();
        tr.insert("AGGT");
        tr.insert("AAAA");
        tr.insert("GGGG");
        tr.insert("GA");
        tr.insert("GACT");
        tr.insert("AAAA");
        tr.insert("AAA");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for checking a simple remove from the tree
     * for an existing element.
     */
    public void testTreeRemoveFound() {
        // Expected output
        String expectedResult = String.join("",
            "sequence ACGT inserted at level 0\n", "sequence ACGT removed\n");

        // Insert and remove approapriate elements from tree
        Tree tr = new Tree();
        tr.insert("ACGT");
        tr.remove("ACGT");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for checking a remove from the tree
     * for a non-existing element.
     */
    public void testTreeRemoveNotFound() {
        // Expected output
        String expectedResult = String.join("",
            "sequence ACGT inserted at level 0\n",
            "sequence GACT does not exist\n");

        // Insert and remove approapriate elements from tree
        Tree tr = new Tree();
        tr.insert("ACGT");
        tr.remove("GACT");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for checking a remove from the tree
     * where the element is not found and search
     * reaches an empty node.
     */
    public void testTreeRemoveEndsOnFlyweight() {
        // Expected output
        String expectedResult = String.join("",
            "sequence ACGT inserted at level 0\n"
                + "sequence GACT inserted at level 1\n"
                + "sequence TTGA does not exist\n");

        // Insert and remove approapriate elements from tree
        Tree tr = new Tree();
        tr.insert("ACGT");
        tr.insert("GACT");
        tr.remove("TTGA");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for checking a complex remove from the tree
     * for an existing element.
     */
    public void testTreeRemoveComplexFound() {
        // Expected output
        String expectedResult = String.join("",
            "sequence ACGT inserted at level 0\n"
                + "sequence AACT inserted at level 2\n"
                + "sequence A inserted at level 2\n"
                + "sequence AAAA inserted at level 3\n"
                + "sequence AA inserted at level 3\n" + "sequence A removed\n");

        // Insert and remove approapriate elements from tree
        Tree tr = new Tree();
        tr.insert("ACGT");
        tr.insert("AACT");
        tr.insert("A");
        tr.insert("AAAA");
        tr.insert("AA");
        tr.remove("A");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for checking a complex remove from the tree
     * for a non-existing element.
     */
    public void testTreeRemoveComplexNotFound() {
        // Expected output
        String expectedResult = String.join("",
            "sequence ACGT inserted at level 0\n"
                + "sequence AACT inserted at level 2\n"
                + "sequence A inserted at level 2\n"
                + "sequence AAAA inserted at level 3\n"
                + "sequence AA inserted at level 3\n"
                + "sequence AAA does not exist\n");

        // Insert and remove approapriate elements from tree
        Tree tr = new Tree();
        tr.insert("ACGT");
        tr.insert("AACT");
        tr.insert("A");
        tr.insert("AAAA");
        tr.insert("AA");
        tr.remove("AAA");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for checking a simple search on the tree
     * for an existing element.
     */
    public void testTreeSimpleSearchFound() {
        // Expected output
        String expectedResult = String.join("",
            "sequence ACGT inserted at level 0\n", "# of nodes visited: 1\n"
                + "sequence: ACGT\n");

        // Insert and search approapriate elements from tree
        Tree tr = new Tree();
        tr.insert("ACGT");
        tr.search("ACGT");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for checking a simple search on the tree
     * for a non-existing element.
     */
    public void testTreeSimpleSearchNotFound() {
        // Expected output
        String expectedResult = String.join("",
            "sequence ACGT inserted at level 0\n", "# of nodes visited: 1\n"
                + "no sequence found\n");

        // Insert and search approapriate elements from tree
        Tree tr = new Tree();
        tr.insert("ACGT");
        tr.search("GACT");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for checking a complex search on the tree
     * for existing elements.
     */
    public void testTreeComplexSearchFound() {
        // Expected output
        String expectedResult = String.join("",
            "sequence ACGT inserted at level 0\n"
                + "sequence AACT inserted at level 2\n"
                + "sequence A inserted at level 2\n"
                + "sequence AAAA inserted at level 3\n"
                + "sequence AA inserted at level 3\n"
                + "# of nodes visited: 8\n" + "sequence: AAAA\n"
                + "sequence: AACT\n" + "sequence: AA\n");

        // Insert and search approapriate elements from tree
        Tree tr = new Tree();
        tr.insert("ACGT");
        tr.insert("AACT");
        tr.insert("A");
        tr.insert("AAAA");
        tr.insert("AA");
        tr.search("AA");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for checking a complex search on the tree
     * for an exact match of an existing element.
     */
    public void testTreeComplexSearchExactFound() {
        // Expected output
        String expectedResult = String.join("",
            "sequence ACGT inserted at level 0\n"
                + "sequence AACT inserted at level 2\n"
                + "sequence A inserted at level 2\n"
                + "sequence AAAA inserted at level 3\n"
                + "sequence AA inserted at level 3\n"
                + "# of nodes visited: 4\n" + "sequence: AA\n");

        // Insert and search approapriate elements from tree
        Tree tr = new Tree();
        tr.insert("ACGT");
        tr.insert("AACT");
        tr.insert("A");
        tr.insert("AAAA");
        tr.insert("AA");
        tr.search("AA$");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for checking a complex search on the tree
     * for a non-existing element.
     */
    public void testTreeComplexSearchNotFound() {
        // Expected output
        String expectedResult = String.join("",
            "sequence ACGT inserted at level 0\n"
                + "sequence AACT inserted at level 2\n"
                + "sequence A inserted at level 2\n"
                + "sequence AAAA inserted at level 3\n"
                + "sequence AA inserted at level 3\n"
                + "# of nodes visited: 4\n" + "no sequence found\n");

        // Insert and search approapriate elements from tree
        Tree tr = new Tree();
        tr.insert("ACGT");
        tr.insert("AACT");
        tr.insert("A");
        tr.insert("AAAA");
        tr.insert("AA");
        tr.search("AAA$");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for checking a simple print with no arguments.
     */
    public void testTreeSimplePrintRegular() {
        // Expected output
        String expectedResult = String.join("",
            "sequence ACGT inserted at level 0\n", "tree dump:\n", "ACGT\n");

        // Insert and print elements from tree
        Tree tr = new Tree();
        tr.insert("ACGT");
        tr.print("");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for checking a complex print with no arguments.
     */
    public void testTreeComplexPrintRegular() {
        // Expected output
        String expectedResult = String.join("",
            "sequence CCGT inserted at level 0\n"
                + "sequence GACT inserted at level 1\n"
                + "sequence A inserted at level 1\n"
                + "sequence TAAA inserted at level 1\n"
                + "sequence TA inserted at level 3\n" + "tree dump:\n" + "I\n"
                + "  A\n" + "  CCGT\n" + "  GACT\n" + "  I\n" + "    I\n"
                + "      TAAA\n" + "      E\n" + "      E\n" + "      E\n"
                + "      TA\n" + "    E\n" + "    E\n" + "    E\n" + "    E\n"
                + "  E\n");

        // Insert elements and print tree
        Tree tr = new Tree();
        tr.insert("CCGT");
        tr.insert("GACT");
        tr.insert("A");
        tr.insert("TAAA");
        tr.insert("TA");
        tr.print("");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for checking a simple print with "lengths" argument.
     */
    public void testTreeSimplePrintLengths() {
        // Expected output
        String expectedResult = String.join("",
            "sequence ACGT inserted at level 0\n", "tree dump:\n", "ACGT 4\n");

        // Insert elements and print tree
        Tree tr = new Tree();
        tr.insert("ACGT");
        tr.print("lengths");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for checking a complex print with "lengths" arguments.
     */
    public void testTreeComplexPrintLengths() {
        // Expected output
        String expectedResult = String.join("",
            "sequence CCGT inserted at level 0\n"
                + "sequence GACT inserted at level 1\n"
                + "sequence A inserted at level 1\n"
                + "sequence TAAA inserted at level 1\n"
                + "sequence TA inserted at level 3\n" + "tree dump:\n" + "I\n"
                + "  A 1\n" + "  CCGT 4\n" + "  GACT 4\n" + "  I\n" + "    I\n"
                + "      TAAA 4\n" + "      E\n" + "      E\n" + "      E\n"
                + "      TA 2\n" + "    E\n" + "    E\n" + "    E\n" + "    E\n"
                + "  E\n");

        // Insert elements and print tree
        Tree tr = new Tree();
        tr.insert("CCGT");
        tr.insert("GACT");
        tr.insert("A");
        tr.insert("TAAA");
        tr.insert("TA");
        tr.print("lengths");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for checking a simple print with "stats" argument.
     */
    public void testTreeSimplePrintStats() {
        // Expected output
        String expectedResult = String.join("",
            "sequence ACGT inserted at level 0\n", "tree dump:\n",
            "ACGT A:25.00 C:25.00 G:25.00 T:25.00\n");

        // Insert elements and print tree
        Tree tr = new Tree();
        tr.insert("ACGT");
        tr.print("stats");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for checking a complex print with "lengths" arguments.
     */
    public void testTreeComplexPrintStats() {
        // Expected output
        String expectedResult = String.join("",
            "sequence CCGT inserted at level 0\n"
                + "sequence GACT inserted at level 1\n"
                + "sequence A inserted at level 1\n"
                + "sequence TAAA inserted at level 1\n"
                + "sequence TA inserted at level 3\n" + "tree dump:\n" + "I\n"
                + "  A A:100.00 C:0.00 G:0.00 T:0.00\n"
                + "  CCGT A:0.00 C:50.00 G:25.00 T:25.00\n"
                + "  GACT A:25.00 C:25.00 G:25.00 T:25.00\n" + "  I\n"
                + "    I\n" + "      TAAA A:75.00 C:0.00 G:0.00 T:25.00\n"
                + "      E\n" + "      E\n" + "      E\n"
                + "      TA A:50.00 C:0.00 G:0.00 T:50.00\n" + "    E\n"
                + "    E\n" + "    E\n" + "    E\n" + "  E\n");

        // Insert elements and print tree
        Tree tr = new Tree();
        tr.insert("CCGT");
        tr.insert("GACT");
        tr.insert("A");
        tr.insert("TAAA");
        tr.insert("TA");
        tr.print("stats");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for checking complex mixed operations on the tree.
     */
    public void testTreeComplexMixed() {
        // Expected output
        String expectedResult = String.join("",
            "sequence AAAAAAAA inserted at level 0\n"
                + "sequence AAAA inserted at level 5\n"
                + "sequence AA inserted at level 3\n"
                + "sequence AGACT inserted at level 2\n" + "tree dump:\n"
                + "I\n" + "  I\n" + "    I\n" + "      I\n" + "        I\n"
                + "          AAAAAAAA\n" + "          E\n" + "          E\n"
                + "          E\n" + "          AAAA\n" + "        E\n"
                + "        E\n" + "        E\n" + "        E\n" + "      E\n"
                + "      E\n" + "      E\n" + "      AA\n" + "    E\n"
                + "    AGACT\n" + "    E\n" + "    E\n" + "  E\n" + "  E\n"
                + "  E\n" + "  E\n" + "# of nodes visited: 5\n"
                + "no sequence found\n" + "sequence AAAA removed\n"
                + "# of nodes visited: 4\n" + "no sequence found\n");

        // Insert, search, remove elements and print tree
        Tree tr = new Tree();
        tr.insert("AAAAAAAA");
        tr.insert("AAAA");
        tr.insert("AA");
        tr.insert("AGACT");
        tr.print("");
        tr.search("AAA$");
        tr.remove("AAAA");
        tr.search("AAA$");

        // Get history of standard output
        String result = systemOut().getHistory();

        // Check obtain result with expected result
        assertTrue(result.equals(expectedResult));
    }
}
