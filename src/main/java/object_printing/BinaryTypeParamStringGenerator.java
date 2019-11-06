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
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();
        String measuredBinaryToStringValue = input.isMeasuredValue() ? config.getPositiveDefinition().getPositive() : config.getPositiveDefinition().getNegative();
        String declaredBinaryToStringValue = input.isDeclaredValue() ? config.getPositiveDefinition().getPositive() : config.getPositiveDefinition().getNegative();

        return Arrays.asList(
                new ParamPrintModel(columnsNumbers.getNameInPolishColumnNumber(), input.getNameInPolish()),
                new ParamPrintModel(columnsNumbers.getPunctationColumnNumber(), input.getPunctation().toString()),
                new ParamPrintModel(columnsNumbers.getMeasuredValuesColumnNumber(), input.getValueString()),
                new ParamPrintModel(columnsNumbers.getMeasuredValuesColumnNumber(), measuredBinaryToStringValue),
                new ParamPrintModel(columnsNumbers.getMeasuredValuesColumnNumber(), declaredBinaryToStringValue)
        );
    }
}
