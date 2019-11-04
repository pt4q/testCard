package object_creation;

import domain.TestCard;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_creation.creation_utils.CsvFileReader;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import object_creation.test_card.config.TestCardColumnsNumbers;
import object_creation.test_card.TestCardCreator;
import object_creation.test_card.config.TestCardConfig;

import java.util.Map;

@RequiredArgsConstructor
public class ReadTestCardFromFile {

    @NonNull
    private TestCardConfig config;
    private TestCard testCard;

    public TestCard createTestCardFromFile(String pathToFile) throws RecognizeParamTypeException {
        CsvFileReader reader = new CsvFileReader().builder()
                .pathToFile(pathToFile)
                .fileSeparator("\t")
                .build();

        Map lines = reader.read();

        testCard = new TestCardCreator(config).create(lines);
        return testCard;
    }

    public TestCard calcScores(){

        return null;
    }
}
