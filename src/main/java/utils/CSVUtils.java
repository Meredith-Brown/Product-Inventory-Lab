package utils;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CSVUtils {
    private static final char DEFAULT_SEPARATOR = ',';

    public static void writeLine(Writer w, List<String> values) throws IOException {
        boolean first = true;

        StringBuilder sb = new StringBuilder();

        for (String value : values) {
            if(!first) {
                sb.append(DEFAULT_SEPARATOR);
            }
            sb.append(value);
            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }
}

// TODO - "This integer will represent the nextId static value that is stored in the service class."
// To make this method reusable we will pass an Writer object representing the file to write to.
// The next parameter is a list of String objects that will represent the data of the object to write
// to CSV format. Now, wherever we want to write some values to CSV we can call this method and pass
// the values to the file and the data as a List.
