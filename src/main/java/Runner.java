import config.*;
import domain.TestCard;
import object_calculation.TestCardCalculator;
import object_calculation.models.TestCardCalcModel;
import object_creation.ReadTestCardFromFile;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import object_printing.TestCardPrinter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        String path = "D:\\KP\\Workspace\\Java\\testCard\\src\\test\\resources\\DED7850 Karta badań - Młotowiertarka_ref.csv";

        TestCardConfig testCardConfig;
        ReadTestCardFromFile testCardReader;
        TestCardPrinter testCardPrinter;
        TestCard testCard = null;

        CsvConfig csvConfig = new CsvConfig(";");
        TestCardColumnsNumbers testCardColumnsNumbers = new TestCardColumnsNumbers(0, 1, 2, 2, 3, 3, 4);
        TestCardAndParamMarks testCardAndParamMarks = new TestCardAndParamMarks("#", "h", "b", "n", "f", "i");
        BinaryTypePositiveDefinition positiveDefinition = new BinaryTypePositiveDefinition(Arrays.asList("ok", "tak", "yes"), "TAK", "NIE");

        CalcConfig calcConfig = new CalcConfig(20.0);
        PrintConfig printConfig = new PrintConfig();

        testCardConfig = new TestCardConfig(csvConfig, testCardColumnsNumbers, testCardAndParamMarks, positiveDefinition, calcConfig, printConfig);

        testCardReader = new ReadTestCardFromFile(testCardConfig);
        try {
            testCard = testCardReader.createTestCardFromFile(path);
        } catch (RecognizeParamTypeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nu^u^u^u\tTest card created successfully!!!\tu^u^u^u\n");

        TestCardCalculator cardCalculator = new TestCardCalculator(testCardConfig);
        TestCardCalcModel testCardCalcModel = cardCalculator.calculate(testCard);

        System.out.println("\nu^u^u^u\tTest card calculated successfully!!!\tu^u^u^u\n");

//        testCardPrinter = new TestCardPrinter(testCardConfig);
//        List<String> testCardGeneratedLines = testCardPrinter.generateStringLines(testCard);

//        if (testCard != null)
//            System.out.println(testCardPrinter.generate(testCard));

    }
}
