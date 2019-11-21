package object_printing.printing;

import config.TestCardConfig;
import domain.Param;
import domain.RangeOfResearch;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.TestCardCalcModel;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
class HeaderStringGenerator implements Generator<List<Map<Integer, String>>, TestCardCalcModel> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<Map<Integer, String>> generate(TestCardCalcModel input) {
        List<Map<Integer, String>> result = new ArrayList<>();
        result.add(generateMainHeaderWithScore(input));

        result.addAll(generateHeaders(input.getTestCard().getHeader().getParams()));

        return result;
    }

    private Map<Integer, String> generateMainHeaderWithScore(TestCardCalcModel input){
        RangeOfResearch header = input.getTestCard().getHeader();
        String rangeOfResearchMark = config.getParamTypes().getRANGE_OF_RESEARCH_MARK();

        return new LinkedHashMap<Integer, String>() {{
            put(0, rangeOfResearchMark);
            put(1, header.getNameInPolish());
            put(2, header.getPunctation().toString());
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

    private List<Map<Integer, String>> generateHeaders(List<Param> input){
        HeaderTypeParamStringGenerator htpsg = new HeaderTypeParamStringGenerator(config);
        List<Map<Integer, String>> result = new ArrayList<>();

//        for (Param param : input){
//            Map<Integer, String> paramMap = htpsg.generate(param);
//            result.add(paramMap);
//        }

//        return result;
        return  new ArrayList<>(input.stream()
                .map(htpsg::generate)
                .collect(Collectors.toList()));
    }
}
