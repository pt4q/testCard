package object_calculation;

import config.TestCardConfig;
import domain.RangeOfResearch;
import domain.TestCard;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.RangeOfResearchCalcModel;
import object_calculation.models.TestCardCalcModel;

import java.util.List;
import java.util.OptionalDouble;

@RequiredArgsConstructor
public class TestCardCalculatorFacade implements Calculator<TestCardCalcModel, TestCard> {

    @NonNull
    private TestCardConfig config;

    private Integer totalAvailablePoints = 0;
    private Integer totalUnAvailablePoints = 0;
    private Integer numberOfNotAvailableParams = 0;
    private Double gainedPoints = 0.0;

    @Override
    public TestCardCalcModel calculate(TestCard input) {
        TestCardCalcModel calcModel = new TestCardCalcModel(input);
        calcModel = calcScore(
                calcPercent(
                        calcDifference(
                                calcAvailableAndGainedPoints(calcModel))));

        calcModel.setSumOfUnavailablePoints(totalUnAvailablePoints);
        calcModel.setNumberOfNotAvailableParams(numberOfNotAvailableParams);

        printSummary(calcModel);
        return calcModel;
    }

    private void printSummary(TestCardCalcModel calcModel) {
        System.out.println("++++++++++++\t" + "KARTA TESTOWA" + "\t" + calcModel.getSumOfAvailablePoints() + "\t" + calcModel.getSumOfGainedPoints() + "\t" + calcModel.getPercent() + "\t" + calcModel.getScore() + "\t++++++++++++");
        System.out.println("unavailable points: " + totalUnAvailablePoints + "\tnumber of not available params: " + numberOfNotAvailableParams);
    }

    private List<RangeOfResearchCalcModel> calcAllRangeOfResearch(List<RangeOfResearch> input) {
        return new RangeOfResearchListCalculator(config).calculate(input);
    }

    private TestCardCalcModel calcAvailableAndGainedPoints(TestCardCalcModel input) {
        TestCard testCard = input.getTestCard();
        List<RangeOfResearchCalcModel> rangeOfResearchesCalculated = calcAllRangeOfResearch(testCard.getRangeOfResearchList());

        for (RangeOfResearchCalcModel rangeOfResearch : rangeOfResearchesCalculated) {
            Integer sumOfAvailablePoints = rangeOfResearch.getSumOfAvailablePoints();
            Double sumOfGainedPoints = rangeOfResearch.getSumOfGainedPoints();
            Integer sumOfUnavailablePoints = rangeOfResearch.getSumOfUnavailablePoints();
            Integer numberOfNotAvailableParams = rangeOfResearch.getNumberOfNotAvailableParams();

            this.totalAvailablePoints = totalAvailablePoints + sumOfAvailablePoints;
            this.gainedPoints = gainedPoints + sumOfGainedPoints;

            addToNotAvailablePoints(sumOfUnavailablePoints);
            addToNotAvailableParams(numberOfNotAvailableParams);
        }

        input.setSumOfAvailablePoints(totalAvailablePoints);
        input.setSumOfGainedPoints(gainedPoints);

        input.setRangeOfResearchCalcModelList(rangeOfResearchesCalculated);
        return input;
    }

    private void addToNotAvailablePoints(Integer totalUnavailablePoints) {
        if (totalUnavailablePoints != null)
            this.totalUnAvailablePoints = this.totalUnAvailablePoints + totalUnavailablePoints;
    }

    private void addToNotAvailableParams(Integer totalNotAvailableParams) {
        if (totalNotAvailableParams != null)
            this.numberOfNotAvailableParams = this.numberOfNotAvailableParams + totalNotAvailableParams;
    }

    private TestCardCalcModel calcDifference(TestCardCalcModel input) {
        Integer sumOfAvailablePoints = input.getSumOfAvailablePoints();
        Double sumOfGainedPoints = input.getSumOfGainedPoints();

        double difference = OptionalDouble.of(sumOfAvailablePoints - sumOfGainedPoints)
                .orElse(0.0);

        input.setDifference(difference);
        return input;
    }

    private TestCardCalcModel calcPercent(TestCardCalcModel input) {
        Integer sumOfAvailablePoints = input.getSumOfAvailablePoints();
        Double sumOfGainedPoints = input.getSumOfGainedPoints();
        double percent = OptionalDouble.of((sumOfGainedPoints * 100) / sumOfAvailablePoints)
                .orElse(Double.parseDouble("0"));

        input.setPercent(percent);
        return input;
    }

    private TestCardCalcModel calcScore(TestCardCalcModel input) {
        Integer availablePoints = input.getTestCard().getPunctation();
        double percent = Math.abs(input.getPercent());

        if (percent > 100)
            percent = Double.parseDouble("100");
        else if (percent < 0)
            percent = Double.parseDouble("0");

        double score = OptionalDouble.of((percent / 100) * availablePoints)
                .orElse(Double.parseDouble("0"));

        input.setScore(score);
        return input;
    }
}
