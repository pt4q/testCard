package object_printing;

import config.TestCardColumnsNumbers;
import config.TestCardConfig;
import domain.IntegerTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;
import object_printing.models.ParamPrintModel;

import java.util.*;

@RequiredArgsConstructor
class IntegerTypeParamStringGenerator implements Generator<Map<Integer, String>, ParamCalcModel> {

    @NonNull
    private TestCardConfig config;

    @Override
    public Map<Integer, String> generate(ParamCalcModel input) {
        IntegerTypeParam itp = (IntegerTypeParam) input.getParam();

        return new HashMap<Integer, String>() {{
            put(0, itp.getNameInPolish());
            put(1, itp.getPunctation().toString());
            put(2, itp.getValueString());
            put(3, itp.getDeclaredValue().toString());
            put(4, itp.getMeasuredValue().toString());
            put(5, input.getDifference().toString());
            put(6, "");
            put(7, input.getAvailablePoints().toString());
            put(8, input.getScore().toString());
            put(9, "");
        }};
    }
}
