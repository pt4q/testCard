package object_printing;

import config.TestCardColumnsNumbers;
import config.TestCardConfig;
import domain.BinaryTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
class BinaryTypeParamStringGenerator implements Generator<List<ParamPrintModel>, BinaryTypeParam> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<ParamPrintModel> generate(BinaryTypeParam input) {
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();
        Boolean measuredValue = input.getMeasuredValue();
        Boolean declaredValue = input.getDeclaredValue();

        String measuredBinaryToStringValue = convertMeasuredValueToString(measuredValue);
        String declaredBinaryToStringValue = convertDeclaredValueToString(declaredValue);

        return Arrays.asList(
                new ParamPrintModel(columnsNumbers.getNameInPolishColumnNumber(), input.getNameInPolish()),
                new ParamPrintModel(columnsNumbers.getPunctationColumnNumber(), input.getPunctation().toString()),
                new ParamPrintModel(columnsNumbers.getMeasuredValuesColumnNumber(), input.getValueString()),
                new ParamPrintModel(columnsNumbers.getMeasuredValuesColumnNumber(), measuredBinaryToStringValue),
                new ParamPrintModel(columnsNumbers.getMeasuredValuesColumnNumber(), declaredBinaryToStringValue)
        );
    }

    private String convertMeasuredValueToString(Boolean measuredValue) {
        if (measuredValue.equals(true))
            return config.getPositiveDefinition().getPositive();
        else if (measuredValue.equals(false))
            return config.getPositiveDefinition().getNegative();
        else
            return "";
    }

    private String convertDeclaredValueToString(Boolean declaredValue) {
        if (declaredValue.equals(true))
            return config.getPositiveDefinition().getPositive();
        else if (declaredValue.equals(false))
            return config.getPositiveDefinition().getNegative();
        else
            return "";
    }
}
