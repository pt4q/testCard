package object_calculation;

import config.TestCardConfig;
import domain.TextTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;
import utils.Calculator;

import java.util.OptionalDouble;

@RequiredArgsConstructor
class CalcTextTypeParam implements Calculator<ParamCalcModel, TextTypeParam> {

    @NonNull
    private TestCardConfig config;

    @Override
    public ParamCalcModel calculate(TextTypeParam input) {
        ParamCalcModel calcModel = new ParamCalcModel(input);
        calcModel.setAvailablePoints(input.getPunctation());

        calcModel = calcScore(calcPercent(calcDifference(calcModel)));
//        System.out.println(calcModel.getParam().getNameInPolish() + "\t" + calcModel.getAvailablePoints() + "\t" + calcModel.getDifference() + "\t" + calcModel.getPercent() + "\t" + calcModel.getScore());
        return calcModel;
    }

    private ParamCalcModel calcDifference(ParamCalcModel input) {
        TextTypeParam textTypeParam = (TextTypeParam) input.getParam();
        String declared = textTypeParam.getDeclaredValue();
        String measured = textTypeParam.getMeasuredValue();
        String resultString = "1";

        if (declared != null && measured != null) {
            if (declared.equals(measured))
                resultString = "0";

            input.setDifference(Double.parseDouble(resultString));
        } else
            input.setDifference(Double.parseDouble("0"));

        return input;
    }

    private ParamCalcModel calcPercent(ParamCalcModel input) {
        Double difference = input.getDifference();
        double percent = 0.0;

        if (difference != null)
            if (difference == 0)
                percent = 0.0;
            else
                percent = 100.0;

        input.setPercent(percent);
        return input;
    }

    private ParamCalcModel calcScore(ParamCalcModel input) {
        Integer availablePoints = input.getAvailablePoints();
        Double percent = input.getPercent();
        double score = 0.0;

        if (availablePoints != null && percent != null)
            score = OptionalDouble.of(availablePoints * ((100 - percent) / 100))
                    .orElse(0.0);

        input.setScore(score);
        return input;
    }
}
