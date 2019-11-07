package object_creation.param;

import domain.TextTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringValueConverter;
import config.TestCardColumnsNumbers;
import config.TestCardConfig;

import java.util.List;

@RequiredArgsConstructor
class TextTypeParamBuilder implements Builder<TextTypeParam, List<String>> {

    @NonNull
    private TestCardConfig config;

    @Override
    public TextTypeParam build(List<String> input) {
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();
        StringValueConverter converter = new StringValueConverter();

        TextTypeParam parameter = new TextTypeParam().builder()
                .nameInPolish(input.get(columnsNumbers.getNameInPolishColumnNumber()))
                .build();

        try {
            parameter.setPunctation(converter.castToInteger(input.get(columnsNumbers.getPunctationColumnNumber())));
        } catch (IndexOutOfBoundsException e) {
            parameter.setPunctation(null);
        }

        try {
            parameter.setDeclaredValue(input.get(columnsNumbers.getDeclaredValuesColumnNumber()));
        } catch (IndexOutOfBoundsException e) {
            parameter.setDeclaredValue(null);
        }

        try {
            parameter.setValueString(input.get(columnsNumbers.getReadValueColumnNumber()));
            parameter.setMeasuredValue(input.get(columnsNumbers.getMeasuredValuesColumnNumber()));
        } catch (IndexOutOfBoundsException e) {
            parameter.setValueString(null);
            parameter.setMeasuredValue(null);
        }
        return parameter;
    }
}
