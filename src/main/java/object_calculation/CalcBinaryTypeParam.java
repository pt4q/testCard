package object_calculation;

import config.TestCardConfig;
import domain.BinaryTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;

import java.util.OptionalDouble;

@RequiredArgsConstructor
class CalcBinaryTypeParam implements Calculator<ParamCalcModel, BinaryTypeParam> {

    @NonNull
    private TestCardConfig config;

    @Override
    public ParamCalcModel calculate(BinaryTypeParam input) {
        ParamCalcModel calcModel = new ParamCalcModel(input);
        calcModel.setAvailablePoints(input.getPunctation());

        calcModel = calcScore(calcPercent(calcDifference(calcModel)));
        System.out.println(calcModel.getParam().getNameInPolish() + "\t" + calcModel.getAvailablePoints() + "\t" + calcModel.getDifference() + "\t" + calcModel.getPercent() + "\t" + calcModel.getScore());
        return calcModel;
    }

    private ParamCalcModel calcDifference(ParamCalcModel input) {
        BinaryTypeParam binaryTypeParam = (BinaryTypeParam) input.getParam();
        Boolean declared = binaryTypeParam.getDeclaredValue();
        Boolean measured = binaryTypeParam.getMeasuredValue();
        String resultString = "0";

        if (declared != null && measured != null) {
            if (declared == measured)
                resultString = "1";

            input.setDifference(Double.parseDouble(resultString));
        }
        return input;
    }

    private ParamCalcModel calcPercent(ParamCalcModel input) {
        Double difference = input.getDifference();
        OptionalDouble percent = OptionalDouble.empty();

        if (difference != null)
            percent = OptionalDouble.of(difference * 100);

        if (percent.isPresent())
            input.setPercent(percent.getAsDouble());

        return input;
    }

    private ParamCalcModel calcScore(ParamCalcModel input) {
        Integer availablePoints = input.getAvailablePoints();
        Double percent = input.getPercent();

        if (availablePoints !=null && percent != null) {
            OptionalDouble score = OptionalDouble.of(availablePoints * (percent / 100));

            if (score.isPresent())
                input.setScore(score.getAsDouble());
        }
        return input;
    }
}
