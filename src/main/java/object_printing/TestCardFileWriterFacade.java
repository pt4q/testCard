package object_printing;

import config.TestCardConfig;
import csv.CsvFileWriter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TestCardFileWriterFacade {

    @NonNull
    private TestCardConfig config;

    public void saveTestCardToFile(String filePath, String fileName, List<String> input) {
        CsvFileWriter csvFileWriter = new CsvFileWriter(config.getCsvConfig());
        csvFileWriter.saveStringListToFile(filePath, fileName, input);
    }
}
