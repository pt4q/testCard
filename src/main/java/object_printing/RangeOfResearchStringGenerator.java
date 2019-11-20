package object_printing;

import config.TestCardConfig;
import domain.RangeOfResearch;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;
import object_calculation.models.RangeOfResearchCalcModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
class RangeOfResearchStringGenerator implements Generator<List<Map<Integer, String>>, RangeOfResearchCalcModel> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<Map<Integer, String>> generate(RangeOfResearchCalcModel input) {
        List<Map<Integer, String>> result = new ArrayList<>();

        result.add(generateRangeOfResearch(input));
        generateStringListOfParameters(input.getParamCalcModelList())
                .forEach(result::add);

        return result;
    }

    private Map<Integer, String> generateRangeOfResearch(RangeOfResearchCalcModel input) {
        RangeOfResearch ror = input.getRangeOfResearch();
        return new HashMap<Integer, String>() {{
            put(0, ror.getNameInPolish());
            put(1, ror.getPunctation().toString());
            put(2, "");
            put(3, "");
            put(4, input.getNumberOfNotAvailableParams().toString());
            put(5, input.getSumOfAvailablePoints().toString());
            put(6, input.getSumOfGainedPoints().toString());
            put(7, input.getDifference().toString());
            put(8, input.getPercent().toString());
            put(9, input.getScore().toString());
        }};
    }

    private List<Map<Integer, String>> generateStringListOfParameters(List<ParamCalcModel> params) {
        return new ParamStringGenerator(config).generate(params);
    }
}
