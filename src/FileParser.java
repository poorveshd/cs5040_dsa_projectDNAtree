import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * FileParser Class is used to parse a text file containing
 * mathematical expressions on different lines.
 * It also strips off any extra whitespace characters.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 2/13/2022
 */
public class FileParser {
    // Absolute or relative path of the target text file
    private String file;

    /**
     * Constructor for `FileParser`.
     * It initializes the path for target text file.
     *
     * @param file
     *            absolute or relative path of the target text file
     */
    public FileParser(String file) {
        this.file = file;
    }


    /**
     * Read expressions from the target file and
     * strip any extra whitespace characters and
     * return the expressions. Return `null` if
     * file could not be found.
     *
     * @return list of expressions in the file as linked-list of `String`
     */
    public LList<String> readExpressions() {
        // Expressions from `file` as linked list of `String`
        LList<String> expressions = new LList<String>();

        // Scanner instance that would be used to parse `file`
        Scanner scnr = null;
        try {
            scnr = new Scanner(new File(file));
        }
        catch (FileNotFoundException e) {
            System.out.println("File " + file + " not found!");
            return null;
        }

        // Read every line in the given text file
        while (scnr.hasNextLine()) {
            // Eliminate leading and trailing spaces from the line
            String line = scnr.nextLine().trim();
            // Ignore lines that only contain newline or whitespace characters
            if (line.replaceAll("\\s", "").equals("")) {
                continue;
            }

            // Split the expression split by whitespace
            String[] tokens = line.split("\\s+");

            // Construct a space-separated `String` by using
            // every element in `tokens` array
            for (int i = 0; i < tokens.length; i++) {
                // In case of an integer, remove leading zeros
                if (StringOps.isInteger(tokens[i])) {
                    tokens[i] = StringOps.removePrefixZeros(tokens[i]);
                }
            }
            expressions.append(String.join(" ", tokens));
        }
        scnr.close();

        return expressions;
    }
}
