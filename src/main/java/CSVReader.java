package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Nick on 8/17/2017.
 */
public class CSVReader {
    private static final Logger LOGGER = Logger.getLogger(CSVReader.class.getName());

    public static Collection<String> getCSVByLine(String location) {
        InputStream is = CSVReader.class.getResourceAsStream(location);

        Collection<String> lines = new ArrayList<>();
        String line = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Error reading CSV file" + e.getMessage());
        }
        return lines;
    }
}
