package csv;

import com.opencsv.CSVReader;
import lombok.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CsvFileReader {

    @NonNull
    private CsvConfig config;
    @NonNull
    private String pathToFile;
    @NonNull
    private String fileName;

//    public CsvFileReader(String fileSeparator) {
//        this.fileSeparator = fileSeparator;
//    }

    public Map<Integer, List<String>> read() {
        Map<Integer, List<String>> lines = new HashMap<>();
        Map<Integer, List<String>> tmpLines;
        CSVReader csvReader;

        try {
            Reader reader = Files.newBufferedReader(Paths.get(pathToFile + fileName));
            csvReader = new CSVReader(reader);

            lines = mapValueConverter(readLineByLine(csvReader));

        } catch (IOException e) {
            throw new IllegalArgumentException(CsvOperationStatusEnum.FILE_NOT_FOUND.toString());
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
            throw new IllegalArgumentException(CsvOperationStatusEnum.FILE_READING_ERR.toString());
        }
        return lines;
    }

    private String[] splitLine(String[] input) {
        String separator = config.getReaderSeparator().toString();
        String line = Arrays.stream(input)
                .map(s -> s + ".")
                .collect(Collectors.joining());

        line = line.substring(0, line.length() - 1);
        return line.split(separator);
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
