package object_calculation;

import domain.*;
import object_calculation.models.ParamCalcModel;
import object_printing.*;

import java.util.ArrayList;
import java.util.List;

public class ParamCalculator implements Calculator <List<ParamCalcModel> , List<Param>> {

    @Override
    public List<ParamCalcModel> calculate(List<Param> input) {
        return null;
    }

    private void detectParamType(List<Param> input){
        List<List<ParamCalcModel>> result = new ArrayList<>();

        for (Param param : input) {
            if (param instanceof BinaryTypeParam)
//                result.add(new BinaryTypeParamStringGenerator(config).generate((BinaryTypeParam) param));
            else if (param instanceof DoubleTypeParam)
                result.add(new DoubleTypeParamStringGenerator(config).generate((DoubleTypeParam) param));
            else if (param instanceof IntegerTypeParam)
                result.add(new IntegerTypeParamStringGenerator(config).generate((IntegerTypeParam) param));
            else if (param instanceof TextTypeParam)
                result.add(new TextTypeParamStringGenerator(config).generate((TextTypeParam) param));
        }
    }
}
