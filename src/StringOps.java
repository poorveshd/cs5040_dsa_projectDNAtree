/**
 * StringOps Class is used for any string-related operations.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 3/9/2022
 */
public class StringOps {
    /**
     * Check whether string contents represent an integer.
     *
     * @param str
     *            input string
     *
     * @return true of string represents an integer; otherwise false
     */
    public static boolean isInteger(String str) {
        return str.matches("-?\\d+");
    }


    /**
     * Prepend zeros to the string.
     *
     * @param str
     *            input string
     * @param numZeros
     *            number of zeros to be prepended
     *
     * @return string with zeros prepended to it
     */
    public static String addPrefixZeros(String str, int numZeros) {
        // String of zeros where number of zeros is `numZeros`
        String zeroPadding = new String(new char[numZeros]).replace('\0', '0');
        // Concat the zero-padding with `str`
        return zeroPadding.concat(str);
    }


    /**
     * Remove any zeros that are prefixed to the string.
     *
     * @param str
     *            input string
     *
     * @return string with any prefixed zeros stripped off
     */
    public static String removePrefixZeros(String str) {
        // As soon as a non-zero character is encountered,
        // return substring from that index till the end
        // of the string `str`

        // `i` is index for ith character of `str`
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != '0') {
                return str.substring(i);
            }
        }
        // Handle the case whether `str` only consists
        // of zeros
        return str.substring(str.length() - 1);
    }


    /**
     * Convert string to character array.
     *
     * @param str
     *            input string
     *
     * @return character array representation of string
     */
    public static char[] stringToCharArr(String str) {
        // Create character array of length `str.length()`
        char[] arr = new char[str.length()];
        // Populate character array with string characters
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }
}
