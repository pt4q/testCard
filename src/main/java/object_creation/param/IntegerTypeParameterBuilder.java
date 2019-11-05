package object_creation.param;

import domain.IntegerTypeParameter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringValueConverter;
import config.TestCardColumnsNumbers;
import config.TestCardConfig;

import java.util.List;

@RequiredArgsConstructor
class IntegerTypeParameterBuilder implements Builder<IntegerTypeParameter, List<String>> {

    @NonNull
    private TestCardConfig config;

    @Override
    public IntegerTypeParameter build(List<String> input) {
        StringValueConverter converter = new StringValueConverter();
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();
        Integer inputSize = input.size();

        IntegerTypeParameter parameter = new IntegerTypeParameter().builder()
                .nameInPolish(input.get(columnsNumbers.getNameInPolishColumnNumber()))
                .build();

        try {
            parameter.setPunctation(converter.castToInteger(input.get(columnsNumbers.getPunctationColumnNumber())));
        } catch (IndexOutOfBoundsException e) {
            parameter.setPunctation(null);
        }

        try {
            parameter.setValue(converter.castToInteger(input.get(columnsNumbers.getMeasuredValuesColumnNumber())));
        } catch (IndexOutOfBoundsException e) {
            parameter.setValue(null);
        }
        return parameter;
    }
}
