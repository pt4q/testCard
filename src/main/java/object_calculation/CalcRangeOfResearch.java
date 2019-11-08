package object_calculation;

import config.TestCardConfig;
import domain.RangeOfResearch;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;
import object_calculation.models.RangeOfResearchCalcModel;

import java.util.List;

@RequiredArgsConstructor
class CalcRangeOfResearch implements Calculator<RangeOfResearchCalcModel, RangeOfResearch> {

    @NonNull
    private TestCardConfig config;

    private Integer availablePoints = 0;
    private Double points = 0.0;

    @Override
    public RangeOfResearchCalcModel calculate(RangeOfResearch input) {
        return null;
    }

    private RangeOfResearchCalcModel calcDifference(RangeOfResearchCalcModel input) {
        RangeOfResearch rangeOfResearch = input.getRangeOfResearch();
        ParamCalculator paramCalculator = new ParamCalculator(config);
        List<ParamCalcModel> paramsCalculated = paramCalculator.calculate(rangeOfResearch.getParams());

        for (ParamCalcModel param : paramsCalculated) {
            this.availablePoints = this.availablePoints + param.getAvailablePoints();
            this.points = this.points + param.getScore();
        }

        input.setAvailablePoints(availablePoints);

        return input;
    }

    private RangeOfResearchCalcModel calcPercent(RangeOfResearchCalcModel input) {
        return null;
    }

    private RangeOfResearchCalcModel calcScore(RangeOfResearchCalcModel input) {
        return null;
    }
}
