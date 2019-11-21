package object_printing.printing;

import config.TestCardConfig;
import domain.BinaryTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_calculation.models.ParamCalcModel;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
class BinaryTypeParamStringGenerator implements Generator<Map<Integer, String>, ParamCalcModel> {

    @NonNull
    private TestCardConfig config;

    @Override
    public Map<Integer, String> generate(ParamCalcModel input) {
        BinaryTypeParam btp = (BinaryTypeParam) input.getParam();
        Boolean measuredValue = btp.getMeasuredValue();
        Boolean declaredValue = btp.getDeclaredValue();

        String measuredBinaryToStringValue = convertMeasuredValueToString(measuredValue);
        String declaredBinaryToStringValue = convertDeclaredValueToString(declaredValue);

        return new HashMap<Integer, String>() {{
            put(0, btp.getType());
            put(1, btp.getNameInPolish());
            put(2, btp.getPunctation().toString());
            put(3, btp.getValueString());
            put(4, declaredBinaryToStringValue);
            put(5, measuredBinaryToStringValue);
            put(6, input.getDifference().toString());
            put(7, input.getPercent().toString());
            put(8, "");
            put(9, input.getAvailablePoints().toString());
            put(10, input.getScore().toString());
            put(11, "");
        }};
    }

    private String convertMeasuredValueToString(Boolean measuredValue) {
        if (measuredValue.equals(true))
            return config.getPositiveDefinition().getPositive();
        else if (measuredValue.equals(false))
            return config.getPositiveDefinition().getNegative();
        else
            return "";
    }

    private String convertDeclaredValueToString(Boolean declaredValue) {
        if (declaredValue.equals(true))
            return config.getPositiveDefinition().getPositive();
        else if (declaredValue.equals(false))
            return config.getPositiveDefinition().getNegative();
        else
            return "";
    }
}
