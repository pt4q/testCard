package object_printing;

import config.TestCardColumnsNumbers;
import config.TestCardConfig;
import domain.TextTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
class TextTypeParamStringGenerator implements Generator<List<ParamPrintModel>, TextTypeParam> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<ParamPrintModel> generate(TextTypeParam input) {
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();

        return Arrays.asList(
                new ParamPrintModel(columnsNumbers.getNameInPolishColumnNumber(),input.getNameInPolish()),
                new ParamPrintModel(columnsNumbers.getPunctationColumnNumber(),input.getPunctation().toString()),
                new ParamPrintModel(columnsNumbers.getReadValueColumnNumber(),input.getValueString()),
                new ParamPrintModel(columnsNumbers.getMeasuredValuesColumnNumber(),input.getMeasuredValue()),
                new ParamPrintModel(columnsNumbers.getDeclaredValuesColumnNumber(),input.getDeclaredValue())
        );
    }
}
