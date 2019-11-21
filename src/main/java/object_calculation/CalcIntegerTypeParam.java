package object_calculation;

import config.TestCardConfig;
import domain.IntegerTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;

import java.util.OptionalDouble;

@RequiredArgsConstructor
class CalcIntegerTypeParam implements Calculator<ParamCalcModel, IntegerTypeParam> {

    @NonNull
    private TestCardConfig config;

    @Override
    public ParamCalcModel calculate(IntegerTypeParam input) {
        ParamCalcModel calcModel = new ParamCalcModel(input);

        calcModel.setAvailablePoints(input.getPunctation());

        calcModel = calcScore(calcPercent(calcDifference(calcModel)));
//        System.out.println(calcModel.getParam().getNameInPolish() + "\t" + calcModel.getAvailablePoints() + "\t" + calcModel.getDifference() + "\t" + calcModel.getPercent() + "\t" + calcModel.getScore());
        return calcModel;
    }

    private ParamCalcModel calcDifference(ParamCalcModel input) {
        IntegerTypeParam integerTypeParam = (IntegerTypeParam) input.getParam();
        Integer declared = integerTypeParam.getDeclaredValue();
        Integer measured = integerTypeParam.getMeasuredValue();

        if (measured != null && declared != 0) {
            OptionalDouble difference = OptionalDouble.of(declared - measured);

            if (difference.isPresent())
                input.setDifference(difference.getAsDouble());
        } else
            input.setDifference(Double.parseDouble("0"));

        return input;
    }

    private ParamCalcModel calcPercent(ParamCalcModel input) {
        IntegerTypeParam integerTypeParam = (IntegerTypeParam) input.getParam();
        Integer declared = integerTypeParam.getDeclaredValue();
        Integer measured = integerTypeParam.getMeasuredValue();
        double percent = 0.0;

        if ((declared != null && declared > 0) && (measured != null && measured > 0))
            percent = OptionalDouble.of(100 - ((measured * 100) / declared))
                    .orElse(0.0);

        input.setPercent(percent);
        return input;
    }

    private ParamCalcModel calcScore(ParamCalcModel input) {
        Integer availablePoints = input.getAvailablePoints();
        Double percent = input.getPercent();
        double percentAbs;
        double score = 0.0;

        if (percent != null) {
            percentAbs = Math.abs(percent);

            if (percentAbs > 100)
                percentAbs = Double.parseDouble("100");
            else if (percentAbs < 0)
                percentAbs = Double.parseDouble("0");

            score = OptionalDouble.of(((100 - percentAbs) / 100) * availablePoints)
                    .orElse(0.0);
        }
        input.setScore(score);

        return input;
    }
}
