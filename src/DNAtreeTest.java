import student.TestCase;

/**
 * DNAtreeTest Class contains test cases for
 * `DNAtree` class.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 3/9/2022
 */
public class DNAtreeTest extends TestCase {
    /**
     * Test the main function for mixed input.
     */
    public void testMainMixedInput() {
        // Arguments for the main method
        String[] args = { "input.txt" };
        DNAtree.main(args);

        // Expected output
        String expectedResult = String.join("",
            "sequence ACGT inserted at level 0\n"
                + "sequence AAAA inserted at level 2\n"
                + "sequence AA inserted at level 3\n" + "tree dump:\n" + "I\n"
                + "  I\n" + "    I\n" + "      AAAA\n" + "      E\n"
                + "      E\n" + "      E\n" + "      AA\n" + "    ACGT\n"
                + "    E\n" + "    E\n" + "    E\n" + "  E\n" + "  E\n"
                + "  E\n" + "  E\n" + "# of nodes visited: 4\n"
                + "sequence: AA\n" + "sequence AA removed\n"
                + "# of nodes visited: 3\n" + "sequence: AAAA\n"
                + "tree dump:\n" + "I\n" + "  I\n"
                + "    AAAA A:100.00 C:0.00 G:0.00 T:0.00\n"
                + "    ACGT A:25.00 C:25.00 G:25.00 T:25.00\n" + "    E\n"
                + "    E\n" + "    E\n" + "  E\n" + "  E\n" + "  E\n"
                + "  E\n");

        // Actual output
        String result = systemOut().getHistory();
        assertTrue(result.equals(expectedResult));
    }
}
