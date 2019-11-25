package object_creation;

import domain.TestCard;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import csv.CsvFileReader;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import object_creation.test_card.TestCardCreator;
import config.TestCardConfig;

import java.util.Map;

@RequiredArgsConstructor
public class TestCardFileReaderFacade {

    @NonNull
    private TestCardConfig config;
    private TestCard testCard;

    public TestCard createTestCardFromFile(String pathToFile, String fileName) throws RecognizeParamTypeException {
        CsvFileReader reader = new CsvFileReader(config.getCsvConfig(), pathToFile, fileName);

        Map lines = reader.read();

        testCard = new TestCardCreator(config).create(lines);
        return testCard;
    }
}
