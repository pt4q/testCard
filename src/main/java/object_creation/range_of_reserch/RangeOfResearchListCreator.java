package object_creation.range_of_reserch;

import domain.RangeOfResearch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import object_creation.creation_utils.Creator;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RangeOfResearchListCreator implements Creator<List<RangeOfResearch>, List<List<String>>> {

    private String rangeOfResearchMark = "#";

    @Override
    public List<RangeOfResearch> create(List<List<String>> input) {
        List<RangeOfResearch> rangeOfResearchList = new ArrayList<>();
        List<List<String>> paramLine = initEmptyParamLine();
        Integer inputSize = input.size();
        boolean addedRangeOfResearch = false;

        for (int i = 0; i < inputSize; i++) {
            String mark = input.get(i).get(0);

            if (mark.matches(rangeOfResearchMark)) {
                String nextMark;
                paramLine.add(input.get(i));

                do {
                    if (i < inputSize - 1)
                        i++;

                    nextMark = input.get(i).get(0);

                    if (nextMark.matches(rangeOfResearchMark)) {
                        rangeOfResearchList.add(createRangeOfResearch(paramLine));
                        addedRangeOfResearch = true;
                    }

                    paramLine.add(input.get(i));

                } while (!addedRangeOfResearch);
            }

            paramLine = initEmptyParamLine();
            addedRangeOfResearch = false;
        }

        return rangeOfResearchList;
    }

    private List<List<String>> initEmptyParamLine() {
        return new ArrayList<>();
    }

    private RangeOfResearch createRangeOfResearch(List<List<String>> input) {
        return new RangeOfResearchCreator().create(input);
    }
}
