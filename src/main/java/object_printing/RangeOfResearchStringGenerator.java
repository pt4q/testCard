package object_printing;

import config.TestCardColumnsNumbers;
import config.TestCardConfig;
import domain.Param;
import domain.RangeOfResearch;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class RangeOfResearchStringGenerator implements Generator<List<List<String>>, RangeOfResearch> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<List<String>> generate(RangeOfResearch input) {
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();
        List<List<String>> result = null;

        for()

        return result;
    }

    private List<List<String>> generateListOfParameters(List<Param> params){
        return null;
    }
}
