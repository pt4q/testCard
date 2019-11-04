package object_creation.range_of_reserch;

import domain.Param;
import domain.RangeOfResearch;
import lombok.Builder;
import lombok.NoArgsConstructor;
import object_creation.creation_utils.Creator;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import object_creation.creation_utils.StringValueConverter;
import object_creation.param.ParamListCreator;

import java.util.List;

@NoArgsConstructor
@Builder
class RangeOfResearchCreator implements Creator<RangeOfResearch, List<List<String>>> {

    @Override
    public RangeOfResearch create(List<List<String>> input) throws RecognizeParamTypeException {
        RangeOfResearch rangeOfResearch = getRangeOfResearchMainParameters(input.get(0));
        input = removeRangeOfResearchMainParameters(input);

        List<Param> params = getParams(input);
        rangeOfResearch.setParams(params);

        System.out.println("==========\t" + rangeOfResearch.getNameInPolish() + "\t==========\t>>> " + params.size() + " <<<");
        return rangeOfResearch;
    }

    private RangeOfResearch getRangeOfResearchMainParameters(List<String> input) throws IllegalArgumentException {
        StringValueConverter converter = new StringValueConverter();
        RangeOfResearch rangeOfResearch = new RangeOfResearch().builder()
                .nameInPolish(input.get(1))
                .punctation(null)
                .params(null)
                .overallScore(null)
                .build();

        if (input.size() > 2)                                                       // zmienic na wyjatek IndexBoundException
            rangeOfResearch.setPunctation(converter.castToInteger(input.get(2)));

        return rangeOfResearch;
    }

    private List<List<String>> removeRangeOfResearchMainParameters(List<List<String>> input) {
        input.remove(0);
        return input;
    }

    private List<Param> getParams(List<List<String>> paramStrings) throws RecognizeParamTypeException {
        return new ParamListCreator().create(paramStrings);
    }
}
