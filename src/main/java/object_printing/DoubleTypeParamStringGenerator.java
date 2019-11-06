package object_printing;


import config.TestCardColumnsNumbers;
import config.TestCardConfig;
import domain.DoubleTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
class DoubleTypeParamStringGenerator implements Generator<List<ParamPrintModel>, DoubleTypeParam> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<ParamPrintModel> generate(DoubleTypeParam input) {
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();

        return Arrays.asList(
                new ParamPrintModel(columnsNumbers.getNameInPolishColumnNumber(),input.getNameInPolish()),
                new ParamPrintModel(columnsNumbers.getPunctationColumnNumber(),input.getPunctation().toString()),
                new ParamPrintModel(columnsNumbers.getReadValueColumnNumber(),input.getValueString()),
                new ParamPrintModel(columnsNumbers.getMeasuredValuesColumnNumber(),input.getMeasuredValue().toString()),
                new ParamPrintModel(columnsNumbers.getDeclaredValuesColumnNumber(),input.getDeclaredValue().toString())
        );
    }
}
