import domain.TestCard;
import object_creation.ReadTestCardFromFile;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import config.BinaryTypePositiveDefinition;
import config.TestCardColumnsNumbers;
import config.TestCardConfig;
import config.TestCardParamMarks;
import object_printing.TestCardPrinter;

import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        String path = "D:\\KP\\Workspace\\Java\\testCard\\src\\test\\resources\\DED7850 Karta badań - Młotowiertarka_ref.csv";

        TestCardConfig testCardConfig;
        ReadTestCardFromFile testCardReader;
        TestCardPrinter testCardPrinter;
        TestCard testCard = null;

        TestCardColumnsNumbers testCardColumnsNumbers = new TestCardColumnsNumbers(0, 1, 2, 2, 3,3, 4);
        TestCardParamMarks testCardParamMarks = new TestCardParamMarks("#", "h", "b", "n", "f", "i");
        BinaryTypePositiveDefinition positiveDefinition = new BinaryTypePositiveDefinition(Arrays.asList("ok", "tak", "yes"),"TAK","NIE");

        testCardConfig = new TestCardConfig(testCardColumnsNumbers, testCardParamMarks, positiveDefinition);

        testCardReader = new ReadTestCardFromFile(testCardConfig);
        try {
            testCard = testCardReader.createTestCardFromFile(path);
        } catch (RecognizeParamTypeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nu^u^u^u\tTest card created successfully!!!\tu^u^u^u\n");

        testCardPrinter = new TestCardPrinter(testCardConfig);
//        List<String> testCardGeneratedLines = testCardPrinter.generateStringLines(testCard);

//        if (testCard != null)
//            System.out.println(testCardPrinter.generate(testCard));

    }
}
