package object_creation.param;

import domain.DoubleTypeParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import object_creation.creation_utils.Builder;
import object_creation.creation_utils.StringValueConverter;
import config.TestCardColumnsNumbers;
import config.TestCardConfig;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

@RequiredArgsConstructor
public class DoubleTypeParamBuilder implements Builder<DoubleTypeParam, List<String>> {

    @NonNull
    private TestCardConfig config;

    @Override
    public DoubleTypeParam build(List<String> input) {
        StringValueConverter converter = new StringValueConverter();
        TestCardColumnsNumbers columnsNumbers = config.getColumnsNumbers();

        String punctation;
        String value;

        DoubleTypeParam parameter = new DoubleTypeParam(input.get(columnsNumbers.getNameInPolishColumnNumber()));

        try {
            punctation = input.get(columnsNumbers.getPunctationColumnNumber());
            if (punctation != null || !punctation.equals(""))
                parameter.setPunctation(converter.castToInteger(punctation));
        } catch (IndexOutOfBoundsException | NullPointerException e) {

        }

        try {
            parameter.setType(input.get(columnsNumbers.getParamTypeColumnNumber()));
        } catch (IndexOutOfBoundsException | NullPointerException e) {
//            parameter.setType(null);
        }

        try {
            parameter.setDeclaredValue(converter.castToDouble(input.get(columnsNumbers.getDeclaredValuesColumnNumber())));
        } catch (IndexOutOfBoundsException e) {
//            parameter.setDeclaredValue(null);
        }

        try {
            value = input.get(columnsNumbers.getMeasuredValuesColumnNumber());
            parameter.setValueString(value);

            Double average = calcAverageInComplexString(value);
            if (average != null)
                parameter.setMeasuredValue(average);
            else
                parameter.setMeasuredValue(converter.castToDouble(value));

        } catch (IndexOutOfBoundsException e) {
//            parameter.setValueString(null);
//            parameter.setMeasuredValue(null);
        }
        return parameter;
    }

    public Double calcAverageInComplexString(String input) {
        List<String> stringList;
        Double average = null;

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
            return null;
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
