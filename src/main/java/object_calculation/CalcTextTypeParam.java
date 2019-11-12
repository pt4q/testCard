package object_calculation;

import config.TestCardConfig;
import domain.TextTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;

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
        }
        return input;
    }

    private ParamCalcModel calcPercent(ParamCalcModel input) {
        Double difference = input.getDifference();
        OptionalDouble percent = OptionalDouble.empty();

        if (difference != null)
            if (difference == 0)
                percent = OptionalDouble.of(100);
            else
                percent = OptionalDouble.of(0);

        if (percent.isPresent())
            input.setPercent(percent.getAsDouble());

        return input;
    }

    private ParamCalcModel calcScore(ParamCalcModel input) {
        Integer availablePoints = input.getAvailablePoints();
        Double percent = input.getPercent();

        if (availablePoints != null && percent != null) {
            OptionalDouble score = OptionalDouble.of(availablePoints * (percent / 100));

            if (score.isPresent())
                input.setScore(score.getAsDouble());
        }
        return input;
    }
}
