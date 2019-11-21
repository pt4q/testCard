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
            put(0, ttp.getType());
            put(1, ttp.getNameInPolish());
            put(2, ttp.getPunctation().toString());
            put(3, ttp.getValueString());
            put(4, ttp.getDeclaredValue());
            put(5, ttp.getMeasuredValue());
            put(6, input.getDifference().toString());
            put(7, input.getPercent().toString());
            put(8, "");
            put(9, input.getAvailablePoints().toString());
            put(10, input.getScore().toString());
            put(11, "");
        }};
    }
}
