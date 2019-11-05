package config;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class BinaryTypePositiveDefinition {

    @NonNull
    private List<String> definedPositives;
    @NonNull
    private String positive;
    @NonNull
    private String negative;

//    public BinaryTypePositiveDefinition(List<String> definedPositives, String positive, String negative) {
//        this.definedPositives = changeAllPositivesToLowerCase(definedPositives);
//        this.positive = positive;
//        this.negative = negative;
//    }

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
