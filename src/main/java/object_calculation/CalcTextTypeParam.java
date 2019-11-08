package object_calculation;

import config.TestCardConfig;
import domain.TextTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;

import java.util.OptionalDouble;

@RequiredArgsConstructor
class CalcTextTypeParam implements Calculator<ParamCalcModel, TextTypeParam>{

    @NonNull
    private TestCardConfig config;

    @Override
    public ParamCalcModel calculate(TextTypeParam input) {
        ParamCalcModel calcModel = new ParamCalcModel(input);

        calcModel = calcScore(calcPercent(calcDifference(calcModel)));
        return calcModel;
    }

    private ParamCalcModel calcDifference(ParamCalcModel input) {
        TextTypeParam textTypeParam = (TextTypeParam) input.getParam();
        String declared = textTypeParam.getDeclaredValue();
        String measured = textTypeParam.getMeasuredValue();
        String resultString = "0";

        if(declared.equals(measured))
            resultString = "1";

        input.setDifference(Double.parseDouble(resultString));
        return input;
    }

    private ParamCalcModel calcPercent(ParamCalcModel input) {
        Double difference = input.getDifference();
        OptionalDouble percent = OptionalDouble.of(difference * 100);

        if(percent.isPresent())
            input.setPercent(percent.getAsDouble());

        return input;
    }

    private ParamCalcModel calcScore(ParamCalcModel input) {
        TextTypeParam textTypeParam = (TextTypeParam) input.getParam();
        Integer availablePoints = textTypeParam.getPunctation();
        Double percent = input.getPercent();

        OptionalDouble score = OptionalDouble.of(availablePoints*(percent/100));

        if(score.isPresent())
            input.setScore(score.getAsDouble());

        return input;
    }
}
