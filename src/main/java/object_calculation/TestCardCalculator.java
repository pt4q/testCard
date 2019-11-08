package object_calculation;

import config.TestCardConfig;
import domain.RangeOfResearch;
import domain.TestCard;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.RangeOfResearchCalcModel;
import object_calculation.models.TestCardCalcModel;

import java.util.List;

@RequiredArgsConstructor
public class TestCardCalculator implements Calculator<TestCardCalcModel, TestCard> {

    @NonNull
    private TestCardConfig config;

    @Override
    public TestCardCalcModel calculate(TestCard input) {
        TestCardCalcModel calcModel = new TestCardCalcModel(input);
        List<RangeOfResearchCalcModel> rangeOfResearches = calcinput.getRangeOfResearchList();

        return null;
    }

    private List<RangeOfResearchCalcModel> calcAllRangeOfResearch(List<RangeOfResearch> input){
        return new RangeOfResearchListCalculator(config).calculate(input);
    }
}
