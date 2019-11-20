package object_printing.printing_to_strings;


import config.TestCardConfig;
import domain.DoubleTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
class DoubleTypeParamStringGenerator implements Generator<Map<Integer, String>, ParamCalcModel> {

    @NonNull
    private TestCardConfig config;

    @Override
    public Map<Integer, String> generate(ParamCalcModel input) {
        DoubleTypeParam dtp = (DoubleTypeParam) input.getParam();

        return new HashMap<Integer, String>() {{
            put(0, dtp.getNameInPolish());
            put(1, dtp.getPunctation().toString());
            put(2, dtp.getValueString());
            put(3, dtp.getDeclaredValue().toString());
            put(4, dtp.getMeasuredValue().toString());
            put(5, input.getDifference().toString());
            put(6, "");
            put(7, input.getAvailablePoints().toString());
            put(8, input.getScore().toString());
            put(9, "");
        }};
    }
}
