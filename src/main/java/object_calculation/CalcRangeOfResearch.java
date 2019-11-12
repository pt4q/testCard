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
    private Integer totalUnAvailablePoints = 0;
    private Integer numberOfNotAvailableParams = 0;
    private Double gainedPoints = 0.0;

    @Override
    public RangeOfResearchCalcModel calculate(RangeOfResearch input) {
        RangeOfResearchCalcModel calcModel = new RangeOfResearchCalcModel(input);

        calcModel = calcScore(calcPercent(calcAvailablePointsFromParamsAndGainedPoints(calcModel)));
        System.out.println("==========\tname: " + calcModel.getRangeOfResearch().getNameInPolish() + "\tsum of available: " + calcModel.getSumOfAvailablePoints() + "\tsum of gained: " + calcModel.getSumOfGainedPoints() + "\tpercent:" + calcModel.getPercent() + "\tscore: " + calcModel.getScore() + "\t==========\t>>> " + calcModel.getRangeOfResearch().getParams().size() + " <<<");
        return calcModel;
    }

    private RangeOfResearchCalcModel calcAvailablePointsFromParamsAndGainedPoints(RangeOfResearchCalcModel input) {
        RangeOfResearch rangeOfResearch = input.getRangeOfResearch();

        ParamListCalculator paramListCalculator = new ParamListCalculator(config);
        List<ParamCalcModel> paramsCalculated = paramListCalculator.calculate(rangeOfResearch.getParams());

        for (ParamCalcModel param : paramsCalculated) {
            Integer paramAvailablePoints = param.getAvailablePoints();
            Double paramScore = param.getScore();

            if (paramAvailablePoints != null) {
                this.totalAvailablePoints = this.totalAvailablePoints + paramAvailablePoints;

                if (paramScore != null)
                    this.gainedPoints = this.gainedPoints + paramScore;
                else {
                    this.totalUnAvailablePoints = this.totalUnAvailablePoints + paramAvailablePoints;
                    this.numberOfNotAvailableParams = numberOfNotAvailableParams++;
                }
            }
        }

        input.setSumOfAvailablePoints(totalAvailablePoints);
        input.setSumOfGainedPoints(gainedPoints);

        return input;
    }

    private RangeOfResearchCalcModel calcPercent(RangeOfResearchCalcModel input) {
        Integer sumOfAvailablePoints = input.getSumOfAvailablePoints();
        Double sumOfGainedPointsFromParams = input.getSumOfGainedPoints();

        double percent = OptionalDouble.of((sumOfGainedPointsFromParams * 100) / sumOfAvailablePoints)
                .orElse(0.0);
        input.setPercent(percent);

        return input;
    }

    private RangeOfResearchCalcModel calcScore(RangeOfResearchCalcModel input) {
        Integer availablePoints = input.getRangeOfResearch().getPunctation();
        double percent = Math.abs(input.getPercent());

        if (percent > 100)
            percent = Double.parseDouble("100");
        else if (percent < 0)
            percent = Double.parseDouble("0");

        double score = OptionalDouble.of((percent / 100) * availablePoints)
                .orElse(0.0);
        input.setScore(score);

        return input;
    }
}
