package object_calculation;

import config.TestCardConfig;
import domain.DoubleTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;

import java.util.OptionalDouble;

@RequiredArgsConstructor
class CalcDoubleTypeParam implements Calculator<ParamCalcModel, DoubleTypeParam> {

    @NonNull
    private TestCardConfig config;

    @Override
    public ParamCalcModel calculate(DoubleTypeParam input) {
        ParamCalcModel calcModel = new ParamCalcModel(input);

        calcModel = calcScore(calcPercent(calcDifference(calcModel)));
        return calcModel;
    }

    private ParamCalcModel calcDifference(ParamCalcModel input) {
        DoubleTypeParam doubleTypeParam = (DoubleTypeParam) input.getParam();
        Double declared = doubleTypeParam.getDeclaredValue();
        Double measured = doubleTypeParam.getMeasuredValue();
        OptionalDouble difference = OptionalDouble.of(declared - measured);

        if (difference.isPresent())
            input.setDifference(difference.getAsDouble());

        return input;
    }

    private ParamCalcModel calcPercent(ParamCalcModel input) {
        DoubleTypeParam doubleTypeParam = (DoubleTypeParam) input.getParam();
        Double declared = doubleTypeParam.getDeclaredValue();
        Double measured = doubleTypeParam.getMeasuredValue();
        OptionalDouble percent = OptionalDouble.of((measured * 100) / declared);

        if (percent.isPresent())
            input.setPercent(percent.getAsDouble());

        return input;
    }

    private ParamCalcModel calcScore(ParamCalcModel input) {
        DoubleTypeParam doubleTypeParam = (DoubleTypeParam) input.getParam();
        Integer availablePoints = doubleTypeParam.getPunctation();
        Double percent = Math.abs(input.getPercent());

        if (percent > 100)
            percent = Double.parseDouble("100");
        else if (percent < 0)
            percent = Double.parseDouble("0");

        OptionalDouble score = OptionalDouble.of((percent/100) * availablePoints);

        if (score.isPresent())
            input.setScore(score.getAsDouble());

        return input;
    }

}
