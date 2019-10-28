package object_creation.param;

import domain.DoubleTypeParameter;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringValueConverter;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

class DoubleTypeParamBuilder implements Builder<DoubleTypeParameter, List<String>> {

    @Override
    public DoubleTypeParameter build(List<String> input) {
        StringValueConverter converter = new StringValueConverter();

        DoubleTypeParameter parameter = new DoubleTypeParameter().builder()
                .nameInPolish(input.get(1))
                .subtype(null)
                .build();

        try {
            parameter.setPunctation(converter.castToInteger(input.get(2)));
        } catch (IndexOutOfBoundsException e) {
            parameter.setPunctation(null);
        }

        try {
            parameter.setValue(converter.castToDouble(input.get(4)));
            parameter = tryToAddSubtypeAndValue(parameter, input);
        } catch (IndexOutOfBoundsException e) {
            parameter.setValue(null);
        }
        return parameter;
    }

    private DoubleTypeParameter tryToAddSubtypeAndValue(DoubleTypeParameter param, List<String> list) {
        String value = list.get(4);
        List<String> tmp = Arrays.asList(value.split(" - "));

        if (tmp.size() == 2) {
            param.setSubtype(tmp.get(0));
            tmp = Arrays.asList(tmp.get(1).split(", "));

            if (tmp.size() > 1) {
                param.setValue(calcAverage(tmp));
            } else
                throw new ArithmeticException(ParamFactoryStatusEnum.DOUBLE_PARAMETER_BUILDER_SUBTYPE_ERR.toString());
        }
        return param;
    }

    private Double calcAverage(List<String> list) {
        OptionalDouble result = list.stream()
                .mapToDouble(Double::parseDouble)
                .average();
        if (result.isPresent())
            return result.getAsDouble();
        else
            throw new ArithmeticException();
    }
}
