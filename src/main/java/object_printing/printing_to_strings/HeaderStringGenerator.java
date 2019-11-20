package object_printing.printing_to_strings;

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

        return new LinkedHashMap<Integer, String>() {{
            put(0, header.getNameInPolish());
            put(1, header.getPunctation().toString());
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
