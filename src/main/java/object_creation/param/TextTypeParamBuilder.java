package object_creation.param;

import domain.TextTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringValueConverter;
import object_creation.test_card.config.TestCardConfig;

import java.util.List;

@RequiredArgsConstructor
class TextTypeParamBuilder implements Builder<TextTypeParam, List<String>> {

    @NonNull
    private TestCardConfig config;

    @Override
    public TextTypeParam build(List<String> input) {
        StringValueConverter converter = new StringValueConverter();

        TextTypeParam parameter = new TextTypeParam().builder()
                .nameInPolish(input.get(1))
                .build();

        try {
            parameter.setPunctation(converter.castToInteger(input.get(2)));
        } catch (IndexOutOfBoundsException e) {
            parameter.setPunctation(null);
        }

        try {
            parameter.setValue((input.get(4)));
        } catch (IndexOutOfBoundsException e) {
            parameter.setValue(null);
        }
        return parameter;
    }
}
