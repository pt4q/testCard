package csv;

import com.opencsv.CSVWriter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.util.List;

@RequiredArgsConstructor
public class CsvFileWriter {

    @NonNull
    private CsvConfig config;

    public void saveStringListToFile(String filePath, String fileName, List<String> input) {
        char lineSeparator = config.getWriterSeparator().toCharacter();

        try (PrintWriter outputFile = new PrintWriter(new File(filePath + fileName))) {

            CSVWriter csvWriter = new CSVWriter(outputFile,
                    lineSeparator);

            for (String line : input) {
                saveToFile(csvWriter, line.split(config.getWriterSeparator().toString()));
//                saveToFile(outputFile, line);
            }

            System.out.println(fileName + " written in: " + filePath);

        } catch (IOException e) {
            throw new IllegalArgumentException(CsvOperationStatusEnum.FILE_CANT_BE_SAVE.toString());
        }
    }

    private void saveToFile(CSVWriter writer, String[] line) {
        writer.writeNext(line);
    }

    private void saveToFile(PrintWriter pw, String line) {
        pw.write(line);
    }
}
