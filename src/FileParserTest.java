import student.TestCase;

/**
 * FileParserTest Class contains test cases for
 * `FileParser` class.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 3/7/2022
 */
public class FileParserTest extends TestCase {
    /**
     * Test for stripping arbitrary number of prefixed zeros
     * from an integer.
     */
    public void testFileParserPrefixZeros() {
        // Expected expressions
        LList<String> expectedResult = new LList<String>();
        expectedResult.append("The time is 2 pm");

        // `FileParser` instance for parsing given file
        FileParser fp = new FileParser("test_fileparser_zeros.txt");
        // Expressions parsed by `fp`
        final LList<String> result = fp.readExpressions();

        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for stripping arbitrary number of whitespace characters.
     */
    public void testFileParserWhiteSpace() {
        LList<String> expectedResult = new LList<String>();
        // Expected expressions
        expectedResult.append("The time is 2:50pm");

        // `FileParser` instance for parsing given file
        FileParser fp = new FileParser("test_fileparser_whitespace.txt");
        // Expressions parsed by `fp`
        final LList<String> result = fp.readExpressions();

        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for parsing an empty file.
     */
    public void testFileParserEmptyFile() {
        // Expected expressions
        LList<String> expectedResult = new LList<String>();

        // `FileParser` instance for parsing given file
        FileParser fp = new FileParser("test_fileparser_empty.txt");
        // Expressions parsed by `fp`
        final LList<String> result = fp.readExpressions();

        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for file containing multiple expressions.
     */
    public void testFileParserMultipleExpressions() {
        // Expected expressions
        LList<String> expectedResult = new LList<String>();
        expectedResult.append("The time is 6:50pm");
        expectedResult.append("The time is 12:20pm");
        expectedResult.append("The time is 9:00am");
        expectedResult.append("The time is 3:10am");

        // `FileParser` instance for parsing given file
        FileParser fp = new FileParser(
            "test_fileparser_multipleexpressions.txt");
        // Expressions parsed by `fp`
        final LList<String> result = fp.readExpressions();

        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for file that doesn't exist.
     */
    public void testFileParserFileDoesNotExist() {
        // `FileParser` instance for parsing given file
        FileParser fp = new FileParser("does_not_exist.txt");

        assertNull(fp.readExpressions());
    }
}
