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

    private Integer totalAvailablePoints = 0;
    private Double gainedPoints = 0.0;

    @Override
    public TestCardCalcModel calculate(TestCard input) {
        TestCardCalcModel calcModel = new TestCardCalcModel(input);


        return null;
    }

    private List<RangeOfResearchCalcModel> calcAllRangeOfResearch(List<RangeOfResearch> input) {
        return new RangeOfResearchListCalculator(config).calculate(input);
    }

    private TestCardCalcModel calcAvailableAndGainedPoints(TestCardCalcModel input) {
        TestCard testCard = input.getTestCard();

        List<RangeOfResearchCalcModel> rangeOfResearchesCalculated = calcAllRangeOfResearch(testCard.getRangeOfResearchList());

        for (RangeOfResearchCalcModel rangeOfResearch : rangeOfResearchesCalculated) {
            this.totalAvailablePoints = totalAvailablePoints + rangeOfResearch.getSumOfAvailablePoints();
            this.gainedPoints = gainedPoints + rangeOfResearch.getSumOfGainedPoints();
        }

        input.setSumOfAvailablePoints(totalAvailablePoints);
        input.setSumOfGainedPoints(gainedPoints);

        return input;
    }

    private TestCardCalcModel calcPercent(TestCardCalcModel input) {
        return null;
    }

    private TestCardCalcModel calcScore(TestCardCalcModel input) {
        return null;
    }
}
