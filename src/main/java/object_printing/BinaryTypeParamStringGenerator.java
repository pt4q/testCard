package object_printing;

import config.TestCardColumnsNumbers;
import config.TestCardConfig;
import domain.BinaryTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
class BinaryTypeParamStringGenerator implements Generator<List<ParamPrintModel>, BinaryTypeParam> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<ParamPrintModel> generate(BinaryTypeParam input) {
        List<ParamPrintModel> result = new ArrayList<>();
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();

        result.add(new ParamPrintModel(columnsNumbers.getNameInPolishColumnNumber(), input.getNameInPolish()));
        result.add(new ParamPrintModel(columnsNumbers.getPunctationColumnNumber(), input.getPunctation().toString()));
//        result.add(new ParamPrintModel(columnsNumbers.getMeasuredValuesColumnNumber(), input.getValueString()));

        String binaryValue = input.isValue() ? config.getPositiveDefinition().getPositive() : config.getPositiveDefinition().getNegative();
        result.add(new ParamPrintModel(columnsNumbers.getMeasuredValuesColumnNumber(),input.getValueString());

        return result;
    }
}
