package object_creation.param;

import domain.BinaryTypeParam;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.ValueConverter;

import java.util.List;

class BinaryTypeParamBuilder implements Builder<BinaryTypeParam, List<String>> {

    @Override
    public BinaryTypeParam build(List<String> input) {
        ValueConverter converter = new ValueConverter();
        return new BinaryTypeParam().builder()
                .nameInPolish(input.get(1))
                .nameInEnglish(input.get(2))
                .punctation(converter.castToInteger(input.get(3)))
                .value(converter.castToBoolean(input.get(5)))
                .build();
    }
}
