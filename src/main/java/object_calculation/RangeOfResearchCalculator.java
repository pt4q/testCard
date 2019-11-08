package object_calculation;

import config.TestCardConfig;
import domain.RangeOfResearch;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.RangeOfResearchCalcModel;

import java.util.List;

@RequiredArgsConstructor
class RangeOfResearchCalculator implements Calculator<List<RangeOfResearchCalcModel>, List<RangeOfResearch>> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<RangeOfResearchCalcModel> calculate(List<RangeOfResearch> input) {
        return null;
    }

}
