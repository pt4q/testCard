package object_creation.test_card.config;

import java.util.List;
import java.util.stream.Collectors;

public class BinaryTypePositiveDefinition {

    private List<String> definedPositives;

    public BinaryTypePositiveDefinition(List<String> definedPositives) {
        this.definedPositives = changeAllPositivesToLowerCase(definedPositives);
    }

    private List<String> changeAllPositivesToLowerCase(List<String> input) {
        return input.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    public boolean checkIsPositive(String input) {
        input = input.toLowerCase();

        for (String definedPositive : definedPositives) {
            if (definedPositive.equals(input))
                return true;
        }
        return false;
    }
}
