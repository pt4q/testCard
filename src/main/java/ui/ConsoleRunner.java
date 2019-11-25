package ui;

import config.*;
import csv.CsvConfig;
import csv.CsvFileSeparatorEnum;
import domain.TestCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import object_calculation.TestCardCalculatorFacade;
import object_calculation.models.TestCardCalcModel;
import object_creation.TestCardFileReaderFacade;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import object_printing.TestCardFileWriterFacade;
import object_printing.printing.TestCardPrinter;

import java.util.Arrays;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
class ConsoleRunner {

    private CsvConfig csvConfig;

    private TestCardColumnsNumbers testCardColumnsNumbers;
    private TestCardAndParamMarks testCardAndParamMarks;
    private BinaryTypePositiveDefinition positiveDefinition;
    private CalcConfig calcConfig;

    private TestCardConfig config;

    public void compute(String pathToFile, List<String> fileNames) throws RecognizeParamTypeException {
        configTestCard();

        fileNames = new FileNameProcessor().process(fileNames);
        TestCard testCard;
        TestCardCalcModel calcModel;
        List<String> lines;

        for (String fileName : fileNames) {
            testCard = readTestCard(pathToFile, fileName);
            calcModel = computeTestCard(testCard);
            lines = convertTestCardToStringLines(calcModel);

            writeTestCardToFile(pathToFile, fileName, lines);
        }
    }

    private void configTestCard() {
        CsvConfig csvConfig = new CsvConfig(CsvFileSeparatorEnum.SEMICOLON, CsvFileSeparatorEnum.TAB, "COMPUTED_");
        TestCardColumnsNumbers testCardColumnsNumbers = new TestCardColumnsNumbers(0, 1, 2, 2, 3, 3, 4);
        TestCardAndParamMarks testCardAndParamMarks = new TestCardAndParamMarks("#", "h", "b", "n", "f", "i", "p","KARTA");
        BinaryTypePositiveDefinition positiveDefinition = new BinaryTypePositiveDefinition(Arrays.asList("ok", "tak", "yes"), "TAK", "NIE");
        config = new TestCardConfig(csvConfig, testCardColumnsNumbers, testCardAndParamMarks, positiveDefinition, new CalcConfig(20.0), new PrintConfig());
        System.out.println();
    }

    private TestCard readTestCard(String pathToFile, String fileName) throws RecognizeParamTypeException {
        return new TestCardFileReaderFacade(config).createTestCardFromFile(pathToFile, fileName);
    }

    private TestCardCalcModel computeTestCard(TestCard testCard) {
        return new TestCardCalculatorFacade(config).calculate(testCard);
    }

    private List<String> convertTestCardToStringLines(TestCardCalcModel cardCalcModel) {
        return new TestCardPrinter(config).generate(cardCalcModel);
    }

    private void writeTestCardToFile(String pathToFile, String fileName, List<String> testCardStrings) {
        new TestCardFileWriterFacade(config).saveTestCardToFile(pathToFile, fileName, testCardStrings);
    }
}
