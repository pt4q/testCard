package object_creation.param;

import domain.DoubleTypeParameter;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringMatcher;
import object_creation.creation_utils.StringValueConverter;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

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
                parameter.setPunctation(converter.castToInteger(punctation));
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            System.out.println();
        }

        try {
            value = input.get(4);
            parameter.setValueString(value);

            parameter.setValue(calcAverageInComplexString(value));

            parameter.setValue(converter.castToDouble(value));
        } catch (IndexOutOfBoundsException e) {
            parameter.setValue(null);
        }
        return parameter;
    }

    public Double calcAverageInComplexString(String input) {
        List<String> stringList;
        Double average;

        input = changeCommaToPointInFraction(input);
        input = deleteNonDoubleCharSequence(input);
        input = changePointBetweenNumbers(input);
        input = deleteSpaces(input);

        stringList = splitStringToStringList(input, "/");

        if (stringList.size() < 2)
            stringList = splitStringToStringList(input, ",");

        average = calcAverage(stringList);

        return average;
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

    public List<String> splitStringToStringList(String input, String splitStr) {
        return Arrays.asList(input.split(splitStr));
    }

    public String changePointBetweenNumbers(String input) {
        return input.replaceAll("(\\. )", ",");
    }

    public String changeCommaToPointInFraction(String input) {
        return input.replaceAll(",", ".");
    }

    public String deleteNonDoubleCharSequence(String input) {
        return input.replaceAll("([0-9]{1,}[ ]*[-]{1}[ ]*)", "");
    }

    public String deleteSpaces(String input) {
        return input.replaceAll(" ", "");
    }
}
