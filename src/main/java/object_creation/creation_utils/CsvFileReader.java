package object_creation.creation_utils;

import com.opencsv.CSVReader;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CsvFileReader {

    private String pathToFile = null;
    private static final String FILE_NOT_FOUND = "File not found";
    private static final String READING_ERR = "File reading error";
    private String fileSeparator = ";";

    public CsvFileReader(String fileSeparator) {
        this.fileSeparator = fileSeparator;
    }

    public Map<Integer, List<String>> read() {
        Map<Integer, List<String>> lines = new HashMap<>();
        Map<Integer, List<String>> tmpLines;
        CSVReader csvReader;

            try {
                Reader reader = Files.newBufferedReader(Paths.get(pathToFile));
                csvReader = new CSVReader(reader);

                lines = mapValueConverter(readLineByLine(csvReader));

            } catch (IOException e) {
                throw new IllegalArgumentException(FILE_NOT_FOUND);
            }
        return lines;
    }


    private Map<Integer, String[]> readLineByLine(CSVReader reader) {
        Map<Integer, String[]> lines = new HashMap<>();
        try {
            int i = 0;
            List<String[]> strings = reader.readAll();
            for (String[] line : strings) {
                lines.put(i, splitLine(line));
                i++;
            }
            System.out.println("Readed " + lines.size() + " lines");

        } catch (IOException e) {
            throw new IllegalArgumentException(READING_ERR);
        }
        return lines;
    }

    private String[] splitLine(String[] input) {
        String line = Arrays.stream(input)
                .map(s -> s + ".")
                .collect(Collectors.joining());

        line = line.substring(0, line.length() - 1);
        return line.split(fileSeparator);
    }

    private Map<Integer, List<String>> mapValueConverter(Map<Integer, String[]> inputMap) {
        Map<Integer, List<String>> resultMap = new HashMap<>();

        for (Map.Entry<Integer, String[]> entry : inputMap.entrySet()) {
            resultMap.put(entry.getKey(), convertStringArrToList(entry.getValue()));
        }

        return resultMap;
    }

    private List<String> convertStringArrToList(String[] input) {
        return Arrays.stream(input)
                .collect(Collectors.toList());
    }
}
