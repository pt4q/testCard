package object_printing.printing_to_strings;

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
        String rangeOfResearchSign = config.getParamTypes().getRANGE_OF_RESEARCH_MARK();

        result.add(generateRangeOfResearch(input, rangeOfResearchSign));
        generateStringListOfParameters(input.getParamCalcModelList())
                .forEach(result::add);

        return result;
    }

    private Map<Integer, String> generateRangeOfResearch(RangeOfResearchCalcModel input, String rangeOfResearchSign) {
        RangeOfResearch ror = input.getRangeOfResearch();
        return new HashMap<Integer, String>() {{
            put(0, rangeOfResearchSign);
            put(1, ror.getNameInPolish());
            put(2, ror.getPunctation().toString());
            put(3, "");
            put(4, "");
            put(5, "");
            put(6, input.getDifference().toString());
            put(7, input.getPercent().toString());
            put(8, input.getNumberOfNotAvailableParams().toString());
            put(9, input.getSumOfAvailablePoints().toString());
            put(10, input.getSumOfGainedPoints().toString());
            put(11, input.getScore().toString());
        }};
    }

    private List<Map<Integer, String>> generateStringListOfParameters(List<ParamCalcModel> params) {
        return new ParamStringGenerator(config).generate(params);
    }
}
