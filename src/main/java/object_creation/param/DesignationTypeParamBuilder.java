package object_creation.param;

import domain.DesignationTypeParam;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringValueConverter;

import java.util.List;

class DesignationTypeParamBuilder implements Builder<DesignationTypeParam, List<String>> {
    @Override
    public DesignationTypeParam build(List<String> input) {
        StringValueConverter converter = new StringValueConverter();
        return new DesignationTypeParam().builder()
                .nameInPolish(input.get(1))
                .punctation(converter.castToInteger(input.get(2)))
                .value(input.get(4))
                .build();
    }
}
