package object_printing;

import config.TestCardColumnsNumbers;
import config.TestCardConfig;
import domain.BinaryTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;
import object_printing.models.ParamPrintModel;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
class BinaryTypeParamStringGenerator implements Generator<List<ParamPrintModel>, ParamCalcModel> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<ParamPrintModel> generate(ParamCalcModel input) {
        BinaryTypeParam btp = (BinaryTypeParam) input.getParam();
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();
        Boolean measuredValue = btp.getMeasuredValue();
        Boolean declaredValue = btp.getDeclaredValue();

        String measuredBinaryToStringValue = convertMeasuredValueToString(measuredValue);
        String declaredBinaryToStringValue = convertDeclaredValueToString(declaredValue);

        return Arrays.asList(
                new ParamPrintModel(columnsNumbers.getNameInPolishColumnNumber(), btp.getNameInPolish()),
                new ParamPrintModel(columnsNumbers.getPunctationColumnNumber(), btp.getPunctation().toString()),
                new ParamPrintModel(columnsNumbers.getMeasuredValuesColumnNumber(), btp.getValueString()),
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
