import student.TestCase;

/**
 * StringOpsTest Class contains test cases for
 * `StringOps` class.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 3/9/2022
 */
public class StringOpsTest extends TestCase {
    /**
     * Test for detecting correct integer.
     */
    public void testStringOpsIsIntegerCorrect() {
        // Correct input string for checking whether it is integer or not
        final String str = "342123412379878978978";
        assertTrue(StringOps.isInteger(str));
    }


    /**
     * Test for detecting wrong integer.
     */
    public void testStringOpsIsIntegerWrong() {
        // Wrong input string for checking whether it is integer or not
        final String str = "34212341237987c978978";
        assertFalse(StringOps.isInteger(str));
    }


    /**
     * Test for adding prefix zeros to string.
     */
    public void testStringOpsAddPrefixZeros() {
        // Input string for adding prefix zeros
        final String str = "5";
        // Number of zeros to be prefixed
        final int numZeros = 2;

        // Expected string
        final String expectedResult = "005";
        // String obtained after prefixing zeros
        final String result = StringOps.addPrefixZeros(str, numZeros);
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for removing prefix zeros to string containing
     * non-zero integer.
     */
    public void testStringOpsRemovePrefixZerosNonZeroInteger() {
        // Input string of non-zero integer with leading zeros
        final String str = "0000050";

        // Expected string
        final String expectedResult = "50";
        // String obtained after removing leading zeros
        final String result = StringOps.removePrefixZeros(str);
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for removing prefix zeros to string containing
     * 'zero' integer.
     */
    public void testStringOpsRemovePrefixZerosZeroInteger() {
        // Input string containing multiple zeros
        final String str = "0000000";

        // Expected string
        final String expectedResult = "0";
        // String obtained after removing leading zeros
        final String result = StringOps.removePrefixZeros(str);
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for converting string to character array.
     */
    public void testStringOpsStringToCharArr() {
        // Target character array
        final char[] expectedResult = { 'C', 'A', 'T', 'G', 'T' };

        // Input string
        final String str = "CATGT";
        // String `str` as character array
        final char[] result = StringOps.stringToCharArr(str);
        // Verify length of character array
        assertEquals(result.length, expectedResult.length);
        // Verify contents of character array
        for (int i = 0; i < result.length; i++) {
            assertEquals(result[i], expectedResult[i]);
        }
    }
}
