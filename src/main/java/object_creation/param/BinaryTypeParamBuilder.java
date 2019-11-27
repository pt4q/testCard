package object_creation.param;

import domain.BinaryTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import utils.Builder;
import utils.StringValueConverter;
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

        BinaryTypeParam parameter = new BinaryTypeParam(input.get(columnsNumbers.getNameInPolishColumnNumber()));

        try {
            parameter.setPunctation(converter.castToInteger(input.get(columnsNumbers.getPunctationColumnNumber())));
        } catch (IndexOutOfBoundsException e) {
//            parameter.setPunctation(null);
        }

        try {
            parameter.setType(input.get(columnsNumbers.getParamTypeColumnNumber()));
        } catch (IndexOutOfBoundsException | NullPointerException e) {
//            parameter.setType(null);
        }

        try {
            parameter.setValueString(input.get(columnsNumbers.getReadValueColumnNumber()));
        } catch (IndexOutOfBoundsException e) {
//            parameter.setValueString(null);

        }
        try {
            parameter.setMeasuredValue(positiveDefinition.checkIsPositive(input.get(columnsNumbers.getMeasuredValuesColumnNumber())));
        } catch (IndexOutOfBoundsException e) {
//            parameter.setMeasuredValue(null);
        }
        try {
            parameter.setDeclaredValue(positiveDefinition.checkIsPositive(input.get(columnsNumbers.getDeclaredValuesColumnNumber())));
        } catch (IndexOutOfBoundsException e) {
//            parameter.setDeclaredValue(null);
        }
        return parameter;
    }
}
