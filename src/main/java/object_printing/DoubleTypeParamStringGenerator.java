package object_printing;


import config.TestCardColumnsNumbers;
import config.TestCardConfig;
import domain.DoubleTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;
import object_printing.models.ParamPrintModel;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
class DoubleTypeParamStringGenerator implements Generator<List<ParamPrintModel>, ParamCalcModel> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<ParamPrintModel> generate(ParamCalcModel input) {
        DoubleTypeParam dtp = (DoubleTypeParam) input.getParam();
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();

        return Arrays.asList(
                new ParamPrintModel(columnsNumbers.getNameInPolishColumnNumber(),dtp.getNameInPolish()),
                new ParamPrintModel(columnsNumbers.getPunctationColumnNumber(),dtp.getPunctation().toString()),
                new ParamPrintModel(columnsNumbers.getReadValueColumnNumber(),dtp.getValueString()),
                new ParamPrintModel(columnsNumbers.getMeasuredValuesColumnNumber(),dtp.getMeasuredValue().toString()),
                new ParamPrintModel(columnsNumbers.getDeclaredValuesColumnNumber(),dtp.getDeclaredValue().toString())
        );
    }
}
