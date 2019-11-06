package object_creation.param;

import domain.BinaryTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringValueConverter;
import config.BinaryTypePositiveDefinition;
import config.TestCardColumnsNumbers;
import config.TestCardConfig;

import java.util.List;

@RequiredArgsConstructor
class BinaryTypeParamBuilder implements Builder<BinaryTypeParam, List<String>> {

    @NonNull
    private TestCardConfig config;

    @Override
    public BinaryTypeParam build(List<String> input) {
        BinaryTypePositiveDefinition positiveDefinition = config.getPositiveDefinition();
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
            parameter.setValueString(input.get(columnsNumbers.getReadValueColumnNumber()));
            parameter.setMeasuredValue(positiveDefinition.checkIsPositive(input.get(columnsNumbers.getMeasuredValuesColumnNumber())));
        } catch (IndexOutOfBoundsException e) {
            parameter.setValueString(null);
            parameter.setMeasuredValue(false);
        }
        return parameter;
    }
}
