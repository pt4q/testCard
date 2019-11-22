package ui;

import config.*;
import csv.CsvConfig;
import csv.CsvFileSeparatorEnum;
import domain.TestCard;
import lombok.Builder;
import lombok.NoArgsConstructor;
import object_creation.ReadTestCardFromFile;
import object_printing.printing.TestCardPrinter;

import java.util.Arrays;
import java.util.List;

@Builder
@NoArgsConstructor
class ConsoleRunner {

    @Builder.Default
    CsvConfig csvConfig = new CsvConfig(CsvFileSeparatorEnum.SEMICOLON, CsvFileSeparatorEnum.TAB);
    @Builder.Default
    TestCardColumnsNumbers testCardColumnsNumbers = new TestCardColumnsNumbers(0, 1, 2, 2, 3, 3, 4);
    @Builder.Default
    TestCardAndParamMarks testCardAndParamMarks = new TestCardAndParamMarks("#", "h", "b", "n", "f", "i");
    @Builder.Default
    BinaryTypePositiveDefinition positiveDefinition = new BinaryTypePositiveDefinition(Arrays.asList("ok", "tak", "yes"), "TAK", "NIE");
    @Builder.Default
    CalcConfig calcConfig = new CalcConfig(20.0);
    PrintConfig printConfig = new PrintConfig();
    TestCardConfig testCardConfig = new TestCardConfig(csvConfig, testCardColumnsNumbers, testCardAndParamMarks, positiveDefinition, calcConfig, printConfig);

    ReadTestCardFromFile testCardReader;
    TestCardPrinter testCardPrinter;
    TestCard testCard = null;

    public boolean compute(String fileLocation, List<String> fileNames) {
        fileNames = new FileNameProcessor().process(fileNames);

        return false;
    }


}
