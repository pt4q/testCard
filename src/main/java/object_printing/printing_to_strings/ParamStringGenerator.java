package object_printing.printing_to_strings;

import config.TestCardConfig;
import domain.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
class ParamStringGenerator implements Generator<List<Map<Integer, String>>, List<ParamCalcModel>> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<Map<Integer, String>> generate(List<ParamCalcModel> input) {
        return convertParamsToListWithMaps(input);
    }

    private List<Map<Integer, String>> convertParamsToListWithMaps(List<ParamCalcModel> input) {
        List<Map<Integer, String>> result = new ArrayList<>();

        for (ParamCalcModel paramCalcModel : input) {
            Param param = paramCalcModel.getParam();

            if (param instanceof BinaryTypeParam)
                result.add(new BinaryTypeParamStringGenerator(config).generate(paramCalcModel));
            else if (param instanceof DoubleTypeParam)
                result.add(new DoubleTypeParamStringGenerator(config).generate(paramCalcModel));
            else if (param instanceof IntegerTypeParam)
                result.add(new IntegerTypeParamStringGenerator(config).generate(paramCalcModel));
            else if (param instanceof TextTypeParam)
                result.add(new TextTypeParamStringGenerator(config).generate(paramCalcModel));
        }
        return result;
    }
}
