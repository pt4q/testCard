package object_creation.range_of_reserch;

import domain.Param;
import domain.RangeOfResearch;
import domain.TestCard;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_creation.creation_utils.Creator;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import object_creation.creation_utils.StringValueConverter;
import object_creation.param.ParamListCreator;
import object_creation.test_card.config.TestCardColumnsNumbers;
import object_creation.test_card.config.TestCardConfig;

import java.util.List;

@RequiredArgsConstructor
class RangeOfResearchCreator implements Creator<RangeOfResearch, List<List<String>>> {

    @NonNull
    private TestCardConfig config;

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
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();
        RangeOfResearch rangeOfResearch = new RangeOfResearch().builder()
                .nameInPolish(input.get(columnsNumbers.getNameInPolishColumnNumber()))
                .punctation(null)
                .params(null)
                .overallScore(null)
                .build();

        if (input.size() > 2)                                                       // zmienic na wyjatek IndexBoundException
            rangeOfResearch.setPunctation(converter.castToInteger(input.get(columnsNumbers.getPunctationColumnNumber())));

        return rangeOfResearch;
    }

    private List<List<String>> removeRangeOfResearchMainParameters(List<List<String>> input) {
        input.remove(0);
        return input;
    }

    private List<Param> getParams(List<List<String>> paramStrings) throws RecognizeParamTypeException {
        return new ParamListCreator(config).create(paramStrings);
    }
}
