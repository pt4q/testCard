package object_printing;

import config.TestCardColumnsNumbers;
import config.TestCardConfig;

import java.util.*;
import java.util.stream.Collectors;

class TestCardColumnSequencer {

    public Integer calcMaxNumberOfColumn(TestCardConfig config) {
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();

        Integer[] integers = {
                columnsNumbers.getNameInPolishColumnNumber(),
                columnsNumbers.getNameInEnglishColumnNumber(),
                columnsNumbers.getParamTypeColumnNumber(),
                columnsNumbers.getPunctationColumnNumber(),
                columnsNumbers.getMeasuredValuesColumnNumber(),
                columnsNumbers.getDeclaredValuesColumnNumber(),
                columnsNumbers.getRangeOfResearchColumnNumber()
        };

        Set<Integer> integerSet = Arrays.stream(integers)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        return integerSet.size();
    }
}
