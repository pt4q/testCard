package csv;

import com.opencsv.CSVWriter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RequiredArgsConstructor
public class CsvFileWriter {

    @NonNull
    private CsvConfig config;

    public void saveStringListToFile(String filePath, String fileName, List<String> input) {
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(filePath + fileName));

            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            for (String line : input) {
                saveToFile(csvWriter, line.split(config.getWriterSeparator()));
            }

            System.out.println(fileName + " written in: " + filePath);

        } catch (IOException e) {
            throw new IllegalArgumentException(CsvOperationStatusEnum.FILE_CANT_BE_SAVE.toString());
        }
    }
    private void saveToFile(CSVWriter writer, String[] line){
        writer.writeNext(line);
    }
}
