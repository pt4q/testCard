import domain.TestCard;
import object_creation.ReadTestCardFromFile;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import object_creation.test_card.config.BinaryTypePositiveDefinition;
import object_creation.test_card.config.TestCardColumnsNumbers;
import object_creation.test_card.config.TestCardConfig;
import object_creation.test_card.config.TestCardParamMarks;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        String path = "D:\\KP\\Workspace\\Java\\testCard\\src\\test\\resources\\DED7850 Karta badań - Młotowiertarka_ref.csv";

        TestCard testCard;

        TestCardColumnsNumbers testCardColumnsNumbers = new TestCardColumnsNumbers(0,1,2,2,3,4);
        TestCardParamMarks testCardParamMarks = new TestCardParamMarks("#","h","b","n","f","i");
        BinaryTypePositiveDefinition positiveDefinition = new BinaryTypePositiveDefinition(Arrays.asList("ok","tak","yes"));
        TestCardConfig testCardConfig = new TestCardConfig(testCardColumnsNumbers, testCardParamMarks, positiveDefinition);

        ReadTestCardFromFile testCardReader = new ReadTestCardFromFile(testCardConfig);
        try {
            testCard = testCardReader.createTestCardFromFile(path);
        } catch (RecognizeParamTypeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nu^u^u^u\tTest card created successfully!!!\tu^u^u^u\n");
    }
}
