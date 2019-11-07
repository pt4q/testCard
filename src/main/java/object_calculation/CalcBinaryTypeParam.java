package object_calculation;

import domain.BinaryTypeParam;
import lombok.NoArgsConstructor;
import object_calculation.models.ParamCalcModel;

import java.util.OptionalDouble;

@NoArgsConstructor
class CalcBinaryTypeParam implements Calculator<ParamCalcModel, BinaryTypeParam> {

    @Override
    public ParamCalcModel calculate(BinaryTypeParam input) {
        ParamCalcModel calcModel = new ParamCalcModel(input);

        calcModel = calcScore(calcPercent(calcDifference(calcModel)));

        return calcModel;
    }

    private ParamCalcModel calcDifference(ParamCalcModel input){
        BinaryTypeParam binaryTypeParam = (BinaryTypeParam) input.getParam();
        Boolean declared = binaryTypeParam.getDeclaredValue();
        Boolean measured = binaryTypeParam.getMeasuredValue();
        String resultString = "0";

        if (declared == measured)
            resultString = "1";

        input.setDifference(Double.parseDouble(resultString));
        return input;
    }

    private ParamCalcModel calcPercent(ParamCalcModel input){
        Double difference = input.getDifference();
        OptionalDouble percent = OptionalDouble.of(difference*100);

        if (percent.isPresent())
            input.setPercent(percent.getAsDouble());

        return input;
    }

    private ParamCalcModel calcScore(ParamCalcModel input){
        BinaryTypeParam binaryTypeParam = (BinaryTypeParam) input.getParam();
        Integer availablePoints = binaryTypeParam.getPunctation();
        Double percent = input.getPercent();

        OptionalDouble score = OptionalDouble.of(availablePoints * percent);

        if (score.isPresent())
            input.setScore(score.getAsDouble());

        return input;
    }
}
