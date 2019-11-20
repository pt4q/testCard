package object_printing.printing_to_strings;

import config.TestCardConfig;
import domain.TextTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
class TextTypeParamStringGenerator implements Generator<Map<Integer, String>, ParamCalcModel> {

    @NonNull
    private TestCardConfig config;

    @Override
    public Map<Integer, String> generate(ParamCalcModel input) {
        TextTypeParam ttp = (TextTypeParam) input.getParam();

        return new HashMap<Integer, String>() {{
            put(0, ttp.getNameInPolish());
            put(1, ttp.getPunctation().toString());
            put(2, ttp.getValueString());
            put(3, ttp.getDeclaredValue());
            put(4, ttp.getMeasuredValue());
            put(5, input.getDifference().toString());
            put(6, "");
            put(7, input.getAvailablePoints().toString());
            put(8, input.getScore().toString());
            put(9, "");
        }};
    }
}
