package object_creation.param;

import config.*;
import csv.CsvConfig;
import csv.CsvFileSeparatorEnum;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class DoubleTypeParamBuilderTest {

    private DoubleTypeParamBuilder doubleTypeParamBuilder;

    @Before
    public void setUp() throws Exception {
        TestCardConfig testCardConfig;
        CsvConfig csvConfig = new CsvConfig(CsvFileSeparatorEnum.SEMICOLON, CsvFileSeparatorEnum.TAB);
        TestCardColumnsNumbers testCardColumnsNumbers = new TestCardColumnsNumbers(0, 1, 2, 2, 3, 3, 4);
        TestCardAndParamMarks testCardAndParamMarks = new TestCardAndParamMarks("#", "h", "b", "n", "f", "i");
        BinaryTypePositiveDefinition positiveDefinition = new BinaryTypePositiveDefinition(Arrays.asList("ok", "tak", "yes"), "TAK", "NIE");

        CalcConfig calcConfig = new CalcConfig(20.0);
        PrintConfig printConfig = new PrintConfig();

        testCardConfig = new TestCardConfig(csvConfig, testCardColumnsNumbers, testCardAndParamMarks, positiveDefinition, calcConfig, printConfig);

        doubleTypeParamBuilder = new DoubleTypeParamBuilder(testCardConfig);
    }

    @Test
    @Parameters(method = "inputAndOutputForModule")
    public void tryToAddSubtypeAndValue(String input, Double expectedOutput) {
        Double calc = doubleTypeParamBuilder.calcAverageInComplexString(input);

        assertThat(calc, is(equalTo(expectedOutput)));
    }

    private Object[] inputAndOutputForModule() {
        return new Object[]{
                new Object[]{"3,5 / 3,2", 3.35},
                new Object[]{"2,36 / 2,5", 2.4299999999999997},
                new Object[]{"6 - 44, 49 , 48,5", 47.166666666666664},
                new Object[]{"8 - 42, 42, 42", 42.0},
                new Object[]{"10 - 20, 21, 21,5", 20.833333333333332},
                new Object[]{"6 - 53, 51, 51", 51.666666666666664},
                new Object[]{"8 - 52, 53, 53", 52.666666666666664},
                new Object[]{"10 - 50,5, 50, 52", 50.833333333333336}
        };
    }

    @Test
    @Parameters(method = "inputAndOutputForStringPreparation")
    public void prepareFractionAndDeleteSpaces(String input, String expectedOutput) {
        String output1 = doubleTypeParamBuilder.changeCommaToPointInFraction(input);
        String output2 = doubleTypeParamBuilder.deleteNonDoubleCharSequence(output1);
        String output3 = doubleTypeParamBuilder.changePointBetweenNumbers(output2);
        String output4 = doubleTypeParamBuilder.deleteSpaces(output3);

        assertThat(output4, is(equalTo(expectedOutput)));
    }

    private Object[] inputAndOutputForStringPreparation() {
        return new Object[]{
                new Object[]{"3,5 / 3,2", "3.5/3.2"},
                new Object[]{"2,36 / 2,5", "2.36/2.5"},
                new Object[]{"6 - 44, 49 , 48,5", "44,49,48.5"},
                new Object[]{"8 - 42, 42, 42", "42,42,42"},
                new Object[]{"10 - 20, 21, 21,5", "20,21,21.5"},
                new Object[]{"6 - 53, 51, 51", "53,51,51"},
                new Object[]{"8 - 52, 53, 53", "52,53,53"},
                new Object[]{"10 - 50,5, 50, 52", "50.5,50,52"}
        };
    }
}