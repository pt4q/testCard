package ui;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FileNameProcessorTest {


    @Test
    @Parameters(method = "testListsWithFileNames")
    public void process(List<String> actual, List<String> expected) {
        FileNameProcessor fileNameProcessor = new FileNameProcessor();
        actual = fileNameProcessor.process(actual);

        assertEquals(actual, expected);
    }

    private Object[] testListsWithFileNames() {
        return new Object[]{
                new Object[]{new ArrayList<>(Arrays.asList("DED7850 Karta badań - Młotowiertarka_ref.csv", "DED7850", "Karta", "badań", "-", "Młotowiertarka.csv")),
                        new ArrayList<>(Arrays.asList("DED7850 Karta badań - Młotowiertarka_ref.csv", "DED7850 Karta badań - Młotowiertarka.csv"))}
        };
    }
}