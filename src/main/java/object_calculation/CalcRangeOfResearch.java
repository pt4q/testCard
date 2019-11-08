package object_calculation;

import config.TestCardConfig;
import domain.RangeOfResearch;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;
import object_calculation.models.RangeOfResearchCalcModel;

import java.util.List;
import java.util.OptionalDouble;

@RequiredArgsConstructor
class CalcRangeOfResearch implements Calculator<RangeOfResearchCalcModel, RangeOfResearch> {

    @NonNull
    private TestCardConfig config;

    private Integer totalAvailablePoints = 0;
    private Double gainedPoints = 0.0;

    @Override
    public RangeOfResearchCalcModel calculate(RangeOfResearch input) {
        RangeOfResearchCalcModel calcModel = new RangeOfResearchCalcModel(input);

        calcModel = calcScore(calcPercent(calcAvailablePointsFromParamsAndGainedPoints(calcModel)));
        return calcModel;
    }

    private RangeOfResearchCalcModel calcAvailablePointsFromParamsAndGainedPoints(RangeOfResearchCalcModel input) {
        RangeOfResearch rangeOfResearch = input.getRangeOfResearch();

        ParamListCalculator paramListCalculator = new ParamListCalculator(config);
        List<ParamCalcModel> paramsCalculated = paramListCalculator.calculate(rangeOfResearch.getParams());

        for (ParamCalcModel param : paramsCalculated) {
            this.totalAvailablePoints = this.totalAvailablePoints + param.getAvailablePoints();
            this.gainedPoints = this.gainedPoints + param.getScore();
        }

        input.setSumOfAvailablePoints(totalAvailablePoints);
        input.setSumOfGainedPoints(gainedPoints);

        return input;
    }

    private RangeOfResearchCalcModel calcPercent(RangeOfResearchCalcModel input) {
        Integer sumOfAvailablePoints = input.getSumOfAvailablePoints();
        Double sumOfGainedPointsFromParams = input.getSumOfGainedPoints();

        OptionalDouble percent = OptionalDouble.of((sumOfGainedPointsFromParams * 100) / sumOfAvailablePoints);

        if (percent.isPresent())
            input.setPercent(percent.getAsDouble());

        return input;
    }

    private RangeOfResearchCalcModel calcScore(RangeOfResearchCalcModel input) {
        Integer availablePoints = input.getRangeOfResearch().getPunctation();
        Double percent = Math.abs(input.getPercent());

        if (percent > 100)
            percent = Double.parseDouble("100");
        else if (percent < 0)
            percent = Double.parseDouble("0");

        OptionalDouble score = OptionalDouble.of((percent / 100) * availablePoints);

        if (score.isPresent())
            input.setScore(score.getAsDouble());

        return input;
    }
}
