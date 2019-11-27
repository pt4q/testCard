package object_calculation;

import config.TestCardConfig;
import domain.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;
import utils.Calculator;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ParamListCalculator implements Calculator<List<ParamCalcModel> , List<Param>> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<ParamCalcModel> calculate(List<Param> input) {
        return detectParamTypeAndCalculateEachParam(input);
    }

    private List<ParamCalcModel> detectParamTypeAndCalculateEachParam(List<Param> input){
        List<ParamCalcModel> result = new ArrayList<>();

        for (Param param : input) {
            if (param instanceof BinaryTypeParam)
                result.add(new CalcBinaryTypeParam(config).calculate((BinaryTypeParam) param));
            else if (param instanceof DoubleTypeParam)
                result.add(new CalcDoubleTypeParam(config).calculate((DoubleTypeParam) param));
            else if (param instanceof IntegerTypeParam)
                result.add(new CalcIntegerTypeParam(config).calculate((IntegerTypeParam) param));
            else if (param instanceof TextTypeParam)
                result.add(new CalcTextTypeParam(config).calculate((TextTypeParam) param));
        }

        return result;
    }
}
