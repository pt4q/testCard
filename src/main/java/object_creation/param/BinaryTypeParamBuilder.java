package object_creation.param;

import domain.BinaryTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringValueConverter;
import object_creation.test_card.config.TestCardColumnsNumbers;
import object_creation.test_card.config.TestCardConfig;

import java.util.List;

@RequiredArgsConstructor
class BinaryTypeParamBuilder implements Builder<BinaryTypeParam, List<String>> {

    @NonNull
    private TestCardConfig config;

    @Override
    public BinaryTypeParam build(List<String> input) {
        StringValueConverter converter = new StringValueConverter();
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();

        BinaryTypeParam parameter = new BinaryTypeParam().builder()
                .nameInPolish(input.get(columnsNumbers.getNameInPolishColumnNumber()))
                .build();

        try {
            parameter.setPunctation(converter.castToInteger(input.get(columnsNumbers.getPunctationColumnNumber())));
        } catch (IndexOutOfBoundsException e) {
            parameter.setPunctation(null);
        }

        try {
            parameter.setValue(converter.castPositiveScoreToBoolean(input.get(columnsNumbers.getMeasuredValuesColumnNumber())));
        } catch (IndexOutOfBoundsException e) {
            parameter.setValue(false);
        }
        return parameter;
    }
}
