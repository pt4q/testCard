package object_creation.param;

import domain.IntegerTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringValueConverter;
import config.TestCardColumnsNumbers;
import config.TestCardConfig;

import java.util.List;

@RequiredArgsConstructor
class IntegerTypeParameterBuilder implements Builder<IntegerTypeParam, List<String>> {

    @NonNull
    private TestCardConfig config;

    @Override
    public IntegerTypeParam build(List<String> input) {
        StringValueConverter converter = new StringValueConverter();
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();
        Integer inputSize = input.size();

        IntegerTypeParam parameter = new IntegerTypeParam().builder()
                .nameInPolish(input.get(columnsNumbers.getNameInPolishColumnNumber()))
                .build();

        try {
            parameter.setPunctation(converter.castToInteger(input.get(columnsNumbers.getPunctationColumnNumber())));
        } catch (IndexOutOfBoundsException e) {
            parameter.setPunctation(null);
        }

        try{
            parameter.setDeclaredValue(converter.castToInteger(input.get(columnsNumbers.getDeclaredValuesColumnNumber())));
        } catch (IndexOutOfBoundsException e){
            parameter.setDeclaredValue(null);
        }

        try {
            parameter.setValueString(input.get(columnsNumbers.getReadValueColumnNumber()));
            parameter.setMeasuredValue(converter.castToInteger(input.get(columnsNumbers.getMeasuredValuesColumnNumber())));
        } catch (IndexOutOfBoundsException e) {
            parameter.setValueString(null);
            parameter.setMeasuredValue(null);
        }
        return parameter;
    }
}
