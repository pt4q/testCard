package object_creation.range_of_reserch;

import domain.Param;
import domain.RangeOfResearch;
import object_creation.creation_utils.Creator;
import object_creation.creation_utils.ValueConverter;
import object_creation.param.ParamCreator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class RangeOfResearchCreator implements Creator<RangeOfResearch, Map<Integer, List<String>>> {

    @Override
    public RangeOfResearch create(Map<Integer, List<String>> input) {
        List<Param> params;
        ValueConverter converter = new ValueConverter();
        
        RangeOfResearch rangeOfResearch = new RangeOfResearch().builder()
                .nameInPolish(input.get(0).get(1))
                .nameInEnglish(input.get(0).get(2))
                .punctation(converter.castToInteger(input.get(0).get(3)))
                .params(null)
                .overallScore(null)
                .build();

        input.remove(0);
        params = buildParams(input);
        
        rangeOfResearch.setParams(params);
        
        return rangeOfResearch;
    }

    private List<Param> buildParams(Map<Integer, List<String>> input) {
        return input.entrySet().stream()
                .map(entry -> buildParam(entry.getValue()))
                .collect(Collectors.toList());
    }

    private Param buildParam(List<String> line) {
        ParamCreator paramCreator = new ParamCreator();
        return paramCreator.create(line);
    }
}
