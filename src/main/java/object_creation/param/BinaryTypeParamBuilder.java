package object_creation.param;

import domain.BinaryTypeParam;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringValueConverter;

import java.util.List;

class BinaryTypeParamBuilder implements Builder<BinaryTypeParam, List<String>> {

    @Override
    public BinaryTypeParam build(List<String> input) {
        StringValueConverter converter = new StringValueConverter();
        return new BinaryTypeParam().builder()
                .nameInPolish(input.get(1))
                .punctation(converter.castToInteger(input.get(2)))
                .value(converter.castPositiveScoreToBoolean(input.get(4)))
                .build();
    }
}
