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
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            parameter.setPunctation(null);
        }

        try {
            parameter = tryToAddSubtypeAndValue(parameter, input);
            parameter.setValue(converter.castToDouble(input.get(4)));
        } catch (IndexOutOfBoundsException e) {
            parameter.setValue(null);
        }
        return parameter;
    }

    private DoubleTypeParameter tryToAddSubtypeAndValue(DoubleTypeParameter param, List<String> list) {
        String value = list.get(4);

        String breakPoint = "6 - 44, 49 , 48,5";
        if (breakPoint.equals(value))
            System.out.println(breakPoint);

        param = tryToGetSubType(value, param);

        value = cleanStringAfterGetSubtype(value);

        param.setValue(
                calcAverage(
                        splitStringToStringList(value)));

//                throw new ArithmeticException(ParamFactoryStatusEnum.DOUBLE_PARAMETER_BUILDER_SUBTYPE_ERR.toString());

        return param;
    }

    private String cleanStringAfterGetSubtype(String input) {
        return input.replace(".+- ", "");
    }

    private DoubleTypeParameter tryToGetSubType(String inputStr, DoubleTypeParameter parameter) {
        List<String> result;

        if (inputStr.matches(" - ")){
            inputStr = cleanStringAfterGetSubtype(inputStr);
            parameter.setSubtype(inputStr);
        }

        return parameter;
    }

    private Double calcAverage(List<String> input) {
        OptionalDouble result = input.stream()
                .mapToDouble(Double::parseDouble)
                .average();
        if (result.isPresent())
            return result.getAsDouble();
        else
            throw new ArithmeticException();
    }

    private List<String> splitStringToStringList(String input) {
        List<String> result;
        input = prepareFractionAndDeleteSpaces(input);

        result = Arrays.asList(input.split(","));

        if (result.size() < 2)
            result = Arrays.asList(input.split("/"));

        return result;
    }

    private String prepareFractionAndDeleteSpaces(String input) {
        return input
                .replace(",[0-9]{1,3}", ".")
                .replace(" ", "");
    }
}
