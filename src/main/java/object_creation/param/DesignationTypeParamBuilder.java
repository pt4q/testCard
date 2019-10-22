package object_creation.param;

import domain.DesignationTypeParam;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.ValueConverter;

import java.util.List;

class DesignationTypeParamBuilder implements Builder<DesignationTypeParam, List<String>> {
    @Override
    public DesignationTypeParam build(List<String> input) {
        ValueConverter converter = new ValueConverter();
        return new DesignationTypeParam().builder()
                .nameInPolish(input.get(1))
                .nameInEnglish(input.get(2))
                .punctation(converter.castToInteger(input.get(3)))
                .value(input.get(5))
                .build();
    }
}
