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
        calcModel.setAvailablePoints(input.getPunctation());

        calcModel = calcScore(calcPercent(calcDifference(calcModel)));
        System.out.println(calcModel.getParam().getNameInPolish() + "\t" + calcModel.getAvailablePoints() + "\t" + calcModel.getDifference() + "\t" + calcModel.getPercent() + "\t" + calcModel.getScore());
        return calcModel;
    }

    private ParamCalcModel calcDifference(ParamCalcModel input) {
        DoubleTypeParam doubleTypeParam = (DoubleTypeParam) input.getParam();
        Double declared = doubleTypeParam.getDeclaredValue();
        Double measured = doubleTypeParam.getMeasuredValue();

        if (declared != null && measured != null) {
            OptionalDouble difference = OptionalDouble.of(declared - measured);

            if (difference.isPresent())
                input.setDifference(difference.getAsDouble());
        }
        return input;
    }

    private ParamCalcModel calcPercent(ParamCalcModel input) {
        DoubleTypeParam doubleTypeParam = (DoubleTypeParam) input.getParam();
        Double declared = doubleTypeParam.getDeclaredValue();
        Double measured = doubleTypeParam.getMeasuredValue();
        OptionalDouble percent = OptionalDouble.empty();

        if ((declared != null && declared > 0) && (measured!= null && measured > 0))
            percent = OptionalDouble.of((measured * 100) / declared);

        if (percent.isPresent())
            input.setPercent(percent.getAsDouble());

        return input;
    }

    private ParamCalcModel calcScore(ParamCalcModel input) {
        Integer availablePoints = input.getAvailablePoints();
        Double percent = input.getPercent();
        Double percentAbs;

        if (percent != null) {
            percentAbs = Math.abs(percent);

            if (percentAbs > 100)
                percentAbs = Double.parseDouble("100");
            else if (percentAbs < 0)
                percentAbs = Double.parseDouble("0");

            OptionalDouble score = OptionalDouble.of((percentAbs / 100) * availablePoints);

            if (score.isPresent())
                input.setScore(score.getAsDouble());
        }
        return input;
    }

}
