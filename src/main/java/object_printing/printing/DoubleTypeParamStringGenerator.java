package object_printing.printing;


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
            put(0, dtp.getType());
            put(1, dtp.getNameInPolish());
            put(2, dtp.getPunctation().toString());
            put(3, dtp.getValueString());
            put(4, dtp.getDeclaredValue().toString());
            put(5, dtp.getMeasuredValue().toString());
            put(6, input.getDifference().toString());
            put(7, input.getPercent().toString());
            put(8, "");
            put(9, input.getAvailablePoints().toString());
            put(10, input.getScore().toString());
            put(11, "");
        }};
    }
}
