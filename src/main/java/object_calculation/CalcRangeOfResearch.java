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

    @Override
    public RangeOfResearchCalcModel calculate(RangeOfResearch input) {
        RangeOfResearchCalcModel calcModel = new RangeOfResearchCalcModel(input);

        calcModel = calcScore(
                calcPercent(
                        calcDifference(
                                calcAvailablePointsFromParamsAndGainedPoints(calcModel)
                        )));

        printSummary(calcModel);
        return calcModel;
    }

    private void printSummary(RangeOfResearchCalcModel calcModel){
        System.out.println("==========\tname: " + calcModel.getRangeOfResearch().getNameInPolish()
                + "\tsum of available: " + calcModel.getSumOfAvailablePoints()
                + "\tsum of gained: " + calcModel.getSumOfGainedPoints()
                + "\tpercent:" + calcModel.getPercent()
                + "\tscore: " + calcModel.getScore()
                + "\t==========\t>>> " + calcModel.getRangeOfResearch().getParams().size() + " <<<");
    }

    private RangeOfResearchCalcModel calcAvailablePointsFromParamsAndGainedPoints(RangeOfResearchCalcModel input) {
        RangeOfResearch rangeOfResearch = input.getRangeOfResearch();

        Integer totalAvailablePoints = 0;
        Integer totalUnAvailablePoints = 0;
        Integer numberOfNotAvailableParams = 0;
        Double gainedPoints = 0.0;

        ParamListCalculator paramListCalculator = new ParamListCalculator(config);
        List<ParamCalcModel> paramsCalculated = paramListCalculator.calculate(rangeOfResearch.getParams());

        for (ParamCalcModel param : paramsCalculated) {
            Integer paramAvailablePoints = param.getAvailablePoints();
            Double paramScore = param.getScore();

            if (paramAvailablePoints != null) {
                totalAvailablePoints = totalAvailablePoints + paramAvailablePoints;

                if (paramScore != null && paramScore > 0.0)
                    gainedPoints = gainedPoints + paramScore;
                else {
                    totalUnAvailablePoints = totalUnAvailablePoints + paramAvailablePoints;
                    numberOfNotAvailableParams++;
                }
            }
        }

        input.setSumOfAvailablePoints(totalAvailablePoints);
        input.setSumOfGainedPoints(gainedPoints);
        input.setSumOfUnavailablePoints(totalUnAvailablePoints);
        input.setNumberOfNotAvailableParams(numberOfNotAvailableParams);

        return input;
    }

    private RangeOfResearchCalcModel calcDifference(RangeOfResearchCalcModel input) {
        Integer availablePoints = input.getSumOfAvailablePoints();
        Double gainedPoints = input.getSumOfGainedPoints();
        double difference = 0.0;

        if (availablePoints != null && gainedPoints != null)
            difference = availablePoints - gainedPoints;

        input.setDifference(difference);
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
