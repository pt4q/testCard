package object_creation.param;

import domain.TextTypeParam;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringValueConverter;

import java.util.List;

class TextTypeParamBuilder implements Builder<TextTypeParam, List<String>> {
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
