package object_creation.param;

import domain.BinaryTypeParam;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringValueConverter;

import java.util.List;

class BinaryTypeParamBuilder implements Builder<BinaryTypeParam, List<String>> {

    @Override
    public BinaryTypeParam build(List<String> input) {
        StringValueConverter converter = new StringValueConverter();
        BinaryTypeParam parameter = new BinaryTypeParam().builder()
                .nameInPolish(input.get(1))
                .build();

        try {
            parameter.setPunctation(converter.castToInteger(input.get(2)));
        } catch (IndexOutOfBoundsException e) {
            parameter.setPunctation(null);
        }

        try {
            parameter.setValue(converter.castPositiveScoreToBoolean(input.get(4)));
        } catch (IndexOutOfBoundsException e) {
            parameter.setValue(false);
        }
        return parameter;
    }
}
