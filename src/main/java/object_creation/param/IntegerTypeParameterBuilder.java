package object_creation.param;

import domain.IntegerTypeParameter;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringValueConverter;

import java.util.List;

class IntegerTypeParameterBuilder implements Builder<IntegerTypeParameter, List<String>> {
    @Override
    public IntegerTypeParameter build(List<String> input) {
        StringValueConverter converter = new StringValueConverter();
        Integer inputSize = input.size();

        IntegerTypeParameter parameter = new IntegerTypeParameter().builder()
                .nameInPolish(input.get(1))
                .build();

        try {
            parameter.setPunctation(converter.castToInteger(input.get(2)));
        } catch (IndexOutOfBoundsException e) {
            parameter.setPunctation(null);
        }

        try {
            parameter.setValue(converter.castToInteger(input.get(4)));
        } catch (IndexOutOfBoundsException e) {
            parameter.setValue(null);
        }
        return parameter;
    }
}
