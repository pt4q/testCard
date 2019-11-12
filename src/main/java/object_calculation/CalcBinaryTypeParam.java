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
//        System.out.println(calcModel.getParam().getNameInPolish() + "\t" + calcModel.getAvailablePoints() + "\t" + calcModel.getDifference() + "\t" + calcModel.getPercent() + "\t" + calcModel.getScore());
        return calcModel;
    }

    private ParamCalcModel calcDifference(ParamCalcModel input) {
        BinaryTypeParam binaryTypeParam = (BinaryTypeParam) input.getParam();
        Boolean declared = binaryTypeParam.getDeclaredValue();
        Boolean measured = binaryTypeParam.getMeasuredValue();
        String resultString = "1";

        if (declared != null && measured != null) {
            if (declared == measured)
                resultString = "0";

            input.setDifference(Double.parseDouble(resultString));
        } else
            input.setDifference(0.0);

        return input;
    }

    private ParamCalcModel calcPercent(ParamCalcModel input) {
        Double difference = input.getDifference();
        double percent = 0.0;

        if (difference != null)
            if (difference == 0)
                percent = 100.0;

        input.setPercent(percent);
        return input;
    }

    private ParamCalcModel calcScore(ParamCalcModel input) {
        Integer availablePoints = input.getAvailablePoints();
        Double percent = input.getPercent();
        double score = 0.0;

        if (availablePoints != null && percent != null)
            score = OptionalDouble.of(availablePoints * (percent / 100))
                    .orElse(0.0);

        input.setScore(score);
        return input;
    }
}
