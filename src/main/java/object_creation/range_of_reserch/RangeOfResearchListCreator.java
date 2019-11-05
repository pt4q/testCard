package object_creation.range_of_reserch;

import domain.RangeOfResearch;
import lombok.*;
import object_creation.creation_utils.Creator;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import object_creation.test_card.config.TestCardConfig;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class RangeOfResearchListCreator implements Creator<List<RangeOfResearch>, List<List<String>>> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<RangeOfResearch> create(List<List<String>> input) throws RecognizeParamTypeException {
        String rangeOfResearchMark = config.getParamTypes().getRANGE_OF_RESEARCH_MARK();
        List<RangeOfResearch> rangeOfResearchList = new ArrayList<>();
        List<List<String>> paramsStringList = initEmptyList();

        Integer inputSize = input.size();
        boolean addedRangeOfResearch = false;

        for (int i = 0; i < inputSize; i++) {
            String mark = getMark(input, i);

            if (mark.matches(rangeOfResearchMark)) {
                String nextMark;
                List<String> rangeOfResearchHeader = input.get(i);
                paramsStringList.add(rangeOfResearchHeader);

                do {
                    if (i < inputSize - 1)
                        i++;

                    List<String> nextHeaderOrParam = input.get(i);
                    nextMark = getMark(input, i);

                    if (nextMark.matches(rangeOfResearchMark) || i == inputSize - 1) {

                        RangeOfResearch newRangeOfResearch = createRangeOfResearch(paramsStringList);
                        rangeOfResearchList.add(newRangeOfResearch);
                        addedRangeOfResearch = true;
                        i--;
                    } else
                        paramsStringList.add(nextHeaderOrParam);

                } while (!addedRangeOfResearch);
            }

            paramsStringList = initEmptyList();
            addedRangeOfResearch = false;
        }

        return rangeOfResearchList;
    }

    private String getMark(List<List<String>> list, Integer index) {
        return list.get(index).get(config.getColumnsNumbers().getRangeOfResearchColumnNumber());
    }

    private List<List<String>> initEmptyList() {
        return new ArrayList<>();
    }

    private RangeOfResearch createRangeOfResearch(List<List<String>> input) throws RecognizeParamTypeException {
        return new RangeOfResearchCreator(config).create(input);
    }
}
