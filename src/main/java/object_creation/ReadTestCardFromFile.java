package object_creation;

import domain.Param;
import domain.RangeOfResearch;
import domain.TestCard;
import object_creation.creation_utils.CsvFileReader;

public class ReadTestCardFromFile {



    public TestCard readFromFile(String pathToFile){
        CsvFileReader reader = new CsvFileReader().builder()
                .pathToFile(pathToFile)
                .build();

        return null;
    }

    private TestCard testCardHeaderRecognizer(){
        return null;
    }

    private RangeOfResearch rangeOfResearchRecognizer(){
        return null;
    }

    private Param paramRecognizer() {
        return null;
    }
}
