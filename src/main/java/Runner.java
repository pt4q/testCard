import picocli.CommandLine;
import ui.ConsoleUI;

public class Runner {
    public static void main(String[] args) {

        CommandLine commandLine = new CommandLine(new ConsoleUI());
        int exitCode = commandLine.execute(args);
        System.out.println("\nExit code: " + exitCode);

//        String fileNameForReader = "DED7850 Karta badań - Młotowiertarka_ref.csv";
//        String fileNameForWriter = "COMPUTED_" + fileNameForReader;
//
//        String pathToFile = "D:\\KP\\Workspace\\Java\\testCard\\src\\test\\resources\\";
//
//        TestCardConfig testCardConfig;
//        ReadTestCardFromFile testCardReader;
//        TestCardPrinter testCardPrinter;
//        TestCard testCard = null;
//
//        CsvConfig csvConfig = new CsvConfig(CsvFileSeparatorEnum.SEMICOLON, CsvFileSeparatorEnum.TAB);
//        TestCardColumnsNumbers testCardColumnsNumbers = new TestCardColumnsNumbers(0, 1, 2, 2, 3, 3, 4);
//        TestCardAndParamMarks testCardAndParamMarks = new TestCardAndParamMarks("#", "h", "b", "n", "f", "i");
//        BinaryTypePositiveDefinition positiveDefinition = new BinaryTypePositiveDefinition(Arrays.asList("ok", "tak", "yes"), "TAK", "NIE");
//
//        CalcConfig calcConfig = new CalcConfig(20.0);
//        PrintConfig printConfig = new PrintConfig();
//
//        testCardConfig = new TestCardConfig(csvConfig, testCardColumnsNumbers, testCardAndParamMarks, positiveDefinition, calcConfig, printConfig);
//
//        testCardReader = new ReadTestCardFromFile(testCardConfig);
//        try {
//            testCard = testCardReader.createTestCardFromFile(pathToFile, fileNameForReader);
//        } catch (RecognizeParamTypeException e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println("\nu^u^u^u\tTest card created successfully!!!\tu^u^u^u\n");
//
//        TestCardCalculator cardCalculator = new TestCardCalculator(testCardConfig);
//        TestCardCalcModel testCardCalcModel = cardCalculator.calculate(testCard);
//
//        System.out.println("\nu^u^u^u\tTest card calculated successfully!!!\tu^u^u^u\n");
//
//        testCardPrinter = new TestCardPrinter(testCardConfig);
//        List<String> testCardGeneratedLines = testCardPrinter.generateStringLines(testCardCalcModel);
//
//        if (testCardGeneratedLines != null)
//            System.out.println("///");
//        ;
//
//        WriteTestCardToFile writer = new WriteTestCardToFile(testCardConfig);
//        writer.saveTestCardToFile(pathToFile, fileNameForWriter, testCardGeneratedLines);

    }
}
