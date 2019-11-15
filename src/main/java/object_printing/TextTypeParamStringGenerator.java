package object_printing;

import config.TestCardColumnsNumbers;
import config.TestCardConfig;
import domain.TextTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;
import object_printing.models.ParamPrintModel;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
class TextTypeParamStringGenerator implements Generator<List<ParamPrintModel>, ParamCalcModel> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<ParamPrintModel> generate(ParamCalcModel input) {
        TextTypeParam ttp = (TextTypeParam) input.getParam();
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();

        return Arrays.asList(
                new ParamPrintModel(columnsNumbers.getNameInPolishColumnNumber(),ttp.getNameInPolish()),
                new ParamPrintModel(columnsNumbers.getPunctationColumnNumber(),ttp.getPunctation().toString()),
                new ParamPrintModel(columnsNumbers.getReadValueColumnNumber(),ttp.getValueString()),
                new ParamPrintModel(columnsNumbers.getMeasuredValuesColumnNumber(),ttp.getMeasuredValue()),
                new ParamPrintModel(columnsNumbers.getDeclaredValuesColumnNumber(),ttp.getDeclaredValue())
        );
    }
}
