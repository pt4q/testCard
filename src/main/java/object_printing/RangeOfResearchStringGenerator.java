package object_printing;

import config.TestCardColumnsNumbers;
import config.TestCardConfig;
import domain.Param;
import domain.RangeOfResearch;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.RangeOfResearchCalcModel;

import java.util.List;

@RequiredArgsConstructor
class RangeOfResearchStringGenerator implements Generator<List<List<String>>, RangeOfResearchCalcModel> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<List<String>> generate(RangeOfResearchCalcModel input) {
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();
        List<List<String>> result = null;

//        for()

        return result;
    }

    private List<List<String>> generateListOfParameters(List<Param> params){
        return null;
    }
}
