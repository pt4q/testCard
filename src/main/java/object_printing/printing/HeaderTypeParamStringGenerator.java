package object_printing.printing;

import config.TestCardConfig;
import domain.HeaderTypeParam;
import domain.Param;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@RequiredArgsConstructor
class HeaderTypeParamStringGenerator implements Generator<Map<Integer, String>, Param> {

    @NonNull
    private TestCardConfig config;

    @Override
    public Map<Integer, String> generate(Param input) {
        if (input instanceof HeaderTypeParam)
            return generateHeaderTypeParamMap((HeaderTypeParam) input);

        return null;
    }

    private Map<Integer, String> generateHeaderTypeParamMap(HeaderTypeParam input){
        return new LinkedHashMap<Integer, String>() {{
            put(0, input.getType());
            put(1, input.getNameInPolish());
            put(2, "");
            put(3, input.getValueString());
            put(4, "");
            put(5, "");
            put(6, "");
            put(7, "");
            put(8, "");
            put(9, "");
            put(10, "");
        }};
    }
}
