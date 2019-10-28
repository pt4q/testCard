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
            String mark = getMark(input, i);

            if (mark.matches(rangeOfResearchMark)) {
                String nextMark;
                List<String> rangeOfResearchHeader = input.get(i);
                paramLine.add(rangeOfResearchHeader);

                do {
                    if (i < inputSize - 1)
                        i++;

                    List<String> lineList = input.get(i);
                    nextMark = getMark(input, i);

                    if (nextMark.matches(rangeOfResearchMark)) {
                        RangeOfResearch newRangeOfResearch = createRangeOfResearch(paramLine);
                        rangeOfResearchList.add(newRangeOfResearch);
                        addedRangeOfResearch = true;
                        i--;
                    } else
                        paramLine.add(lineList);

                } while (!addedRangeOfResearch);
            }

            paramLine = initEmptyParamLine();
            addedRangeOfResearch = false;
        }

        return rangeOfResearchList;
    }

    private String getMark(List<List<String>> list, Integer index) {
        return list.get(index).get(0);
    }

    private List<List<String>> initEmptyParamLine() {
        return new ArrayList<>();
    }

    private RangeOfResearch createRangeOfResearch(List<List<String>> input) {
        return new RangeOfResearchCreator().create(input);
    }
}
