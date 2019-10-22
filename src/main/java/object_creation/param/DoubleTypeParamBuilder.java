package object_creation.param;

import domain.DoubleTypeParameter;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.ValueConverter;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

class DoubleTypeParamBuilder implements Builder<DoubleTypeParameter, List<String>> {

    @Override
    public DoubleTypeParameter build(List<String> input) {
        ValueConverter converter = new ValueConverter();
        return tryToAddSubtypeAndValue(new DoubleTypeParameter().builder()
                .nameInPolish(input.get(1))
                .nameInEnglish(input.get(2))
                .punctation(converter.castToInteger(input.get(3)))
                .subtype(null)
                .value(null)
                .build(), input);
    }

    private DoubleTypeParameter tryToAddSubtypeAndValue(DoubleTypeParameter param, List<String> list) {
        String value = list .get(5);
        List<String> tmp = Arrays.asList(value.split(" - "));
        if (tmp.size() == 2){
            param.setSubtype(tmp.get(0));
            tmp = Arrays.asList(tmp.get(1).split(", "));
            if (tmp.size() > 1)
                param.setValue(calcAverage(tmp));
            else
                ;
        }


        return param;
    }

    private Double calcAverage (List<String> list){
        OptionalDouble result = list.stream()
                .mapToDouble(Double::parseDouble)
                .average();
        if (result.isPresent())
            return result.getAsDouble();
        else
            return null;
    }
}
