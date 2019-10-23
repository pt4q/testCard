package object_creation;

import domain.Param;
import domain.RangeOfResearch;
import domain.TestCard;
import lombok.NoArgsConstructor;
import object_creation.creation_utils.CsvFileReader;
import object_creation.test_card.TestCardCreator;

import java.util.Map;

@NoArgsConstructor
public class ReadTestCardFromFile {

    private TestCard testCard;

    public TestCard createTestCardFromFile(String pathToFile){
        CsvFileReader reader = new CsvFileReader().builder()
                .pathToFile(pathToFile)
                .fileSeparator("\t")
                .build();

        Map lines = reader.read();

        testCard = new TestCardCreator().create(lines);
        return testCard;
    }

    public TestCard calcScores(){

        return null;
    }
}
