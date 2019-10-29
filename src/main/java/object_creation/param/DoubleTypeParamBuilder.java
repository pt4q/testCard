package object_creation.param;

import domain.DoubleTypeParameter;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringValueConverter;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class DoubleTypeParamBuilder implements Builder<DoubleTypeParameter, List<String>> {

    @Override
    public DoubleTypeParameter build(List<String> input) {
        StringValueConverter converter = new StringValueConverter();

        String brakePoint = "3,5 / 3,2";

        String punctation;
        String value;

        if (input.get(4).equals(brakePoint))
            System.out.println(">>> " + input.get(1)); // breakpoint

        DoubleTypeParameter parameter = new DoubleTypeParameter().builder()
                .nameInPolish(input.get(1))
                .build();

        try {
            punctation = input.get(2);
            if (punctation != null || !punctation.equals(""))
                parameter.setPunctation(converter.castToInteger());
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            System.out.println();
        }

        try {
            value = input.get(4);
            parameter.setValueString(value);

            parameter.setValue(calcAverageInComplexString(parameter, input));

            parameter.setValue(converter.castToDouble(value));
        } catch (IndexOutOfBoundsException e) {
            parameter.setValue(null);
        }
        return parameter;
    }

    public Double calcAverageInComplexString(String input) {

        String breakPoint = "6 - 44, 49 , 48,5";
        if (breakPoint.equals(input))
            System.out.println(breakPoint);

        List<String> stringList = splitStringToStringList(input);


        return calcAverage(stringList);
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
