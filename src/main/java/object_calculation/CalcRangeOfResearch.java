package object_calculation;

import config.TestCardConfig;
import domain.RangeOfResearch;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.RangeOfResearchCalcModel;

@RequiredArgsConstructor
class CalcRangeOfResearch implements Calculator<RangeOfResearchCalcModel, RangeOfResearch> {

    @NonNull
    private TestCardConfig config;

    @Override
    public RangeOfResearchCalcModel calculate(RangeOfResearch input) {
        return null;
    }

    private RangeOfResearchCalcModel calcDifference(RangeOfResearchCalcModel input){
        return null;
    }

    private RangeOfResearchCalcModel calcPercent(RangeOfResearchCalcModel input){
        return null;
    }

    private RangeOfResearchCalcModel calcScore(RangeOfResearchCalcModel input){
        return null;
    }
}
