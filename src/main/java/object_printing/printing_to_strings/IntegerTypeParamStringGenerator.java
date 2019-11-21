package object_printing.printing_to_strings;

import config.TestCardConfig;
import domain.IntegerTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;

import java.util.*;

@RequiredArgsConstructor
class IntegerTypeParamStringGenerator implements Generator<Map<Integer, String>, ParamCalcModel> {

    @NonNull
    private TestCardConfig config;

    @Override
    public Map<Integer, String> generate(ParamCalcModel input) {
        IntegerTypeParam itp = (IntegerTypeParam) input.getParam();

        return new HashMap<Integer, String>() {{
            put(0, itp.getType());
            put(1, itp.getNameInPolish());
            put(2, itp.getPunctation().toString());
            put(3, itp.getValueString());
            put(4, itp.getDeclaredValue().toString());
            put(5, itp.getMeasuredValue().toString());
            put(6, input.getDifference().toString());
            put(7, input.getPercent().toString());
            put(8, "");
            put(9, input.getAvailablePoints().toString());
            put(10, input.getScore().toString());
            put(11, "");
        }};
    }
}
