package object_calculation;

import config.TestCardConfig;
import domain.DoubleTypeParam;
import domain.IntegerTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;

import java.util.OptionalDouble;
import java.util.OptionalInt;

@RequiredArgsConstructor
class CalcIntegerTypeParam implements Calculator<ParamCalcModel, IntegerTypeParam> {

    @NonNull
    private TestCardConfig config;

    @Override
    public ParamCalcModel calculate(IntegerTypeParam input) {
        ParamCalcModel calcModel = new ParamCalcModel(input);

        calcModel = calcScore(calcPercent(calcDifference(calcModel)));
        return calcModel;
    }

    private ParamCalcModel calcDifference(ParamCalcModel input) {
        IntegerTypeParam integerTypeParam = (IntegerTypeParam) input.getParam();
        Integer declared = integerTypeParam.getDeclaredValue();
        Integer measured = integerTypeParam.getMeasuredValue();
        OptionalDouble difference = OptionalDouble.of(declared - measured);

        if (difference.isPresent())
            input.setDifference(difference.getAsDouble());

        return input;
    }

    private ParamCalcModel calcPercent(ParamCalcModel input) {
        return null;
    }

    private ParamCalcModel calcScore(ParamCalcModel input) {
        return null;
    }
}
