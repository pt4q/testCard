package object_printing;

import config.TestCardColumnsNumbers;
import config.TestCardConfig;
import domain.IntegerTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;
import object_printing.models.ParamPrintModel;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
class IntegerTypeParamStringGenerator implements Generator<List<ParamPrintModel>, ParamCalcModel> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<ParamPrintModel> generate(ParamCalcModel input) {
        IntegerTypeParam itp = (IntegerTypeParam) input.getParam();
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();

        return Arrays.asList(
                new ParamPrintModel(columnsNumbers.getNameInPolishColumnNumber(),itp.getNameInPolish()),
                new ParamPrintModel(columnsNumbers.getPunctationColumnNumber(),itp.getPunctation().toString()),
                new ParamPrintModel(columnsNumbers.getReadValueColumnNumber(),itp.getValueString()),
                new ParamPrintModel(columnsNumbers.getMeasuredValuesColumnNumber(),itp.getMeasuredValue().toString()),
                new ParamPrintModel(columnsNumbers.getDeclaredValuesColumnNumber(),itp.getDeclaredValue().toString())
        );
    }
}
