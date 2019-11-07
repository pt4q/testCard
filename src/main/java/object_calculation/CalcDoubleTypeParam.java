package object_calculation;

import domain.DoubleTypeParam;
import lombok.NoArgsConstructor;
import object_calculation.models.ParamCalcModel;

import java.util.OptionalDouble;

@NoArgsConstructor
class CalcDoubleTypeParam implements Calculator<ParamCalcModel, DoubleTypeParam> {

    @Override
    public ParamCalcModel calculate(DoubleTypeParam input) {
        return null;
    }

    private ParamCalcModel calcDifference(ParamCalcModel input){
        DoubleTypeParam doubleTypeParam = (DoubleTypeParam) input.getParam();
        Double declared = doubleTypeParam.getDeclaredValue();
        Double measured = doubleTypeParam.getMeasuredValue();
        OptionalDouble difference = OptionalDouble.of(declared - measured);

        if (difference.isPresent())
            input.setDifference(difference.getAsDouble());

        return input;
    }

    private ParamCalcModel calcPercent(ParamCalcModel input){
        DoubleTypeParam doubleTypeParam = (DoubleTypeParam) input.getParam();
        return null;
    }

    private ParamCalcModel calcScore(ParamCalcModel input){
        DoubleTypeParam doubleTypeParam = (DoubleTypeParam) input.getParam();
        return null;
    }

}
