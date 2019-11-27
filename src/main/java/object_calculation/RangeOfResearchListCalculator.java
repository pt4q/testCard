package object_calculation;

import config.TestCardConfig;
import domain.RangeOfResearch;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.RangeOfResearchCalcModel;
import utils.Calculator;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
class RangeOfResearchListCalculator implements Calculator<List<RangeOfResearchCalcModel>, List<RangeOfResearch>> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<RangeOfResearchCalcModel> calculate(List<RangeOfResearch> input) {
       List<RangeOfResearchCalcModel> rangeOfResearchCalcModelList = new ArrayList<>();

        for (RangeOfResearch rangeOfResearch : input){
            rangeOfResearchCalcModelList.add(calcRangeOfResearch(rangeOfResearch));
        }

        return rangeOfResearchCalcModelList;
    }

    private RangeOfResearchCalcModel calcRangeOfResearch (RangeOfResearch input){
        return new CalcRangeOfResearch(config).calculate(input);
    }

}
